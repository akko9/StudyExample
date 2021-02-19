package BlockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/*
blockingQueue的put和take方法
返回:当队列满时，程序不结束，put会继续等待队列可以put
take同理
 */
public class PutAndTake {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(3);
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
    }
}
