package SpringIOCDemo.SpringFactoryDemo;

import SpringIOCDemo.Dept;
import SpringIOCDemo.User;
import org.springframework.beans.factory.FactoryBean;

public class SpringBeanFactory implements FactoryBean<User> {
    public User getObject() throws Exception {
        User user=new User();
        user.setName("李四");
        Dept dept=new Dept();
        dept.setName("王二");
        user.setDept(dept);
        return user;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
    //定义返回bean对象

}
