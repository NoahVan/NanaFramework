package com.nana;

import com.nana.helper.*;
import com.nana.util.ClassUtil;

/**
* @Description:    java类作用描述:加载相应的helper类
* @Author:         yc
* @CreateDate:     2019/2/20 16:03
* @UpdateUser:     yc
* @UpdateDate:     2019/2/20 16:03
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public final class HelperLoader {

        public static void init(){
            Class<?>[] classes = {
                    ClassHelper.class,
                    BeanHelper.class,
                    AopHelper.class,
                    IocHelper.class,
                    ControllerHelper.class
            };

        for (Class<?> cls : classes) {
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
