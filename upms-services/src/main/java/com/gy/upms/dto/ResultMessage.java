package com.gy.upms.dto;



import java.io.Serializable;

/**
 * @Auther: guofeng
 * @Date: 2019/4/29 15:26
 * @Description:
 */
public class ResultMessage<E> implements Serializable {

    private static final long serialVersionUID = -4411357774239744411L;

    //返回类型的枚举
    public enum ResultType{
        SUCCESS(0),UNAUTHORIZED(1),FAIL(2),EXCEPTION(3),ARGSVALIDATION(4);

        private int code;
        private ResultType(int code){
            this.code=code;
        }

        public int getCode() {
            return code;
        }
    }
    //结果标识
    private int result;
    //消息
    private String message;
    //数据
    private E data;

    public ResultMessage(ResultType result, String message, E data) {
        this.result = result.getCode();
        this.message = message;
        this.data = data;
    }

    public ResultMessage(ResultType result, String message) {
        this(result,message,null);
    }
    public ResultMessage(ResultType result,E data) {
        this(result,result.name(),data);
    }
    public ResultMessage(ResultType result) {
        this(result,result.name(),null);
    }
    public ResultMessage(){}
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
