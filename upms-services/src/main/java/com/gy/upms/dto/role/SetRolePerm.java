package com.gy.upms.dto.role;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName SetRolePerm.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月02日 17:37:00
 */
public class SetRolePerm implements Serializable {
    private static final long serialVersionUID = 4326071398080285426L;
    @Min(value =1 ,message = "{role.id.notNull}")
    private  Integer id;

    private List<Integer> permIds;

    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getPermIds() {
        return permIds;
    }

    public void setPermIds(List<Integer> permIds) {
        this.permIds = permIds;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
