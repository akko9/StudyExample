package JucTools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
循环栅栏(七龙珠)
 */
public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{  System.out.println("成功收集了7龙珠");});
    public static void main(String[] args) {
        for (int i = 1; i <=7 ; i++) {
            new Thread(()->{
                try {
                    System.out.println("收集了"+Thread.currentThread().getName()+"龙珠");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
