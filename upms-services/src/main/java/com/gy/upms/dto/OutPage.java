package com.gy.upms.dto;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/4/29 16:00
 * @Description:
 */
public class OutPage implements Serializable {

    private static final long serialVersionUID = -3982245662737190902L;

    private int totalPage;
    private long totalRows;

    public OutPage(){}
    public OutPage(int totalPage, long totalRows) {
        this.totalPage = totalPage;
        this.totalRows = totalRows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }
}
