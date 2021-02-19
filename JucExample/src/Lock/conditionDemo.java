package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class conditionDemo {

    public static void main(String[] args) {
        ShareData shareData=new ShareData();
        for (int i = 0; i <3 ; i++) {
            new Thread(()->{
                shareData.pro5();
            },"AAA").start();
            new Thread(()->{
                shareData.pro10();
            },"BBB").start();
            new Thread(()->{
                shareData.pro15();
            },"CCC").start();
        }

    }

}
class ShareData{
    int number=1;
    Lock lock=new ReentrantLock();
    Condition c1=lock.newCondition();
    Condition c2=lock.newCondition();
    Condition c3=lock.newCondition();
    public void pro5(){
        lock.lock();
        try {
            while (number!=1){
                c1.await();
            }
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"生产!");
            }
            number=2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void pro10(){
        lock.lock();
        try {
            while (number!=2){
                c2.await();
            }
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"生产!");
            }
            number=3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void pro15(){
        lock.lock();
        try {
            while (number!=3){
                c3.await();
            }
            for (int i = 0; i <15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"生产!");
            }
            number=1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}