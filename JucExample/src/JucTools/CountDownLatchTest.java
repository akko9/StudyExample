package JucTools;

import utils.CountryEnum;

import java.util.concurrent.CountDownLatch;

/*
倒计时锁
例:灭六国
 */
public class CountDownLatchTest {
    //设置倒计时count为6
    static CountDownLatch countDownLatch=new CountDownLatch(6);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {

                    System.out.println(Thread.currentThread().getName()+"国被消灭!");
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, CountryEnum.GetCountryName(i)).start();
        }
        countDownLatch.await();
        System.out.println("秦国统一");
    }
}
