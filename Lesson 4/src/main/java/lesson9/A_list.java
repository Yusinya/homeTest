package main.java.lesson9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class A_list {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //List<Boolean> list2 = new ArrayList<>();
        /*arr[0] = 1;
        int i = arr[2];*/
        //arr.length
        System.out.println("List size: " + list.size());
        list.add(45);
        list.add(46);
        list.add(0,80);
        System.out.println(list.get(0));
       /* for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
        /*for (Integer el: list) {
            System.out.println(el);
        }*/
        Iterator it = list.iterator();
        while (it.hasNext()) System.out.println(it.next());

    }
}
