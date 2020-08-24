package main.java.lesson4;


public class A_object {
    public static void main(String[] args) {
        Cat barsik = new Cat("Barsik", 13);
        Cat barsik2 = new Cat("Barsik2",12);

        //int age = barsik.age;
        //barsik.age = 50;
        barsik.setAge(25);
        System.out.println(barsik.getAge());
        barsik2.name = "barsik2";

        System.out.println(barsik.name);
        System.out.println(barsik2.name);

        barsik.sayHello();
        barsik2.sayHello();
        System.out.println("Default age is: " + Cat.getDefaultAge());
        System.out.println("Total amount of cats is :" + barsik.totalAmount);
    }
}
