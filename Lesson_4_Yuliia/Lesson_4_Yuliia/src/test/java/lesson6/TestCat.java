package test.java.lesson6;

import main.java.lesson4.Cat;

public class TestCat {
    public static void main(String[] args) {
        Cat cat = new Cat ();
        int age = 105;
        cat.setAge(age);
        int actualAge = cat.getAge();
        int expectedAge = 15;
        if (actualAge != expectedAge);{
            throw new Error("Validation failed");
        }
    }
    }

