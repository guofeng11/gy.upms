package com.gy.upms.dto.role;

/**
 * @Auther: guofeng
 * @Date: 2019/6/17 15:11
 * @Description:
 */
public class RoleEnum {
    /**
     * 角色状态
     *  NORMAL正常 DISABLED 禁用
     */
    public  enum  RoleStatus{
        NORMAL(1),DISABLED(2),;
        private int status;

        public int getStatus() {
            return status;
        }

        private RoleStatus(int status){
            this.status=status;
        }
    }
}
