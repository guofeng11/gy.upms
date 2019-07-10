package com.gy.upms.dto.user;

import com.gy.upms.dto.UserSecurity;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 13:37
 * @Description:
 */
public class DeleteUser implements Serializable {
    private static final long serialVersionUID = -4879673178595476529L;

    private int[] ids;
    private UserSecurity userSecurity;

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
