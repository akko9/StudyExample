package EightLock;

import java.util.concurrent.TimeUnit;

/*
标准情况: 一个静态同步方法call 一个普通同步方法sendEmail 2部手机
结果:
B发邮件
A打电话
 */
public class Lock8 {
    public static void main(String[] args) throws Exception {
        Phone8 phone8A=new Phone8();
        Phone8 phone8B=new Phone8();
        new Thread(()->{
            phone8A.call();
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone8B.sendEmail();
        },"B").start();
    }

}

class Phone8{
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
