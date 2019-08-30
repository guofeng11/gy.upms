package com.gy.upms.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @ClassName EnumValidAnnotation.java
 * @Author guofeng
 * @Description
 * @Version 1.0.0
 * @Date 2019年08月28日 14:20:00
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnumValidation.class)
public @interface EnumValidAnnotation {

    Class<?> value();

    String inputMethod() default "name";

    String message() default "枚举类型错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
