package test.java.HomeworkTestNG;

import main.java.Lesson_1_Homework.Task1;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TestForTask1 {

    Task1 task1 = new Task1();


    @Test(dataProvider = "DProvider")
    public void getMinNumber(int a,int b, int c) {
        System.out.println("Start HomeWork Test");
        int actualMinNumber = Task1.min(a, b, c);
        int expectedMinNumber = Math.min(Math.min(a, b),c);
        assertEquals(actualMinNumber, expectedMinNumber, String.format("Expected min number to be '%d'", expectedMinNumber));

    }

    @DataProvider(name = "DProvider")
    public Object[][] provider() {
        return new Object[][]{
                {
                        1, 2, 3
                },
                {
                        2, 5, 9
                },
                {
                        4, 6, 7
                }
        };
    }
}