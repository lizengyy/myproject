package com.china.framework.annotation;

import com.china.framework.constant.FieldFill;
import com.china.framework.constant.FieldStrategy;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.UnknownTypeHandler;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TableField {
    String value() default "";

    boolean exist() default true;

    String condition() default "";

    String update() default "";

    FieldStrategy insertStrategy() default FieldStrategy.DEFAULT;

    FieldStrategy updateStrategy() default FieldStrategy.DEFAULT;

    FieldStrategy whereStrategy() default FieldStrategy.DEFAULT;

    FieldFill fill() default FieldFill.DEFAULT;

    boolean select() default true;

    boolean keepGlobalFormat() default false;

    JdbcType jdbcType() default JdbcType.UNDEFINED;

    Class<? extends TypeHandler> typeHandler() default UnknownTypeHandler.class;

    String numericScale() default "";
}
