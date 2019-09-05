package com.gy.upms.dto.permission;

/**
 * @Auther: guofeng
 * @Date: 2019/6/17 15:09
 * @Description:
 */
public class PermissionEnum {
    /**
     * 权限状态
     *  NORMAL正常 DISABLED 禁用
     */
    public  enum  PermissionStatus{
        NORMAL(1),DISABLED(2),;
        private int status;

        public int getStatus() {
            return status;
        }

        private PermissionStatus(int status){
            this.status=status;
        }
    }

}
