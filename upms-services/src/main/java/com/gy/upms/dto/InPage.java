package com.gy.upms.dto;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/4/29 16:24
 * @Description:
 */
public class InPage implements Serializable {
    private static final long serialVersionUID = 5302833461026925161L;

    private int currentPage;
    private int pageRows;

    public InPage(){}
    public InPage(int currentPage, int pageRows) {
        this.currentPage = currentPage;
        this.pageRows = pageRows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }


    public int getPageRows() {
        return pageRows;
    }

    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }

    @Override
    public String toString() {
        return "InPage{" +
                "currentPage=" + currentPage +
                ", pageRows=" + pageRows +
                '}';
    }
}
