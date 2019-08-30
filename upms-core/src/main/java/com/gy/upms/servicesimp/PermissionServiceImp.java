package com.gy.upms.servicesimp;

import com.gy.upms.component.JacksonUtils;
import com.gy.upms.component.MessageUtils;
import com.gy.upms.component.VerifyUtils;
import com.gy.upms.dao.PermissionMapper;
import com.gy.upms.dto.ResultMessage;
import com.gy.upms.dto.permission.UserPermission;
import com.gy.upms.dto.permission.UserPermissionResult;
import com.gy.upms.entity.Permission;
import com.gy.upms.services.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
