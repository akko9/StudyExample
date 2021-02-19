package ReflectDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OperationOthers {
    public static void main(String[] args) {
        //获得父类的具体泛型====================
        Class<Person> personClass = Person.class;
        Type superclass = personClass.getGenericSuperclass();
        //获得泛型类型
        ParameterizedType type= (ParameterizedType) superclass;
        Type[] types = type.getActualTypeArguments();
        //结果:java.lang.String
        System.out.println(types[0].getTypeName());
        System.out.println(((Class)types[0]).getName());
        //获取当前类对应的接口
        Class<?>[] interfaces = personClass.getInterfaces();
        //获得父类的对应的接口
        Class<? super Person> superclass1 = personClass.getSuperclass();
        Class<?>[] interfaces1 = superclass1.getInterfaces();
        //获得运行时类的包
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
        //获得类的注解
        Annotation[] annotations = personClass.getAnnotations();

    }
}
