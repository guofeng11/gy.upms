package com.gy.upms.dto.organization;

import java.io.Serializable;

/**
 * @ClassName GetOrgUserResult.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 14:02:00
 */
public class GetOrgUserResult implements Serializable {
    private static final long serialVersionUID = -8555331272969555131L;
    private Integer userId;

    private Integer isRead;
    private Integer isWrite;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public GetOrgUserResult() {
    }

    public GetOrgUserResult(Integer userId, Integer isRead, Integer isWrite) {
        this.userId = userId;
        this.isRead = isRead;
        this.isWrite = isWrite;
    }
}
