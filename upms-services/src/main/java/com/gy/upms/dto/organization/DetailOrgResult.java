package com.gy.upms.dto.organization;

import java.io.Serializable;

/**
 * @ClassName DetailOrgResult.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月26日 13:57:00
 */
public class DetailOrgResult implements Serializable {
    private static final long serialVersionUID = -1280220619530894867L;
    private Integer orgId;

    private String orgCode;

    private String orgNameCn;

    private String orgNameEn;

    private String abbrNameCn;

    private String orgType;

    private String abbrNameEn;

    private Integer level;

    private Integer parentId;

    private Integer createId;

    private String creater;

    private String createTime;

    private String remark;

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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
