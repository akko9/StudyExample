package BlockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/*
给定时间，当时间到达则停止执行
 */
public class OfferAndPollByTime {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(3);
        blockingQueue.offer(1,2 ,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
    }
}
