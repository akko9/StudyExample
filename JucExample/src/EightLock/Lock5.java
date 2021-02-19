package EightLock;

import java.util.concurrent.TimeUnit;

/*
标准情况: 新增两个静态同步方法call sendEmail
结果:
A打电话
B发邮件
结论:

 */
public class Lock5 {
    public static void main(String[] args) throws Exception {
        Phone5 phone=new Phone5();
        new Thread(()->{
            phone.call();
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone.sendEmail();
        },"B").start();
    }

}

class Phone5{
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