package com.gy.upms.entity;

import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/6/11 17:23
 * @Description:
 */
public class Rows implements Serializable {
    private static final long serialVersionUID = 6590508525411988265L;

    private long totalRows;

    private int pageSize;

    private int totalPage;


    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }



    public int getTotalPage(){
          totalPage = this.pageSize==0?1:(int)Math.ceil(this.totalRows *1.0/this.pageSize);
          return totalPage;
    }

    public Rows(){}

    public Rows(long totalRow, int pageSize) {
        this.totalRows = totalRow;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Rows{" +
                "totalRows=" + totalRows +
                ", pageSize=" + pageSize +
                '}';
    }
}
