package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом for
*/

public class Task2 {

    public static void main(String[] args) {
        String s = "Yuliia";
        int a = 5;
        int b = 9;
        for (int i = 0; i < a; i++) {
            System.out.print("\n" + s + " ");
            for ( int g = 0; g < b; g++) {
                System.out.print(s + " ");
            }
        }
    }
}


