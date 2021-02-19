package SynchronousQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
/*
SynchronousQueue只存储单个元素，一进一出
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue=new SynchronousQueue<>();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":PUT 1");
            try {
                blockingQueue.put(2);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":PUT 2");
            try {
                blockingQueue.put(3);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":PUT 3");
            try {
                blockingQueue.put(1);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+":TAKE 1");
                blockingQueue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+":TAKE 2");
                blockingQueue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+":TAKE 3");
                blockingQueue.take();
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
