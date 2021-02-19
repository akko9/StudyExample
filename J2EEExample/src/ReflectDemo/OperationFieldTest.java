package ReflectDemo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
对Person类属性的操作
 */
public class OperationFieldTest {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        //属性操作========================================
        //公开的属性 public 包括父类
        //Field[] fields = personClass.getFields();
        //所有的属性 不含父类的属性
        Field[] fields = personClass.getDeclaredFields();
        //属性各个权限修饰符 数据类型 变量名
        for (Field field:fields) {
            //System.out.println(field);
            //1.权限修饰符
            int modifiers = field.getModifiers();
            System.out.print("modifiers:"+Modifier.toString(modifiers)+"\t");
            //2.数据类型
            Class<?> type = field.getType();
            System.out.print("type:"+type+"\t");
            //3.变量名
            String name = field.getName();
            System.out.println("name:"+name+"\t");
            System.out.println();
        }


    }
}
