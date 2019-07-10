package com.gy.upms.dto.user;

/**
 * @Auther: guofeng
 * @Date: 2019/6/3 13:40
 * @Description:用户相关枚举
 */
public class UserEnum {
    /**
     * 用户类型
     * C 客户注册 M 后端用户 S 系统管理用户
     */
    public  enum UserType{
        C("C"),M("M"),S("S");

        private String userType;

        public String getUserType() {
            return userType;
        }

        private UserType(String type){
            this.userType=type;
        }
    }
    /**
     * 用户来源
     * R 客户注册 M 后端用户
     */
    public  enum UserComefrom{

        R(1),M(2);
        private int comefrom;

        public int getComefrom() {
            return comefrom;
        }

        private UserComefrom(int comefrom){
            this.comefrom=comefrom;
        }
    }

    /**
     * 用户状态
     * DELETE 删除 NORMAL正常 DISABLED 禁用
     */
    public  enum  UserStatus{
        DELETE(0),NORMAL(1),DISABLED(2);
        private int status;

        public int getStatus() {
            return status;
        }

        private UserStatus(int status){
            this.status=status;
        }
    }
}
