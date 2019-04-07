package com.nana.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public abstract class AspectProxy implements Proxy{
    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result;

        Class<?> targetClass = proxyChain.getTargetClass();
        Method targetMethod = proxyChain.getTargetMethod();
        Object[] methodParams = proxyChain.getMethodParams();

        begin();

        try {
            if (intercepter(targetClass, targetMethod, methodParams)){
                before(targetClass, targetMethod, methodParams);
                result = proxyChain.doProxyChain();
                after(targetClass, targetMethod, methodParams, result);
            }else {
                result = proxyChain.doProxyChain();
            }
        } catch (Throwable e) {
            LOGGER.error("proxy failure", e);
            error(targetClass, targetMethod, methodParams, e);
            throw e;
        } finally {
            end();
        }

        return result;
    }

    public void begin(){

    }

    public boolean intercepter(Class<?> cls, Method method, Object[] params) throws Throwable{
        return true;
    }

    public void before(Class<?> cls, Method method, Object[] params) throws Throwable{
    }

    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable{
    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable e){
    }

    public void end(){}
}
