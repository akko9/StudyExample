package ProxyMode.DynamicProxy;

import ProxyMode.StaticProxy.SuperTeacher;
import ProxyMode.StaticProxy.Teacher;

public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory=new ProxyFactory(new Teacher());
        SuperTeacher instance = (SuperTeacher) proxyFactory.newProxyInstance();
        instance.teach();
        System.out.println(instance);
    }


}
