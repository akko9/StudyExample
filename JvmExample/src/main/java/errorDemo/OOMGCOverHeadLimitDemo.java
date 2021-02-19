package errorDemo;

import java.util.ArrayList;
import java.util.List;

/*
98%做GC，回收不到2%内存 -Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m -XX:+PrintGCDetails
 */
public class OOMGCOverHeadLimitDemo {
    public static void main(String[] args) {
        int i=0;
        List<String> list=new ArrayList<String>();


        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        //java.lang.OutOfMemoryError: GC overhead limit exceeded
    }
}
