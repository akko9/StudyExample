package ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class OperationValueTest {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        try {
            //属性操作===================================================
            //对象实例化
            Person person = personClass.newInstance();
            //获取指定的属性
            Field age = personClass.getDeclaredField("name");
            //设置属性值
            age.setAccessible(true);
            age.set(person,"张三");
            System.out.println(person.getName());
            //方法操作===================================================
            Method show = personClass.getDeclaredMethod("showPAndType",String.class);
            Object name = show.invoke(person, "张三");
            System.out.println(name);
            //构造器操作===================================================
            Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class, Integer.class);
            declaredConstructor.setAccessible(true);
            Person person1 = declaredConstructor.newInstance("张三", 20);
            System.out.println(person1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
