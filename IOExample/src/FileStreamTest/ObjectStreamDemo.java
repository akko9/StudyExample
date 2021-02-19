package FileStreamTest;

import java.io.*;

/*
ObjectInputStream ObjectOutputStream
 */
public class ObjectStreamDemo {
    public static void main(String[] args) {
        serialize();
        unSerialize();
    }

    private static void unSerialize() {
        ObjectInputStream ois=null;
        try {
            FileInputStream fileInputStream=new FileInputStream("IOExample\\Person.data");
            ois=new ObjectInputStream(fileInputStream);
            Object object = ois.readObject();
            String str=object.toString();
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void serialize() {
        ObjectOutputStream oos= null;
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("IOExample\\Person.data");
            oos = new ObjectOutputStream(fileOutputStream);
            Person person=new Person("张三");
            oos.writeObject(person);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /*
    序列化过程
     */


}
class Person implements Serializable{
    private static final long serialVersionUID = -1849847325826062982L;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
