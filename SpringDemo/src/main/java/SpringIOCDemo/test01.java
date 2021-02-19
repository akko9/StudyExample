package SpringIOCDemo;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    @Test
    public void test1(){
        //加载Spring配置文件
        BeanFactory applicationContext=new ClassPathXmlApplicationContext("bean01.xml");
        //ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean01.xml");
        //获取配置文件的对象
        User user = applicationContext.getBean("user", User.class);
//        System.out.println("用户id:"+user.getId());
//        System.out.println("用户名:"+user.getName());
//        System.out.println("地址:"+user.getAddress());
//        user.run();
        System.out.println(user.toString());
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();
    }
    @Test
    public void Factory(){
        //加载Spring配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean02.xml");
        User user = applicationContext.getBean("MyBean",User.class);
        System.out.println(user);
    }
}
