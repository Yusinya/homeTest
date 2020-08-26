package test.java.HomeworkTestNG;

import org.testng.annotations.Test;

import static lesson1.Task5.reverse;
import static org.testng.Assert.assertEquals;

public class TestForTask5 {

    @Test
    public void testReversWord () {
        System.out.println("Last task is started");
        String actualReversWord;
        String value = "Hello World!";
        String expectedReversWord = new StringBuffer(value).reverse().toString();
        actualReversWord = reverse(value);
        assertEquals(expectedReversWord, actualReversWord);
    }

    @Test
    public void testFirstLastLetter () {
        String value = "Hello World!";
        char actualFirstLetter = reverse(value).charAt(0);
        char expectedFirstLetter = '!';
        System.out.println(actualFirstLetter);
        assertEquals(actualFirstLetter, expectedFirstLetter);
    }
}
