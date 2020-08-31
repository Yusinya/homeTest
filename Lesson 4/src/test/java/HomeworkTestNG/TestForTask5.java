package test.java.HomeworkTestNG;

import org.testng.annotations.*;

import static lesson1.Task5.reverse;
import static org.testng.Assert.assertEquals;

public class TestForTask5 {
    String value;

    @BeforeMethod
    public void setup () {
        value = "Hello world!";
    }

    @Test
    public void testReversWord () {
        System.out.println("Last task is started");
        String actualReversWord;
        String expectedReversWord = new StringBuffer(value).reverse().toString();
        actualReversWord = reverse(value);
        assertEquals(expectedReversWord, actualReversWord);
    }

    @Test
    public void testFirstLastLetter () {
        char actualFirstLetter = reverse(value).charAt(0);
        char expectedFirstLetter = '!';
        System.out.println(actualFirstLetter);
        assertEquals(actualFirstLetter, expectedFirstLetter);
    }

    @AfterMethod
    public void afterMethod () {
    }
}
