package ThreadPoolDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
三种线程池的创建方法，有开启，就有关闭
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //模拟5个用户办理业务窗口
        ExecutorService executor= Executors.newFixedThreadPool(5);
        //模拟1个用户办理业务窗口
        //ExecutorService executor= Executors.newSingleThreadExecutor();
        //模拟n个用户办理业务窗口
        //ExecutorService executor= Executors.newCachedThreadPool();


        try {
            for (int i = 0; i <10 ; i++) {
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"come in");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

    }
}
