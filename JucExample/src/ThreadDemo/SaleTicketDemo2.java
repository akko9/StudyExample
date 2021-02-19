package ThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
生产消费者synchronized
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {
        Ticket2 ticket=new Ticket2();
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
class Ticket2{
    private int num =0;
    public synchronized void increment() throws InterruptedException {

        while (num!=0){
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+"生产一件");
        num++;
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while (num==0){
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+"消费一件");
        num--;
        this.notifyAll();
    }
}