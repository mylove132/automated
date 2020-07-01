package com.xdf.bling.qa.common.annotation;

import com.xdf.bling.qa.common.enums.ActionType;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String title() default "";

    ActionType actiontype() default ActionType.OTHER;
}
