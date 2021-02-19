package ReferneceDemo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/*
PhantomReference虚引用
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object o1=new Object();
        ReferenceQueue<Object> referenceQueue=new ReferenceQueue<Object>();
        PhantomReference<Object> phantomReference=new PhantomReference<Object>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(phantomReference.get());

        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(phantomReference.get());

    }
}
