package EightLock;

import java.util.concurrent.TimeUnit;

/*
标准情况: 一个静态同步方法call 一个普通同步方法sendEmail
结果:
B发邮件
A打电话
结论:
静态同步方法锁的是类class
普通同步方法锁的是对象this
 */
public class Lock7 {
    public static void main(String[] args) throws Exception {
        Phone7 phone7=new Phone7();

        new Thread(()->{
            phone7.call();
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone7.sendEmail();
        },"B").start();
    }

}

class Phone7{
    public static synchronized void call(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"打电话");
    }

    public  synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"发邮件");
    }
}
