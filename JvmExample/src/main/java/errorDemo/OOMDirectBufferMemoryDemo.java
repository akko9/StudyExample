package errorDemo;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/*
-Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m -XX:+PrintGCDetails
设置本地内存为5m，但分配6m
 */
public class OOMDirectBufferMemoryDemo {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(6*1024*1024);
    }
    //Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
}
