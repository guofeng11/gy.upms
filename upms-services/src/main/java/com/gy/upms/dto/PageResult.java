package com.gy.upms.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/6/13 15:36
 * @Description: 分页返回结果 E 要返回的DTO 类型
 */
public class PageResult<E> implements Serializable {
    private static final long serialVersionUID = 8352723229942292204L;
    private OutPage page;
    private List<E> data;

    public OutPage getPage() {
        return page;
    }

    public void setPage(OutPage page) {
        this.page = page;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public PageResult() {
    }

    public PageResult(OutPage page) {
        this.page = page;
    }

    public PageResult(OutPage page, List<E> users) {
        this.page = page;
        this.data = users;
    }
}
