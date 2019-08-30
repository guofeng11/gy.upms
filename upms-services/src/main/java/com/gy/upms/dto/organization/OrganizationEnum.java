package com.gy.upms.dto.organization;

/**
 * @ClassName OrganizationEnum.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 13:46:00
 */
public class OrganizationEnum {
    /**
     * 组织关系类别
     */
    public enum OrganizationType{
        Department("D"),Organization("O");
        private String typeCode;

        public String getTypeCode() {
            return typeCode;
        }

        private  OrganizationType(String typeCode){
            this.typeCode=typeCode;
        }
    }

    /**
     * 组织用于TureFalse等状态枚举
     * true=1 false=0
     */
    public enum OrganizationTrueFalse{

        True(0),False(1);

        private int code;

        public int getTypeCode() {
            return code;
        }

        private  OrganizationTrueFalse(int code){
            this.code=code;
        }
    }
}
