package main.java.lesson9;

public class ImmortalPony extends Animal implements IMashinable {

    @Override
    public String getName() {
        return null;
    }


    @Override
    public void repare() {
        System.out.println("Repare");
    }
}
