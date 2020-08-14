package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом while
*/

public class Task3 {

    public static void main(String[] args) {
        String s = "Yuliia";
        int a = 5;
        int b = 9;
        int i = 0;
        while (i < a) {
            i++;
            System.out.print("\n" + s + " ");
            int g = 0;
            while (g < b) {
                System.out.print(s + " ");
                g++;
            }
        }
    }
}