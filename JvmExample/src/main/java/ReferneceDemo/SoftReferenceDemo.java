package ReferneceDemo;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/*
软引用
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
        //MemoryEnough();
        MemoryNotEnough();
    }
    /*
    内存足够
     */
    public static void MemoryEnough(){
        Object object1=new Object();
        SoftReference<Object> softReference=new SoftReference<Object>(object1);
        System.out.println(object1);
        System.out.println(softReference);

        object1=null;
        System.gc();

        System.out.println(object1);
        System.out.println(softReference.get());
    }
    /*
    内存不够
     */
    public static void MemoryNotEnough(){
        Object object1=new Object();
        SoftReference<Object> softReference=new SoftReference<Object>(object1);
        System.out.println(object1);
        System.out.println(softReference.get());
        object1=null;
        System.gc();

        try {
            byte[] bytes=new byte[30*1024*1024];
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }finally {
            System.out.println(object1);
            System.out.println(softReference.get());

        }
    }
}
