package ReferneceDemo;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/*
ReferenceQueueDemo
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) {
        Object o1=new Object();
        ReferenceQueue<Object> referenceQueue=new ReferenceQueue<Object>();
        WeakReference<Object> weakReference=new WeakReference<Object>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}
