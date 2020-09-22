package main.java.lesson9;

public abstract class Animal implements IAnimable {
    public String name = "Animal";

    public void sleep() {
        System.out.println("I am sleeping...");
    }
    public String toString() {
        System.out.println("Invoked method 'toString()'");
        return "Hello, my name is: " + name;
    }
    public abstract String getName();

    public void eat() {
        System.out.println("I am eating");
    }
}
