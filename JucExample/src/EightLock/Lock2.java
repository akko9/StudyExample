package EightLock;

import java.util.concurrent.TimeUnit;

/*
标准情况: 在call内部TimeUnit.SECONDS.sleep(4);
结果:
A打电话
B发邮件
 */
public class Lock2 {
    public static void main(String[] args) throws Exception {
        Phone2 phone=new Phone2();
        new Thread(()->{
            phone.call();
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone.sendEmail();
        },"B").start();
    }

}

class Phone2{
    public synchronized void call(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"打电话");
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"发邮件");
    }
}