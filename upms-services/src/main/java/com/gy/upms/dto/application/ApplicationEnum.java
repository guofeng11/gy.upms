package com.gy.upms.dto.application;

/**
 * @Auther: guofeng
 * @Date: 2019/6/14 13:31
 * @Description:
 */
public class ApplicationEnum {
    /**
     * 应用程序状态
     * DELETE 删除 NORMAL正常 DISABLED 禁用
     */
    public  enum  ApplicationStatus{
        DELETE(0),NORMAL(1),DISABLED(2),;
        private int status;

        public int getStatus() {
            return status;
        }

        private ApplicationStatus(int status){
            this.status=status;
        }
    }
}
