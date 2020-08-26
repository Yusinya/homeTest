package main.java.Lesson_1_Homework;

public class Task1 {
    /* Минимум трех чисел
    Написать функцию, которая вычисляет минимум из трёх чисел.
    */
    public static void main(String[] args) {
        System.out.println(min(5,2,3));
    }

    public static int min(int a, int b, int c) {
        int result;
        if (a < b && a < c) {
            result = a;
        }
        else if (b < a && b < c) {
            result = b;
        }
        else {
            result = c;
        }
        return result;
    }

}
