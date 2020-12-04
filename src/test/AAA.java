package test;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author haiboWu
 * @create 2020-11-08 16:53
 */
public  class AAA {
    public static void main(String[] args) {

        ArrayList<String> mylist = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                mylist.add("1");
                System.out.println(mylist);
            },String.valueOf(i)).start();
        }

        new Thread(()->{

        }).start();

    }
}
