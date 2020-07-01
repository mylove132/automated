package com.xdf.bling.qa.common.annotation;
import org.springframework.web.bind.annotation.Mapping;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {

    /**
     * 接口版本号(对应swagger中的group)
     * @return String[]
     */
    String[] group();
}