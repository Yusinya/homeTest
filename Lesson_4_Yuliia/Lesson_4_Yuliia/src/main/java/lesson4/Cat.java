package main.java.lesson4;

public class Cat {
    private int age = 20;
    String name = "Barsik";
    static int totalAmount = 0;

    public Cat(String nameValue, int ageValue) {
        age = ageValue;
        name = nameValue;
    }

    public Cat() {
        Cat.totalAmount++;
        System.out.println("Initialized new cat");
    }

    public Cat(String nameValue) {
        name = nameValue;
    }



    public void setAge(int value) {
    if(value > 0 && value <= 20) {
        age = value;
        } else {
            System.out.println("This value can not be age:" + value);
        }
    }

    public int getAge(){
    return age;
    }

    public void sayHello(){
        System.out.println("Hello, my name is " + name);
    }

    public static int getDefaultAge() {
        return  20;
    }

    public String getMatrix(){
        String result = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result += "* ";
            }
            result += "\n";
            }
        return result;
        }
    }

