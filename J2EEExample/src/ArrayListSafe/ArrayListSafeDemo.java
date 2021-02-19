package ArrayListSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListSafeDemo {
    public static void main(String[] args) {
        //List<String> list=new ArrayList<>();
        //List<String> list= Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <3 ; i++) {
            new Thread(()->{
                for (int j = 0; j <10 ; j++) {
                    list.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(list);
                }

            }).start();
        }


    }
}
