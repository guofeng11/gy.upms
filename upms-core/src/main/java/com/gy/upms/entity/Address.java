package com.gy.upms.entity;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable {
    private String code;

    private String nameCn;

    private String nameEn;

    private String parentCode;

    private Integer level;

    private String abbreviationCn;

    private String abbreviationEn;

    private Integer createrId;

    private String creater;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAbbreviationCn() {
        return abbreviationCn;
    }

    public void setAbbreviationCn(String abbreviationCn) {
        this.abbreviationCn = abbreviationCn == null ? null : abbreviationCn.trim();
    }

    public String getAbbreviationEn() {
        return abbreviationEn;
    }

    public void setAbbreviationEn(String abbreviationEn) {
        this.abbreviationEn = abbreviationEn == null ? null : abbreviationEn.trim();
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", code=").append(code);
        sb.append(", nameCn=").append(nameCn);
        sb.append(", nameEn=").append(nameEn);
        sb.append(", parentCode=").append(parentCode);
        sb.append(", level=").append(level);
        sb.append(", abbreviationCn=").append(abbreviationCn);
        sb.append(", abbreviationEn=").append(abbreviationEn);
        sb.append(", createrId=").append(createrId);
        sb.append(", creater=").append(creater);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}