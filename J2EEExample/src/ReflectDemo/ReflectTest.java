package ReflectDemo;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

public class ReflectTest {
    public static void main(String[] args) {
//        //1.实例化
//        Person p1=new Person("zyf",16);
//        //调用方法
//        p1.age=20;
//        System.out.println(p1.toString());
//        p1.showP();
        //反射操作=================================
        //1.实例化
        try {
//            Class c=Person.class;
//            //获得构造器
//            Constructor constructor = c.getConstructor(String.class, Integer.class);
//            //通过构造器实例化对象
//            Object person = constructor.newInstance("zyf", 16);
//            //通过class获得class属性
//            Field age = c.getDeclaredField("age");
//            //调用属性的set方法赋值
//            age.set(person,20);
//            System.out.println(person.toString());
//            //通过class获得方法
//            Method showP = c.getDeclaredMethod("showP");
//            //通过方法的invoke进行执行
//            showP.invoke(person);
//            //调用私有属性
//            Method show = c.getDeclaredMethod("show");
//            //开启修改权限
//            show.setAccessible(true);
//            show.invoke(person);
            //反射操作获得运行时类=================================
            //方法一 调用运行时类
//            Class<Person> P1 = Person.class;
//            //方法二 通过实例化的对象
//            Person p=new Person();
//            Class P2 = p.getClass();
//            //方法三 通过forName(classPath)
//            Class P3 = Class.forName("ReflectDemo.Person");
//            //方法四 使用classloader
//            ClassLoader classLoader = ReflectTest.class.getClassLoader();
//            classLoader.loadClass("ReflectDemo.Person");
            //反射操作获得对象实例=================================
            //1.无参构造 提供空参构造器,访问权限得大
            Class aClass = Class.forName("ReflectDemo.Person");
            Person person = (Person) aClass.newInstance();
            System.out.println(person);
            //2.有参构造
            Constructor constructor = aClass.getDeclaredConstructor();
            Object p1 = constructor.newInstance();
            System.out.println(p1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
@myAnnotation(value = "人类")
class Person extends Creation<String> implements Comparable<String>,myInterface{
    private String name;
    public Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Person(Integer age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @myAnnotation(value = "私有方法")
    private void show(){
        System.out.println("我是私有方法!");
    }
    public void showP(){
        System.out.println("我是公有方法!");
    }
    public String showPAndType(String name){
        System.out.println(name+"我带参方法!");
        return "接收成功";
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void info() {
        System.out.println("人类文明的信息");
    }

    @Override
    void create() {
        System.out.println("人类的创造者");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
interface myInterface{
    void info();
}
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation{
    String[] value();
}
abstract class Creation<String> implements Serializable {
    private static final long serialVersionUID = 9083940960015984292L;

    abstract void create();
}

