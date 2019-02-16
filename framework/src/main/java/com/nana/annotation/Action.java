package com.nana.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Description:    java类作用描述:action 方法注解
* @Author:         yc
* @CreateDate:     2019/2/16 11:00
* @UpdateUser:     yc
* @UpdateDate:     2019/2/16 11:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    /**
     * 请求类型路径
     * @return
     */
    String value();
}
