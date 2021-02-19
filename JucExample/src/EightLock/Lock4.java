package EightLock;

import java.util.concurrent.TimeUnit;

/*
标准情况: 新增一个Phone类  Thread-1调用call()  Thread-2调用sendEmail()
结果:
B发邮件
A打电话
结论:
两个对象不是同一把锁,不会争抢
 */
public class Lock4 {
    public static void main(String[] args) throws Exception {
        Phone4 phone4A=new Phone4();
        Phone4 phone4B = new Phone4();
        new Thread(()->{
            phone4A.call();
        },"A").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            phone4B.sendEmail();
        },"B").start();
    }

}

class Phone4{
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
