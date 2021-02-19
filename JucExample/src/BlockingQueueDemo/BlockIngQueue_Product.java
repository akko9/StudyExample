package BlockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockIngQueue_Product {
    volatile boolean flag=true;  //生产/消费标识符  volatile 可见性，防止指令重排,但无原子性
    AtomicInteger atomicInteger=new AtomicInteger(); //Integer 原子类 ，实现原子性
    BlockingQueue blockingQueue=null;  //实现队列接口

    public BlockIngQueue_Product(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    public void pro() throws InterruptedException {
        String value;
        boolean offerFlag;  //offer返回值
        while (flag){
            value=atomicInteger.getAndIncrement()+"";
            offerFlag = blockingQueue.offer(value,2L,TimeUnit.SECONDS);
            if (offerFlag){
                System.out.println(Thread.currentThread().getName()+"正在生产!"+value);
            }else {
                System.out.println(Thread.currentThread().getName()+"生产结束!");
            }
            TimeUnit.SECONDS.sleep(1L);

        }
    }
    public void cus() throws InterruptedException {
        String pollFlag=null;
        while (flag){
            pollFlag = (String) blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (pollFlag==null||pollFlag.equalsIgnoreCase("")){
                flag=false;
                System.out.println(Thread.currentThread().getName()+"超出时间!");
                return;
            }
            TimeUnit.SECONDS.sleep(1L);
            System.out.println(Thread.currentThread().getName()+"消费中!"+pollFlag);
        }
    }
    public void shop(){
        flag=false;
    }
    public static void main(String[] args) {
        BlockIngQueue_Product blockIngQueue_product=new BlockIngQueue_Product(new ArrayBlockingQueue(3));
        new Thread(()->{
            System.out.println("生产线程启动!");
            try {
                blockIngQueue_product.pro();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        new Thread(()->{
            try {
                blockIngQueue_product.cus();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
        try {
            TimeUnit.SECONDS.sleep(5L);
            blockIngQueue_product.shop();
            System.out.println("boss叫停，执行5秒后叫停");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
