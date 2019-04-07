package com.nana.demo.util;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy(){}

    public static CGLibProxy getInstance(){
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls, this);
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");

        Object result = methodProxy.invokeSuper(o, objects);

        System.out.println("after");

        return result;
    }


    public static void main(String[] args) {
//        HelloImpl proxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
//        proxy.say("test");
//
//        int i = -3;
//        String s = Integer.toBinaryString(i);
//        System.out.println(s);
//        int a = i >> 1;
//        System.out.println(a);
//        String s2 = Integer.toBinaryString(a);
//        System.out.println(s2);


        String h = "hello我";

        int length = h.length();

        System.out.println(length);

        int count = h.codePointCount(0, length);

        System.out.println(count);
    }
}
