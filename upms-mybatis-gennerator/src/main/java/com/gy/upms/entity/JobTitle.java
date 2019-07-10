package com.gy.upms.entity;

import java.io.Serializable;
import java.util.Date;

public class JobTitle implements Serializable {
    private Integer id;

    private String jobTitle;

    private String jobTitleEn;

    private Integer level;

    private String remark;

    private Integer createId;

    private String creater;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public String getJobTitleEn() {
        return jobTitleEn;
    }

    public void setJobTitleEn(String jobTitleEn) {
        this.jobTitleEn = jobTitleEn == null ? null : jobTitleEn.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobTitle=").append(jobTitle);
        sb.append(", jobTitleEn=").append(jobTitleEn);
        sb.append(", level=").append(level);
        sb.append(", remark=").append(remark);
        sb.append(", createId=").append(createId);
        sb.append(", creater=").append(creater);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}