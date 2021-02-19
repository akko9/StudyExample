package ThreadPoolDemo;

import java.util.concurrent.*;
/*
自定义线程池
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService executor=new ThreadPoolExecutor(
                2,
                5,
                100L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        // new ThreadPoolExecutor.AbortPolicy()
        try {
            for (int i = 1; i <=10 ; i++) {
                final int temp=i;
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"service in "+temp);
                    try {
                        TimeUnit.SECONDS.sleep(4L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
