package com.gy.upms.servicesimp;

import com.gy.commons.encrypt.Base64_GY;
import com.gy.commons.encrypt.OneWay;
import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.MessageUtils;
import com.gy.upms.component.VerifyUtils;
import com.gy.upms.dao.UserAccountMapper;
import com.gy.upms.dao.UserLoginMapper;
import com.gy.upms.dto.OutPage;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.user.*;
import com.gy.upms.entity.Pageing;
import com.gy.upms.entity.UserAccount;
import com.gy.upms.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Auther: guofeng
 * @Date: 2019/4/25 14:51
 * @Description:
 */
@RestController
@RequestMapping(path="/user")
public class UserServiceImp implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImp.class);


    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private MessageUtils messageUtils;

    @Override
    @PostMapping(path = "/login/{type}")
    public ResultMessage<LoginResult> login(@RequestBody Login login, @PathVariable("type") String userType) {
        ResultMessage<LoginResult> resultMessage = null;
        try {
            if (login == null) {
                resultMessage = new ResultMessage<LoginResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"));
                return resultMessage;
            }
            if (login.getUserName() == null || login.getUserName().isEmpty() || login.getPassword() == null || login.getPassword().isEmpty()) {
                resultMessage = new ResultMessage<LoginResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("USER.ERROR.USERNAMEANDPASSWORD"));
                return resultMessage;
            }
            LocalDateTime dateTime = LocalDateTime.now();
            //密码处理 数据传输密码 不可明文
            String pwd = getPwd(login.getPassword(), login.getUserName());
            //查询用户
            UserAccount userAccount = userAccountMapper.login(login.getUserName(), pwd);
            if (userAccount == null) {
                resultMessage = new ResultMessage<LoginResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("USER.ERROR.USERNAMEANDPASSWORD"));
                return resultMessage;
            }

            //判断登录类型
            if (userType != null || !userType.isEmpty()) {
                if (!userAccount.getUsertype().toLowerCase().equals(userType.toLowerCase())) {
                    resultMessage = new ResultMessage<LoginResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("USER.ERROR.USERNAMEANDPASSWORD"));
                    return resultMessage;
                }
            } else {
                //如果url参数为空 必需是客户端登录
                if (!userAccount.getUsertype().toLowerCase().equals(UserEnum.UserType.C.getUserType().toLowerCase())) {
                    resultMessage = new ResultMessage<LoginResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("USER.ERROR.USERNAMEANDPASSWORD"));
                    return resultMessage;
                }
            }
            if (userAccount.getStatus() != UserEnum.UserStatus.NORMAL.getStatus()) {
                resultMessage = new ResultMessage<LoginResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("USER.ERROR.USER"));
                return resultMessage;
            }
            //用户存在 生成登录信息
            String token = VerifyUtils.setUserLogin(userAccount, dateTime);


            LoginResult loginResult = new LoginResult(userAccount.getId(), userAccount.getUsername(), userAccount.getNickname(),
                    token, userAccount.getEmail(), userAccount.getPhone(), userAccount.getUsertype(), userAccount.getComeform(),
                    userAccount.getUserlevel(), userAccount.getOrgId(), userAccount.getJobtitleId());

            resultMessage = new ResultMessage<LoginResult>(ResultMessage.ResultType.SUCCESS, messageUtils.getMessage("BASE.SUCCESS"), loginResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(login);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<LoginResult>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"));
            return resultMessage;
        }

    }

    @Override
    @PostMapping("/register")
    public ResultMessage<RegisterResult> register(@RequestBody Register register) {
        ResultMessage<RegisterResult> resultMessage = null;
        try {
            if (register == null) {
                resultMessage = new ResultMessage<RegisterResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"));
                return resultMessage;
            }
            if (register.getUsername() == null || register.getUsername().isEmpty() || register.getPassword() == null || register.getPassword().isEmpty()) {
                resultMessage = new ResultMessage<RegisterResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("USER.ERROR.USERNAMEANDPASSWORD"));
                return resultMessage;
            }
            if (register.getPhone() == null || register.getPhone().isEmpty()) {
                String message = messageUtils.getMessageFormate("USER.ERROR.USERNAMEANDPASSWORD", "USER.FILED.PHONE");
                resultMessage = new ResultMessage<RegisterResult>(ResultMessage.ResultType.ARGSVALIDATION, message);
                return resultMessage;
            }
            if (register.getEmail() == null || register.getEmail().isEmpty()) {
                String message = messageUtils.getMessageFormate("USER.ERROR.USERNAMEANDPASSWORD", "USER.FIELD.EMAIL");
                resultMessage = new ResultMessage<RegisterResult>(ResultMessage.ResultType.ARGSVALIDATION, message);
                return resultMessage;
            }
            String pwd = getPwd(register.getPassword(), register.getUsername());


            LocalDateTime nowTime = LocalDateTime.now();

            // 验证用户是否已经存在
            int count = userAccountMapper.countUser(register.getUsername(), register.getPhone(), register.getEmail());
            if (count > 0) {
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "USER.FIELD.USERNAME");
                resultMessage = new ResultMessage<RegisterResult>(ResultMessage.ResultType.ARGSVALIDATION, message);
                return resultMessage;
            }

            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(register.getUsername());
            userAccount.setNickname(register.getNickname());
            userAccount.setPassword(pwd);
            userAccount.setPhone(register.getPhone());
            userAccount.setEmail(register.getEmail());
            userAccount.setUserlevel(1);
            userAccount.setComeform(UserEnum.UserComefrom.R.getComefrom());
            userAccount.setUsertype(UserEnum.UserType.C.getUserType());
            userAccount.setStatus(UserEnum.UserStatus.NORMAL.getStatus());
            userAccount.setOrgId(1);
            userAccount.setJobtitleId(1);
            userAccount.setCreaterId(0);
            userAccount.setCreater(register.getUsername());
            userAccount.setCreatetime(nowTime);

            int row = userAccountMapper.insert(userAccount);
            if (row > 0) {
                //用户存在 生成登录信息
                String token = VerifyUtils.setUserLogin(userAccount, nowTime);

                RegisterResult registerResult = new RegisterResult(userAccount.getId(), userAccount.getUsername(), userAccount.getNickname(),
                        token, userAccount.getEmail(), userAccount.getPhone(), userAccount.getUsertype(), userAccount.getComeform(), userAccount.getUserlevel()
                        , userAccount.getOrgId(), userAccount.getJobtitleId());
                resultMessage = new ResultMessage<RegisterResult>(ResultMessage.ResultType.SUCCESS, registerResult);
            } else {
                resultMessage = new ResultMessage<RegisterResult>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(register);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<RegisterResult>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"));
            return resultMessage;
        }
    }

    @Override
    @PostMapping("/add")
    public ResultMessage<AddUserResult> add(@RequestBody AddUser addUser) {
        ResultMessage<AddUserResult> resultMessage = null;
        try {
            if (addUser == null) {
                resultMessage = new ResultMessage<AddUserResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"));
                return resultMessage;
            }
            if (addUser.getUsername() == null || addUser.getUsername().isEmpty() || addUser.getPassword() == null || addUser.getPassword().isEmpty()) {
                resultMessage = new ResultMessage<AddUserResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("USER.ERROR.USERNAMEANDPASSWORD"));
                return resultMessage;
            }
            if (addUser.getPhone() == null || addUser.getPhone().isEmpty()) {
                String message = messageUtils.getMessageFormate("USER.ERROR.USERNAMEANDPASSWORD", "USER.FILED.PHONE");
                resultMessage = new ResultMessage<AddUserResult>(ResultMessage.ResultType.ARGSVALIDATION, message);
                return resultMessage;
            }
            if (addUser.getEmail() == null || addUser.getEmail().isEmpty()) {
                String message = messageUtils.getMessageFormate("USER.ERROR.USERNAMEANDPASSWORD", "USER.FIELD.EMAIL");
                resultMessage = new ResultMessage<AddUserResult>(ResultMessage.ResultType.ARGSVALIDATION, message);
                return resultMessage;
            }
            //处理密码
            String pwd = getPwd(addUser.getPassword(), addUser.getUsername());


            LocalDateTime nowTime = LocalDateTime.now();

            // 验证用户是否已经存在
            int count = userAccountMapper.countUser(addUser.getUsername(), addUser.getPhone(), addUser.getEmail());
            if (count > 0) {
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "USER.FIELD.USERNAME");
                resultMessage = new ResultMessage<AddUserResult>(ResultMessage.ResultType.ARGSVALIDATION, message);
                return resultMessage;
            }

            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(addUser.getUsername());
            userAccount.setNickname(addUser.getNickname());
            userAccount.setPassword(pwd);
            userAccount.setPhone(addUser.getPhone());
            userAccount.setEmail(addUser.getEmail());
            userAccount.setUserlevel(1);
            userAccount.setComeform(UserEnum.UserComefrom.M.getComefrom());
            userAccount.setUsertype(addUser.getUsertype());
            userAccount.setStatus(UserEnum.UserStatus.NORMAL.getStatus());
            userAccount.setOrgId(addUser.getOrgId());
            userAccount.setJobtitleId(addUser.getJobtitleId());
            userAccount.setCreaterId(addUser.getUserSecurity().getId());
            userAccount.setCreater(addUser.getCreater());
            userAccount.setCreatetime(nowTime);

            int row = userAccountMapper.insert(userAccount);
            if (row > 0) {
                //用户存在 生成登录信息
                String token = VerifyUtils.setUserLogin(userAccount, nowTime);

                AddUserResult AddUserResult = new AddUserResult(userAccount.getId(), userAccount.getUsername(), userAccount.getNickname(),
                        userAccount.getEmail(), userAccount.getPhone(), userAccount.getUsertype(), userAccount.getComeform(), userAccount.getUserlevel()
                        , userAccount.getOrgId(), userAccount.getJobtitleId());
                resultMessage = new ResultMessage<AddUserResult>(ResultMessage.ResultType.SUCCESS, AddUserResult);
            } else {
                resultMessage = new ResultMessage<AddUserResult>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(addUser);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<AddUserResult>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"));
            return resultMessage;
        }
    }

    @Override
    @PostMapping("/get/all")
    public ResultMessage<PageResult<SearchUserResult>> search(@RequestBody SearchUser searchUser) {
        ResultMessage<PageResult<SearchUserResult>> resultMessage = null;
        try {
            if (searchUser == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"));
                return resultMessage;
            }
            if (searchUser.getPage() == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.EEROR.PAGE"));
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();


            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(searchUser.getUsername());
            userAccount.setPhone(searchUser.getPhone());
            userAccount.setEmail(searchUser.getEmail());
            userAccount.setUserlevel(searchUser.getUserlevel());
            userAccount.setComeform(searchUser.getComeform());
            userAccount.setUsertype(searchUser.getUsertype());
            userAccount.setStatus(searchUser.getStatus());
            userAccount.setOrgId(searchUser.getOrgId());
            userAccount.setJobtitleId(searchUser.getJobtitleId());

            int skip = (searchUser.getPage().getCurrentPage() - 1) * searchUser.getPage().getPageRows();
            Pageing<UserAccount> userAccountPageing = userAccountMapper.selectByPage(userAccount, skip, searchUser.getPage().getPageRows());

            OutPage page = new OutPage(userAccountPageing.getRows().getTotalPage(), userAccountPageing.getRows().getTotalRows());

            List<SearchUserResult> usersList = new ArrayList<SearchUserResult>();
            for (UserAccount ua : userAccountPageing.getDataList()) {
                SearchUserResult user = new SearchUserResult(ua.getId(), ua.getUsername(), ua.getNickname(), ua.getEmail()
                        , ua.getPhone(), ua.getUsertype(), ua.getComeform(), ua.getUserlevel(), ua.getOrgId(), ua.getJobtitleId()
                        , ua.getCreatetime().format(DateTimeFormatter.ofPattern(messageUtils.getMessage("BASE.FORMATE.DATETIME"))));
                usersList.add(user);
            }
            PageResult<SearchUserResult> pageResult = new PageResult<>(page, usersList);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS, pageResult);
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(searchUser);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"));
            return resultMessage;
        }
    }

    @Override
    @PostMapping("/delete")
    public ResultMessage<String> delete(@RequestBody DeleteUser deleteUser) {
        ResultMessage<String> resultMessage = null;
        try {
            if (deleteUser == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            int row = userAccountMapper.bulkDelete( Arrays.asList(deleteUser.getIds()));
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(deleteUser);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }

    @Override
    @PostMapping("/detail")
    public ResultMessage<DetailUserResult> detail(@RequestBody DetailUser detailUser) {
        ResultMessage<DetailUserResult> resultMessage = null;
        try {
            if (detailUser == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }
            UserAccount userAccount =userAccountMapper.selectByPrimaryKey(detailUser.getId());
            if (userAccount==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ORG.FIELD.ID");
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            DetailUserResult detailResult=new DetailUserResult();
            detailResult.setId(detailUser.getId());
            detailResult.setUsername(userAccount.getUsername());
            detailResult.setPhone(userAccount.getPhone());
            detailResult.setEmail(userAccount.getEmail());
            detailResult.setNickname(userAccount.getNickname());
            detailResult.setComeform(userAccount.getComeform());
            detailResult.setUsertype(userAccount.getUsertype());
            detailResult.setJobtitleId(userAccount.getJobtitleId());
            detailResult.setUserlevel(userAccount.getUserlevel());


            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS,detailResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(detailUser);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }


    /**
     * 密码加密处理
     *
     * @param password 用户输入的密码 base64加密
     * @param username 用户名
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    private String getPwd(String password, String username) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //处理密码
        String pwd = Base64_GY.decrypt(password);
        pwd = OneWay.encrypt(pwd, username, OneWay.Algorithm.MD5);
        return pwd;
    }
}


