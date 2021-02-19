package EightLock;

import java.util.concurrent.TimeUnit;

/*
标准情况:  TimeUnit.SECONDS.sleep(3);
结果:
A打电话
A发邮件
结论:
一个对象里面有多个synchronized方法,某一时刻内,只能一个线程去调用其中的一个synchronized方法,其他线程只能等待
锁的是当前对象this
 */
public class Lock1 {
    public static void main(String[] args) throws Exception {
        Phone phone=new Phone();
        new Thread(()->{
            phone.call();
        },"A").start();
        TimeUnit.SECONDS.sleep(3);
        new Thread(()->{
            phone.sendEmail();
        },"A").start();
    }

}
class Phone{
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"打电话");
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"发邮件");
    }
}