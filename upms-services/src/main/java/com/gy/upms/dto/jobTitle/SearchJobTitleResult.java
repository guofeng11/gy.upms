package com.gy.upms.dto.jobTitle;

import java.io.Serializable;

/**
 * @ClassName SearchJobTitleResult.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月03日 14:00:00
 */
public class SearchJobTitleResult implements Serializable {
    private Integer id;

    private String jobTitle;

    private String jobTitleEn;

    private Integer level;

    private String remark;

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

    public SearchJobTitleResult() {
    }

    public SearchJobTitleResult(Integer id, String jobTitle, String jobTitleEn, Integer level, String remark) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.jobTitleEn = jobTitleEn;
        this.level = level;
        this.remark = remark;
    }
}
