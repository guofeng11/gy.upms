package com.gy.upms.dto;

/**
 * @Auther: guofeng
 * @Date: 2019/6/19 11:33
 * @Description: 通用Boolean 定义
 */
public enum  TrueFalse {
    TRUE(1,true),FLASE(0,false);

    private int intValue;
    public int getIntValue() {
        return intValue;
    }

    private boolean booleanValue;

    public boolean getBooleanValue() {
        return booleanValue;
    }

    private TrueFalse(int intValue, boolean booleanValue){
        this.intValue =intValue;
        this.booleanValue =booleanValue;
    }

    public static TrueFalse valueOf(int value){
        switch (value) {
            case 1:
                return TrueFalse.TRUE;
            case 0:
            default:
                return TrueFalse.FLASE;
        }
    }
}
