package ThreadDemo;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
lock麦票
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();

        ArrayList<Integer> list=new ArrayList<>();
        System.out.println(list.size());
//        new Thread(()->{
//            while (ticket.getNum()>0){
//            ticket.sell();
//            }
//        },"售票口1").start();
//        new Thread(()->{
//            while (ticket.getNum()>0){
//                ticket.sell();
//            }
//        },"售票口2").start();
//        new Thread(()-> {
//            while (ticket.getNum() > 0) {
//                ticket.sell();
//            }
//        },"售票口3").start();
    }
}
 class Ticket {
    private Integer num = 50;

    Lock lock = new ReentrantLock();


    public Integer getNum() {
        return num;
    }

    public void sell() {
        lock.lock();
        try {
            if (num>0){
                num--;
                System.out.println(Thread.currentThread().getName()+"卖出去了"+(50-num)+"还剩"+num+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}