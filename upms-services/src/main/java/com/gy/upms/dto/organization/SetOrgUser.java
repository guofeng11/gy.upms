package com.gy.upms.dto.organization;

import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName SetOrgUser.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 14:01:00
 */
public class SetOrgUser implements Serializable {

    private static final long serialVersionUID = -8378505269658615541L;

    @Min(value = 1,message = "{user.id.notNull}")
    private Integer orgId;

    private List<UserReadWrite> userReadWrite;


    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;



    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }



    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }

    public List<UserReadWrite> getUserReadWrite() {
        return userReadWrite;
    }

    public void setUserReadWrite(List<UserReadWrite> userReadWrite) {
        this.userReadWrite = userReadWrite;
    }

    public UserReadWrite builtUserReadWrite(Integer userId,Integer isRead,Integer isWrite){
        UserReadWrite userReadWrite=new UserReadWrite();
        userReadWrite.setUserId(userId);
        userReadWrite.setIsRead(isRead);
        userReadWrite.setIsWrite(isWrite);
        return userReadWrite;
    }
  public  class UserReadWrite{
        @Min(value = 1,message = "{organization.id.notNull}")
        private Integer userId;
        @Min(value = 0,message = "{organization.user.readwrite}")
        @Max(value  =1,message = "{organization.user.readwrite}")
        private Integer isRead;
        @Min(value = 0,message = "{organization.user.readwrite}")
        @Max(value  =1,message = "{organization.user.readwrite}")
        private Integer isWrite;
        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }
        public Integer getIsRead() {
            return isRead;
        }

        public void setIsRead(Integer isRead) {
            this.isRead = isRead;
        }

        public Integer getIsWrite() {
            return isWrite;
        }

        public void setIsWrite(Integer isWrite) {
            this.isWrite = isWrite;
        }

        public UserReadWrite() {
        }

    }
}
