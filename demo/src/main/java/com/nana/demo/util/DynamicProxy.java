package com.nana.demo.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");

        Object result = method.invoke(target, args);

        System.out.println("after");

        return result;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {

        Hello hello = new HelloImpl();

        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        Hello helloProxy = (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), dynamicProxy);

        helloProxy.say("test");
    }
}
