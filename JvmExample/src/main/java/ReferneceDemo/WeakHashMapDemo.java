package ReferneceDemo;


import java.util.HashMap;
import java.util.WeakHashMap;
/*
当gc是weekHashMap的值被垃圾回收器回收
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        //MyHashMap();
        MyWeakHashMap();
    }

    private static void MyWeakHashMap() {
        WeakHashMap<Integer,String> map=new WeakHashMap<Integer, String>();
        Integer key=new Integer(1);
        String value="hashMap";
        map.put(key,value);

        key=null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void MyHashMap() {
        HashMap<Integer,String> map=new HashMap<Integer, String>();
        Integer key=new Integer(1);
        String value="hashMap";
        map.put(key,value);

        key=null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }
}
