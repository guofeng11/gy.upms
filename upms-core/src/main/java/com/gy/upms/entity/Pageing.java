package com.gy.upms.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: guofeng
 * @Date: 2019/6/10 17:28
 * @Description:
 */
public class Pageing<T> extends ArrayList<Object>  implements Serializable {
    private static final long serialVersionUID = 6590508525411988265L;

    private Rows rows;

    private List<T> dataList;

    public Rows getRows() {
        initSerializable();
        return rows;
    }

    public List<T> getDataList() {
        initSerializable();
        return dataList;
    }

    /**
     * 序列化数据
     */
    private void initSerializable(){
        //dataList 只执行一次拆箱
        if (this.dataList==null) {
            if (this != null && this.size() > 1) {
                this.rows = ((List<Rows>) this.get(1)).get(0);
                this.dataList = (List<T>) this.get(0);
            } else {
                this.rows = new Rows(0,0);
                this.dataList = new ArrayList<T>();
            }
        }
    }
}
