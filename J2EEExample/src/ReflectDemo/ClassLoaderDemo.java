package ReflectDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
读取配置文件
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {

        try {
            Properties properties=new Properties();
            //1.方法一 Properties
            //FileInputStream fis=new FileInputStream("J2EEExample\\src\\ReflectDemo\\test.properties");
            //2.方法二 ClassLoader
            ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
            InputStream fis = classLoader.getResourceAsStream("ReflectDemo\\test.properties");
            properties.load(fis);
            String user=properties.getProperty("user");
            String password=properties.getProperty("password");
            System.out.println("user:"+user);
            System.out.println("password:"+password);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
