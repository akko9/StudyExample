package ProxyMode.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object proxyObject;
    public ProxyFactory(Object target) {
        this.proxyObject=target;
    }

    public Object newProxyInstance() {
        Object result = Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), proxyObject.getClass().getInterfaces(), new ObjectHandler()
//                (proxy, method, args) -> {
//            System.out.println("开始执行。。。。。");
//            Object value = method.invoke(proxyObject, args);
//            return value;
//        });
        );
        return result;
    }


    private class ObjectHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("执行开始");
            Object invoke = method.invoke(proxyObject, args);
            return invoke;
        }
    }
}
