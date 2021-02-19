package JucTools;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
信号量(抢车位)
 */
public class SemaphoreTest {
    static Semaphore semaphore=new Semaphore(3);
    public static void main(String[] args) {
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"号抢到了车位");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3秒后"+Thread.currentThread().getName()+"号离开了车位");
                semaphore.release();

            },String.valueOf(i)).start();
        }
    }
}
