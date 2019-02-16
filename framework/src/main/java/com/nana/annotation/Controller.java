package com.nana.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Description:    java类作用描述:控制器注解
* @Author:         yc
* @CreateDate:     2019/2/16 10:58
* @UpdateUser:     yc
* @UpdateDate:     2019/2/16 10:58
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
