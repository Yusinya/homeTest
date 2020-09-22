package main.java.lesson9;

public class Cat extends Animal{
    public void meow() {
        System.out.println("Meow...");
    }

    @Override

    public String toString() {
        System.out.println("Cat toString() invoked");
        String temp = super.toString();
        return temp + " Cat";
    }

    @Override
    public String getName() {
        return "Cat";
    }


}
