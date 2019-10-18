package com.gy.upms.servicesimp;

import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.MessageUtils;
import com.gy.upms.dao.RoleMapper;
import com.gy.upms.dao.RolePermMapper;
import com.gy.upms.dao.UserRoleMapper;
import com.gy.upms.dto.OutPage;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.role.*;
import com.gy.upms.entity.*;
import com.gy.upms.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @ClassName RoleServiceImp.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月04日 11:24:00
 */
@RestController
@RequestMapping("/role")
public class RoleServiceImp implements RoleService {
    private final static Logger log = LoggerFactory.getLogger(RoleServiceImp.class);
    @Autowired
    private MessageUtils messageUtils;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolePermMapper rolePermMapper;

    @PostMapping("/add")
    @Override
    public ResultMessage<String> add(@RequestBody AddRole data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();
            Role searchCondition=new Role();
            searchCondition.setRoleName(data.getRoleName());
            int isEexists =roleMapper.select(searchCondition).size();
            if (isEexists>0){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ROLE.FIELD.NAME.ZH");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            Role insertRole=new Role();
            insertRole.setRoleName(data.getRoleName());
            insertRole.setRoleNameEn(data.getRoleNameEn());
            insertRole.setSortOrder(data.getSortOrder());
            insertRole.setStatus(RoleEnum.RoleStatus.NORMAL.getStatus());
            insertRole.setRemark(data.getRemark());
            insertRole.setCreaterId(data.getUserSecurity().getId());
            insertRole.setCreater(data.getCreater());
            insertRole.setCreateTime(nowTime);

            int row = roleMapper.insert(insertRole);
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/edit")
    @Override
    public ResultMessage<String> edit(@RequestBody EditRole data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();

            Role roleExists =roleMapper.selectByPrimaryKey(data.getId());
            if (roleExists==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ROLE.FIELD.ID");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }

            roleExists.setRoleName(data.getRoleName());
            roleExists.setRoleNameEn(data.getRoleNameEn());
            roleExists.setSortOrder(data.getSortOrder());
            roleExists.setRemark(data.getRemark());
            roleExists.setCreaterId(data.getUserSecurity().getId());
            roleExists.setCreater(data.getCreater());
            roleExists.setCreateTime(nowTime);

            int row = roleMapper.updateByPrimaryKeySelective(roleExists);
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/detail")
    @Override
    public ResultMessage<DetailRoleResult> detail(@RequestBody DetailRole data) {
        ResultMessage<DetailRoleResult> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"), null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();

            Role roleExists = roleMapper.selectByPrimaryKey(data.getId());
            if (roleExists == null) {
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ROLE.FIELD.ID");
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, message, null);
                return resultMessage;
            }
            DetailRoleResult detailRoleResult = new DetailRoleResult();
            detailRoleResult.setId(roleExists.getId());
            detailRoleResult.setRoleName(roleExists.getRoleName());
            detailRoleResult.setRoleNameEn(roleExists.getRoleNameEn());
            detailRoleResult.setSortOrder(roleExists.getSortOrder());
            detailRoleResult.setRemark(roleExists.getRemark());


            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS, detailRoleResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"), null);
            return resultMessage;
        }
    }
    @PostMapping("/delete")
    @Override
    public ResultMessage<String> delete(@RequestBody DeleteRole data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }


            int row = roleMapper.deleteByPrimaryKey(data.getId());
            if (row > 0) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.SUCCESS);
            } else {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.FAIL);
            }
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/search")
    @Override
    public ResultMessage<PageResult<SearchRoleResult>> search(@RequestBody SearchRole data) {
        ResultMessage<PageResult<SearchRoleResult>> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<PageResult<SearchRoleResult>>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"), null);
                return resultMessage;
            }

            Role searchCondition = new Role();
            searchCondition.setStatus(data.getStatus());
            searchCondition.setRoleName(data.getRoleName());

            int offset = (data.getPage().getCurrentPage() - 1) * data.getPage().getPageRows();
            Pageing<Role> searchPageing = roleMapper.selectByPage(searchCondition, offset, data.getPage().getPageRows());
            OutPage outPage = new OutPage();
            outPage.setTotalRows(searchPageing.getRows().getTotalRows());
            outPage.setTotalPage(searchPageing.getRows().getTotalPage());
            List<SearchRoleResult> searchResultList = searchPageing.getDataList().stream()
                    .map(c -> new SearchRoleResult(c.getId(),c.getRoleName(),c.getRoleNameEn(),c.getSortOrder(),c.getStatus()))
                    .collect(Collectors.toList());
            PageResult<SearchRoleResult> pageResult = new PageResult<SearchRoleResult>();
            pageResult.setPage(outPage);
            pageResult.setData(searchResultList);

            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS, pageResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"), null);
            return resultMessage;
        }
    }
    @PostMapping("/user/set")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMessage<String> setRoleUser(@RequestBody SetRoleUser data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            Role roleExists =roleMapper.selectByPrimaryKey(data.getId());
            if (roleExists==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ROLE.FIELD.ID");
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }

            if (data.getUserIds()==null ||data.getUserIds().size()==0){
                userRoleMapper.deleteByRoleId(data.getId());
            }else {

                List<UserRole> userRoles = userRoleMapper.selectByRoleId(data.getId());
                //数据库中不存在用户与角色的关系 全部插入
                if (userRoles == null || userRoles.size() == 0) {
                    List<UserRole> inserRoleUser = data.getUserIds().stream()
                            .map(d -> new UserRole(UUID.randomUUID().toString(),d,data.getId()))
                            .collect(Collectors.toList());
                    userRoleMapper.bulkInsert(inserRoleUser);
                } else {
                    //删除数据，参数中不在数据库的授权
                    List<String> deleteIds = userRoles.stream()
                            .filter(uo -> !data.getUserIds().stream()
                                    .anyMatch(d -> d == uo.getUserId()))
                            .map(au -> au.getId()).collect(Collectors.toList());
                    userRoleMapper.bulkDeleteByKey(deleteIds);
                    //新增数据，数据库不在参数中的授权
                    List<UserRole> inserRoleUser = data.getUserIds().stream()
                            .filter(d -> !userRoles.stream().anyMatch(uo -> d == uo.getUserId()))
                            .map(a -> new UserRole(UUID.randomUUID().toString(), a, data.getId()))
                            .collect(Collectors.toList());
                    userRoleMapper.bulkInsert(inserRoleUser);
                }
            }
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS);
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/user/get")
    @Override
    public ResultMessage<List<GetRoleUserResult>> getRoleUser(@RequestBody GetRoleUser data) {
        ResultMessage<List<GetRoleUserResult>> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<List<GetRoleUserResult>>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            //查询授权的权限
            List<UserAccount> userAccounts=userRoleMapper.selectByRoleIdForUserAccount(data.getId());



            List<GetRoleUserResult> userResults=userAccounts.stream()
                    .map(p-> new GetRoleUserResult(p.getId(),p.getNickname(),p.getPhone(),p.getEmail()))
                    .collect(Collectors.toList());


            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS,userResults);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/perm/set")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultMessage<String> setRolePerm(@RequestBody SetRolePerm data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            Role roleExists =roleMapper.selectByPrimaryKey(data.getId());
            if (roleExists==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "ROLE.FIELD.ID");
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }

            if (data.getPermIds()==null ||data.getPermIds().size()==0){
                rolePermMapper.deleteByRoleId(data.getId());
            }else {

                List<RolePerm> rolePerms = rolePermMapper.selectByRoleId(data.getId());
                //数据库中不存在用户与角色的关系 全部插入
                if (rolePerms == null || rolePerms.size() == 0) {
                    List<RolePerm> inserRolePerms = data.getPermIds().stream()
                            .map(d -> new RolePerm(UUID.randomUUID().toString(),data.getId(),d))
                            .collect(Collectors.toList());
                    rolePermMapper.bulkInsert(inserRolePerms);
                } else {
                    //删除数据，参数中不在数据库的授权
                    List<String> deleteIds = rolePerms.stream()
                            .filter(uo -> !data.getPermIds().stream()
                                    .anyMatch(d -> d == uo.getPermId()))
                            .map(au -> au.getId()).collect(Collectors.toList());
                    rolePermMapper.bulkDeleteByKey(deleteIds);
                    //新增数据，数据库不在参数中的授权
                    List<RolePerm> inserRolePerms = data.getPermIds().stream()
                            .filter(d -> !rolePerms.stream().anyMatch(uo -> d == uo.getPermId()))
                            .map(a -> new RolePerm(UUID.randomUUID().toString(), a, data.getId()))
                            .collect(Collectors.toList());
                    rolePermMapper.bulkInsert(inserRolePerms);
                }
            }
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS);
            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<String>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
    @PostMapping("/perm/get")
    @Override
    public ResultMessage<List<GetRolePermResult>> getRolePerm(@RequestBody GetRolePerm data) {
        ResultMessage<List<GetRolePermResult>> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            //查询授权的权限
            List<Permission> permissionList=rolePermMapper.selectByRoleIdForPermission(data.getId());



            List<GetRolePermResult> userResults=permissionList.stream()
                    .map(p-> new GetRolePermResult(p.getId(),p.getAppId(),p.getPermKey(),p.getPermNameCn(),p.getPermNameEn(),p.getSortOrder()
                    ,p.getLevel(),p.getParentId()))
                    .collect(Collectors.toList());


            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS,userResults);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"),null);
            return resultMessage;
        }
    }
}
