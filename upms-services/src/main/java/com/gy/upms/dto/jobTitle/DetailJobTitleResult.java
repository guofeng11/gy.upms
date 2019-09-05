package com.gy.upms.dto.jobTitle;

import java.io.Serializable;

/**
 * @ClassName DetailJobTitleResult.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月03日 14:00:00
 */
public class DetailJobTitleResult implements Serializable {
    private static final long serialVersionUID = 3168907154961426328L;
    private Integer id;

    private String jobTitle;

    private String jobTitleEn;

    private Integer level;

    private String remark;

    private Integer createId;

    private String creater;

    private String createTime;

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
        this.jobTitle = jobTitle;
    }

    public String getJobTitleEn() {
        return jobTitleEn;
    }

    public void setJobTitleEn(String jobTitleEn) {
        this.jobTitleEn = jobTitleEn;
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
        this.remark = remark;
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

}
