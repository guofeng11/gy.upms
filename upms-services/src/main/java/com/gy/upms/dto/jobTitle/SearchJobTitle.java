package com.gy.upms.dto.jobTitle;

import com.gy.upms.dto.InPage;
import com.gy.upms.dto.UserSecurity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName SearchJobTitle.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年09月03日 14:00:00
 */
public class SearchJobTitle implements Serializable {
    private static final long serialVersionUID = -3884968476121275965L;

    private String jobTitle;

    private Integer level;
    @Valid
    @NotNull(message = "{page.notNull}")
    private InPage page;
    @NotNull(message = "{user.security.notNull}")
    @Valid
    private UserSecurity userSecurity;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public InPage getPage() {
        return page;
    }

    public void setPage(InPage page) {
        this.page = page;
    }

    public UserSecurity getUserSecurity() {
        return userSecurity;
    }

    public void setUserSecurity(UserSecurity userSecurity) {
        this.userSecurity = userSecurity;
    }
}
