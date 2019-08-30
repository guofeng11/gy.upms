package com.gy.upms.dto.application;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/13 14:57
 * @Description:
 */
public class GetAppResult implements Serializable {

    private static final long serialVersionUID = -5861512300378437943L;


        private Integer appId;

        private Integer authAppId;

        private Integer permId;

        public Integer getAppId() {
            return appId;
        }

        public void setAppId(Integer appId) {
            this.appId = appId;
        }

        public Integer getAuthAppId() {
            return authAppId;
        }

        public void setAuthAppId(Integer authAppId) {
            this.authAppId = authAppId;
        }

        public Integer getPermId() {
            return permId;
        }

        public void setPermId(Integer permId) {
            this.permId = permId;
        }

        public GetAppResult() {
        }

        public GetAppResult(Integer appId, Integer authAppId, Integer permId) {
            this.appId = appId;
            this.authAppId = authAppId;
            this.permId = permId;
        }

}
