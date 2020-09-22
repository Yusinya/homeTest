package main.java.lesson9;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sleep();
        cat.meow();
        System.out.println(cat.toString());
        IAnimable animals[] = {new Cat(), new Dog(), new ImmortalPony(), cat};
        IMashinable cars[] = {new ImmortalPony()};

        IAnimable cat2 = new Cat();
        cat.sleep();
        Animal cat3 = new Cat();
        cat3.toString();
    }
}
