package PrototypeMode.deepSheep;

import java.io.*;

public class Sheep implements Serializable, Cloneable{
    private static final long serialVersionUID = 5987793111183714482L;
    private String name;
    private int age;
    private String color;
    private Sheep friend;
    public Sheep() {
    }

    public Sheep(String name, int age, String color, Sheep friend) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.friend=friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Sheep getFriend() {
        return friend;
    }

    public void setFriend(Sheep friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", friend=" + friend +
                '}';
    }
    //方法一:重写clone
    @Override
    protected Sheep clone() {
        Sheep sheep=null;
        try {
             sheep=(Sheep)super.clone();
            if (sheep.getFriend()!=null){
                Sheep clone = sheep.getFriend().clone();
                sheep.setFriend(clone);
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }
    //方法一:序列化
    protected Object deepClone(){
        //创建流对象
        ByteArrayOutputStream bos=null;
        ObjectOutputStream oos=null;
        ByteArrayInputStream ios=null;
        ObjectInputStream ois=null;


        try {
            //序列化
            bos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(bos);
            oos.writeObject(this); //以对象流输出
            //反序列化
            ios=new ByteArrayInputStream(bos.toByteArray());
            ois=new ObjectInputStream(ios);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ios!=null){
                try {
                    ios.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
      return null;
    }
}
