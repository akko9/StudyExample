package com.example.aopdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }
    public Object getProxyInstance(){
        Object result = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = method.invoke(object, args);
                System.out.println("开始进行角色权限判断");
                return invoke;
            }
        });
        return result;
    }
}
