package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
lock锁的生产消费者
 */
public class LockCoPoDemo {
    public static void main(String[] args) {
        MyLock ticket=new MyLock();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    ticket.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"produce1").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    ticket.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"consumer1").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    ticket.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"produce2").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    ticket.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"consumer2").start();
    }

}
class MyLock{
    private int num=0;
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();

    public  void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num!=0){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"生产一件");
            num++;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public  void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (num==0){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"消费一件");
            num--;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
