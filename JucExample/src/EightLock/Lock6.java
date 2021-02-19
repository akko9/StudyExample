package EightLock;

import java.util.concurrent.TimeUnit;

/*
标准情况: 新增两个静态同步方法call sendEmail 2部手机
结果:
A打电话
B发邮件
结论:
static synchronized锁的是class
 */
public class Lock6 {
    public static void main(String[] args) throws Exception {
        Phone6 phone6A=new Phone6();
        Phone6 phone6B=new Phone6();
        new Thread(()->{
            phone6A.call();
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone6B.sendEmail();
        },"B").start();
    }

}

class Phone6{
    public static synchronized void call(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"打电话");
    }

    public static synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"发邮件");
    }
}
