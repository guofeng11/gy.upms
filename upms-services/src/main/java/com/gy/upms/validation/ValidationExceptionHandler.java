package com.gy.upms.validation;

import com.gy.upms.dto.ResultMessage;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;


/**
 * @ClassName ValidationExceptionHandler.java
 * @Author guofe
 * @Description 验证异常处理
 * @Version 1.0.0
 * @Date 2019年08月13日 14:18:00
 */
@RestControllerAdvice
public class ValidationExceptionHandler {

    /**
     * 处理请求对象属性不满足校验规则的异常信息
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultMessage<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception){
        StringBuilder builder = bingExceptionToStringMessage(exception.getBindingResult());
        return new ResultMessage(ResultMessage.ResultType.FAIL, builder.toString());
    }
    /**
     * 处理请求单个参数不满足校验规则的异常信息
     *
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultMessage<String> constraintViolationExceptionHandler(ConstraintViolationException exception) {
        return new ResultMessage(ResultMessage.ResultType.FAIL, exception.getMessage());
    }
    @ExceptionHandler(value = BindException.class)
    public ResultMessage<String> constraintViolationExceptionHandler(BindException exception) {
        StringBuilder builder = bingExceptionToStringMessage(exception.getBindingResult());
        return new ResultMessage(ResultMessage.ResultType.FAIL, builder.toString());
    }

    /**
     * 获取 bindingResult 信息
     * @param bindingResult
     * @return StringBuilder 逗号分隔
     */
    private StringBuilder bingExceptionToStringMessage(BindingResult bindingResult) {
        BindingResult result = bindingResult;
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();
        for (FieldError error : fieldErrors) {
            builder.append(error.getDefaultMessage() + ",");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder;
    }
}
