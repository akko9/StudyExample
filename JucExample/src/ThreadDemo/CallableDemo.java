package ThreadDemo;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
callable 该方法可以实现:把一个串行计算变成一个并行计算,把计算时间较长的工作拉出去单独计算最后进行返回合并。
 */
public class CallableDemo {

    static class MyThread implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("callable come in");
            return 1024;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FutureTask实现了RunnableFuture接口,RunnableFuture又继承了Runnable接口。
        //FutureTask实现了public FutureTask(Callable<V> callable)方法 适配器模式
        FutureTask<Integer> futureTask=new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2=new FutureTask<>(new MyThread());
        new Thread(futureTask,"AA").start();
//        new Thread(futureTask,"BB").start();该方法不会被调用,不会做相同的事情，以免重复，浪费资源
        new Thread(futureTask2,"BB").start(); //若想重复调用 ，则需新建一个FutureTask
// 放在这可能会阻塞        int task02=futureTask.get();
        int task01=1024;
        //该方法尽量放在最后,否则线程会阻塞,当调用该方法时，该线程为执行完成，访问不出结果，会进行等待,直到得到结果
        int task02=futureTask.get();
        while (!futureTask.isDone()){
            //当未取到结果则一直循环等待，
        }
        int result=task01+task02;
        System.out.println("结果为:"+result);
    }
}
