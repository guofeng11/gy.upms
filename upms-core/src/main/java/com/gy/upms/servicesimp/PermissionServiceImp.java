package com.gy.upms.servicesimp;

import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.MessageUtils;
import com.gy.upms.component.VerifyUtils;
import com.gy.upms.dao.ApplicationMapper;
import com.gy.upms.dao.PermissionMapper;
import com.gy.upms.dto.OutPage;
import com.gy.upms.dto.PageResult;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.permission.*;
import com.gy.upms.entity.Application;
import com.gy.upms.entity.Pageing;
import com.gy.upms.entity.Permission;
import com.gy.upms.services.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @ClassName PermissionService.java
 * @Author guofe
 * @Description 权限服务
 * @Version 1.0.0
 * @Date 2019年07月25日 14:32:00
 */
@RestController
@RequestMapping(path="/permission")
public class PermissionServiceImp implements PermissionService {

    private final static Logger log = LoggerFactory.getLogger(PermissionServiceImp.class);
    @Autowired
    private MessageUtils messageUtils;

    private PermissionMapper permissionMapper;
    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }
    @Autowired
    private ApplicationMapper applicationMapper;
    @PostMapping("/add")
    @Override
    public ResultMessage<String> add(@RequestBody AddPermission data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            Application application=applicationMapper.selectByPrimaryKey(data.getAppId());
            if(application==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.NOTEXISTS", "APP.FIELD.ID");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            String permKey;
            if (data.getPermKey()==null ||data.getPermKey().isEmpty()){
                permKey= UUID.randomUUID().toString();
            }else{
                permKey=data.getPermKey();
            }
            LocalDateTime nowTime = LocalDateTime.now();

            Permission insertPermission=new Permission();
            insertPermission.setAppId(data.getAppId());
            insertPermission.setPermNameCn(data.getPermNameCn());
            insertPermission.setPermNameEn(data.getPermNameEn());
            insertPermission.setParentId(data.getParentId());
            insertPermission.setLevel(data.getLevel());
            insertPermission.setSortOrder(data.getSortOrder());
            insertPermission.setStatus(PermissionEnum.PermissionStatus.NORMAL.getStatus());
            insertPermission.setPermKey(permKey);
            insertPermission.setPermUrl(data.getPermUrl());
            insertPermission.setHttpMethod(data.getHttpMethod());
            insertPermission.setIsLogin(data.getIsLogin());
            insertPermission.setIsNavigation(data.getIsNavigation());
            insertPermission.setIco(data.getIco());
            insertPermission.setRemark(data.getRemark());
            insertPermission.setCreaterId(data.getUserSecurity().getId());
            insertPermission.setCreater(data.getCreater());
            insertPermission.setCreateTime(nowTime);

            int row = permissionMapper.insert(insertPermission);
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
    @PostMapping("/delete")
    @Override
    public ResultMessage<String> delete(@RequestBody DeletePermission data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }


            int row = permissionMapper.deleteByPrimaryKey(data.getId());
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
    public ResultMessage<String> edit(@RequestBody EditPermission data) {
        ResultMessage<String> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"),null);
                return resultMessage;
            }

            LocalDateTime nowTime = LocalDateTime.now();

            Permission permission =permissionMapper.selectByPrimaryKey(data.getId());
            if (permission==null){
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "PERM.FIELD.ID");
                resultMessage = new ResultMessage<String>(ResultMessage.ResultType.ARGSVALIDATION, message,null);
                return resultMessage;
            }
            Permission updatePermission=new Permission();
            updatePermission.setId(data.getId());
            updatePermission.setAppId(data.getAppId());
            updatePermission.setPermNameCn(data.getPermNameCn());
            updatePermission.setPermNameEn(data.getPermNameEn());
            updatePermission.setParentId(data.getParentId());
            updatePermission.setLevel(data.getLevel());
            updatePermission.setSortOrder(data.getSortOrder());
            updatePermission.setPermKey(data.getPermKey());
            updatePermission.setPermUrl(data.getPermUrl());
            updatePermission.setHttpMethod(data.getHttpMethod());
            updatePermission.setIsLogin(data.getIsLogin());
            updatePermission.setIsNavigation(data.getIsNavigation());
            updatePermission.setIco(data.getIco());
            updatePermission.setRemark(data.getRemark());
            updatePermission.setCreaterId(data.getUserSecurity().getId());
            updatePermission.setCreater(data.getCreater());
            updatePermission.setCreateTime(nowTime);

            int row = permissionMapper.updateByPrimaryKeySelective(updatePermission);
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
    public ResultMessage<DetailPermissionResult> detail(@RequestBody DetailPermission data) {
        ResultMessage<DetailPermissionResult> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"), null);
                return resultMessage;
            }
            Permission permission = permissionMapper.selectByPrimaryKey(data.getId());
            if (permission == null) {
                String message = messageUtils.getMessageFormate("BASE.FORMATE.EXISTS", "PERM.FIELD.ID");
                resultMessage = new ResultMessage<>(ResultMessage.ResultType.ARGSVALIDATION, message, null);
                return resultMessage;
            }
            DetailPermissionResult detailResult = new DetailPermissionResult();
            detailResult.setId(data.getId());
            detailResult.setAppId(permission.getAppId());
            detailResult.setPermNameCn(permission.getPermNameCn());
            detailResult.setPermNameEn(permission.getPermNameEn());
            detailResult.setParentId(permission.getParentId());
            detailResult.setLevel(permission.getLevel());
            detailResult.setSortOrder(permission.getSortOrder());
            detailResult.setPermKey(permission.getPermKey());
            detailResult.setPermUrl(permission.getPermUrl());
            detailResult.setHttpMethod(permission.getHttpMethod());
            detailResult.setIsLogin(permission.getIsLogin());
            detailResult.setIsNavigation(permission.getIsNavigation());
            detailResult.setIco(permission.getIco());

            resultMessage = new ResultMessage<>(ResultMessage.ResultType.SUCCESS, detailResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(data);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"), null);
            return resultMessage;
        }
    }
    @PostMapping("/search")
    @Override
    public ResultMessage<PageResult<SearchPermissionResult>> search(@RequestBody SearchPermission data) {
        ResultMessage<PageResult<SearchPermissionResult>> resultMessage = null;
        try {
            if (data == null) {
                resultMessage = new ResultMessage<PageResult<SearchPermissionResult>>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"), null);
                return resultMessage;
            }

            Permission searchCondition=new Permission();
            searchCondition.setId(data.getAppId());
            searchCondition.setStatus(data.getStatus());
            searchCondition.setPermKey(data.getPermKey());
            searchCondition.setLevel(data.getLevel());
            searchCondition.setParentId(data.getParentId());

            int offset = (data.getPage().getCurrentPage() - 1) * data.getPage().getPageRows();
            Pageing<Permission> permissionPageing = permissionMapper.selectByPage(searchCondition, offset, data.getPage().getPageRows());
            OutPage outPage = new OutPage();
            outPage.setTotalRows(permissionPageing.getRows().getTotalRows());
            outPage.setTotalPage(permissionPageing.getRows().getTotalPage());
            List<SearchPermissionResult> searchResultList = permissionPageing.getDataList().stream()
                    .map(c -> new SearchPermissionResult(c.getId(),c.getAppId(),c.getPermKey(),c.getPermNameCn(),c.getPermNameEn(),
                            c.getStatus(),c.getSortOrder(),c.getLevel(),c.getParentId(),c.getPermUrl(),c.getIsNavigation(),
                            c.getHttpMethod(),c.getIsLogin(),c.getIco()))
                    .collect(Collectors.toList());
            PageResult<SearchPermissionResult> pageResult = new PageResult<SearchPermissionResult>();
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

    /**
     * 获取用户权限许可
     * @param userPermission
     * @return 用户许可集
     */
    @Override
    @PostMapping("/user/get")
    public ResultMessage<UserPermissionResult> getUserPermission(@RequestBody UserPermission userPermission) {
        ResultMessage<UserPermissionResult> resultMessage = null;
        try {
            if (userPermission == null) {
                resultMessage = new ResultMessage<UserPermissionResult>(ResultMessage.ResultType.ARGSVALIDATION, messageUtils.getMessage("BASE.PARAMS.NULL"));
                return resultMessage;
            }
            Integer userId=userPermission.getUserSecurity().getId();
            //处理密码
            List<Permission> permissionList=VerifyUtils.getUserPerm(userId);

            UserPermissionResult permissionResult= new UserPermissionResult();
            permissionResult.setPermissionKey(permissionList.stream().map(p->p.getPermKey()).collect(Collectors.toList()));

            resultMessage = new ResultMessage<UserPermissionResult>(ResultMessage.ResultType.SUCCESS, permissionResult);

            return resultMessage;
        } catch (Exception ex) {
            String jsonData = JacksonUtils.obj2json(userPermission);
            log.error(jsonData, ex);
            resultMessage = new ResultMessage<UserPermissionResult>(ResultMessage.ResultType.EXCEPTION, messageUtils.getMessage("BASE.EXCEPTION"));
            return resultMessage;
        }
    }
}
