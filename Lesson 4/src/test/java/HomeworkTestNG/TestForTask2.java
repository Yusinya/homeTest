package test.java.HomeworkTestNG;

import main.java.Lesson_1_Homework.Task2;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestForTask2 {

    @Parameters({"expectedRow"})
    @Test
public void testGetNameRows (int expectedRow) {
    Task2 task2;
    String matrixRows;
    matrixRows = Task2.getName();
    int actualRow = matrixRows.split("\n").length;
    assertEquals(actualRow, expectedRow, String.format("Actual number of rows: '%d', expected numbers of rows: '%d'", actualRow, expectedRow));


}
}
