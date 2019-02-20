package com.nana.helper;

import com.nana.annotation.Inject;
import com.nana.util.ReflectionUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
* @Description:    java类作用描述:依赖注入助手类
* @Author:         yc
* @CreateDate:     2019/2/20 15:01
* @UpdateUser:     yc
* @UpdateDate:     2019/2/20 15:01
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public final class IocHelper {

    static {
        //获取所有的Bean类与Bean实例之间的映射关系（简称Bean Map）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (MapUtils.isNotEmpty(beanMap)){
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //从BeanMap中获取Bean类和Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类所有的成员变量（简称Bean Field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)){
                    for (Field beanField : beanFields) {
                        //判断当前Bean Field是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)){
                            //在BeanMap中获取BeanField对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null){
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }

}
