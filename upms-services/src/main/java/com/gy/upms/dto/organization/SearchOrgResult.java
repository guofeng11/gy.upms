package com.gy.upms.dto.organization;

import java.io.Serializable;

/**
 * @ClassName SearchOrgResult.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 13:53:00
 */
public class SearchOrgResult implements Serializable {
    private static final long serialVersionUID = 6175057150031623551L;
    private Integer orgId;

    private String orgCode;

    private String orgNameCn;

    private String orgNameEn;

    private String abbrNameCn;

    private String orgType;

    private String abbrNameEn;

    private Integer level;

    private Integer parentId;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgNameCn() {
        return orgNameCn;
    }

    public void setOrgNameCn(String orgNameCn) {
        this.orgNameCn = orgNameCn;
    }

    public String getOrgNameEn() {
        return orgNameEn;
    }

    public void setOrgNameEn(String orgNameEn) {
        this.orgNameEn = orgNameEn;
    }

    public String getAbbrNameCn() {
        return abbrNameCn;
    }

    public void setAbbrNameCn(String abbrNameCn) {
        this.abbrNameCn = abbrNameCn;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getAbbrNameEn() {
        return abbrNameEn;
    }

    public void setAbbrNameEn(String abbrNameEn) {
        this.abbrNameEn = abbrNameEn;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public SearchOrgResult(Integer orgId, String orgCode, String orgNameCn, String orgNameEn, String abbrNameCn,  String abbrNameEn,String orgType, Integer level, Integer parentId) {
        this.orgId = orgId;
        this.orgCode = orgCode;
        this.orgNameCn = orgNameCn;
        this.orgNameEn = orgNameEn;
        this.abbrNameCn = abbrNameCn;
        this.orgType = orgType;
        this.abbrNameEn = abbrNameEn;
        this.level = level;
        this.parentId = parentId;
    }
}
