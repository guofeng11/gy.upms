package com.gy.upms.entity;

import java.io.Serializable;
import java.util.Date;

public class Organization implements Serializable {
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

    private Date createTime;

    private String remark;

    private static final long serialVersionUID = 1L;

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
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgNameCn() {
        return orgNameCn;
    }

    public void setOrgNameCn(String orgNameCn) {
        this.orgNameCn = orgNameCn == null ? null : orgNameCn.trim();
    }

    public String getOrgNameEn() {
        return orgNameEn;
    }

    public void setOrgNameEn(String orgNameEn) {
        this.orgNameEn = orgNameEn == null ? null : orgNameEn.trim();
    }

    public String getAbbrNameCn() {
        return abbrNameCn;
    }

    public void setAbbrNameCn(String abbrNameCn) {
        this.abbrNameCn = abbrNameCn == null ? null : abbrNameCn.trim();
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public String getAbbrNameEn() {
        return abbrNameEn;
    }

    public void setAbbrNameEn(String abbrNameEn) {
        this.abbrNameEn = abbrNameEn == null ? null : abbrNameEn.trim();
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
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgId=").append(orgId);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", orgNameCn=").append(orgNameCn);
        sb.append(", orgNameEn=").append(orgNameEn);
        sb.append(", abbrNameCn=").append(abbrNameCn);
        sb.append(", orgType=").append(orgType);
        sb.append(", abbrNameEn=").append(abbrNameEn);
        sb.append(", level=").append(level);
        sb.append(", parentId=").append(parentId);
        sb.append(", createId=").append(createId);
        sb.append(", creater=").append(creater);
        sb.append(", createTime=").append(createTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}