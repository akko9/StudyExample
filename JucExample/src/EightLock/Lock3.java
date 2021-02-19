package EightLock;

import java.util.concurrent.TimeUnit;

/*
标准情况: 新增一个普通方法hello
结果:
hello
A打电话
结论:
普通方法无锁,不会争抢
 */
public class Lock3 {
    public static void main(String[] args) throws Exception {
        Phone3 phone=new Phone3();
        new Thread(()->{
            phone.call();
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone.hello();
        },"B").start();
    }

}

class Phone3{
    public synchronized void call(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"打电话");
    }

    public void hello(){
        System.out.println("hello");
    }
}