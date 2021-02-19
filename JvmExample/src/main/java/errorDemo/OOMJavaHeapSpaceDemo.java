package errorDemo;

import java.util.Random;
//-Xms10m -Xmx10m
public class OOMJavaHeapSpaceDemo {
    public static void main(String[] args) {
        String a="test";
        while (true){
            a+=a+new Random().nextInt(1111111)+new Random().nextInt(2222222);
            a.intern();
        }
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
