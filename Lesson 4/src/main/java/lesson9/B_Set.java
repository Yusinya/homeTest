package main.java.lesson9;

import java.util.HashSet;
import java.util.Set;

public class B_Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.size();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);

        for (Integer el: set
             ) {
            System.out.println(el);
        }

    }
}
