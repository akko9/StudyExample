package ReflectDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
/*
对Person类方法的操作
 */
public class OperationMethodTest {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        //公开的方法 public 包括父类
        //Method[] methods = personClass.getMethods();
        //所有的方法 除了父类
        Method[] methods =personClass.getDeclaredMethods();
        for (Method method:methods) {
            //System.out.println(method);
            //1.获取方法声明的注解
//            Annotation[] annotations = method.getAnnotations();
//            for (Annotation annotation:annotations) {
//                System.out.print("annotation:"+annotation+"\t");
//            }
//            //2.返回值类型
//            Class<?> returnType = method.getReturnType();
//            System.out.println("returnType;"+returnType);
            //3.方法名(参数类型1,形参1)
            String name = method.getName();
            System.out.print("name:"+name);
            System.out.print("(");
            //形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes==null||parameterTypes.length==0)){

            }
            for (Class type:parameterTypes) {
                System.out.print("parameterTypes:"+type);
            }
            System.out.println(")");
            //4.异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
        }

    }
}
