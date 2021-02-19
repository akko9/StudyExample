package ReferneceDemo;

/*
强引用
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object object1=new Object(); //强引用
        Object object2=object1; //赋值给obj2
        object1=null; //obj1位空
        System.gc();
        System.out.println(object1);
        System.out.println(object2);
    }
}
