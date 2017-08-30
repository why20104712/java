package com.why.config;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataSource {

    DataSourceType value() default DataSourceType.MASTER;
}
