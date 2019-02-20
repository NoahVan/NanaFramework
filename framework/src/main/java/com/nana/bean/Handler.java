package com.nana.bean;

import java.lang.reflect.Method;

/**
* @Description:    java类作用描述:封装Action信息
* @Author:         yc
* @CreateDate:     2019/2/20 15:42
* @UpdateUser:     yc
* @UpdateDate:     2019/2/20 15:42
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Handler {

    /**
     * Controller类
     */
    private Class<?> controllerClass;

    /**
     * action方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
