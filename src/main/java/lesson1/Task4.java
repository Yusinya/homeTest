package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом do () while
*/

public class Task4 {

    public static void main(String[] args) {
        String s = "Yuliia";
        int a = 5;
        int b = 9;
        int i = 0;

        do {
            i++;
            System.out.print( "\n" + s + " ");
            int g = 0;
            do {
                g++;
                System.out.print(s + " ");
            }
            while (g < b);
        }
        while (i < a) ;
    }
    }
