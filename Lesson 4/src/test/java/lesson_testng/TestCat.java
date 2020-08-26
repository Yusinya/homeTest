package test.java.lesson_testng;

import main.java.lesson4.Cat;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class TestCat {
    Cat cat;
    String matrixRows;

    @BeforeClass
    public void beforeAllMethods() {
        cat = new Cat("Vasya");
    }

    @BeforeMethod
    public void setup() {
        matrixRows = cat.getMatrix();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After methods");
    }

    @AfterClass
    public void afterAllMethods() {
    }

   /* @BeforeGroups(dependsOnGroups = "getMatrix")
    public void beforeGetMatrixTests (){
        matrixRows = cat.getMatrix();
    }*/

    @Test//(dependsOnGroups = "getMatrix", dependsOnMethods = "testGetMatrixShouldReturnRaws")
    public void testGetAge(){
        int ageToChange = 10;
        cat.setAge(ageToChange);
        int actualAge = cat.getAge();
        int expectedAge = ageToChange;
        System.out.printf("Test 1 with age to change = '%d' and expected age = '%d'\n", ageToChange, expectedAge);
        assertEquals(actualAge, expectedAge, String.format ("Expected cat age to be '%d'", expectedAge));
    }

    @Test//(groups = "getMatrix")
    public void testGetMatrixShouldReturnRaws() {
        int expectedRowAmount = 5;
        int actualRawAmount = matrixRows.split("\n").length;
        assertEquals(actualRawAmount, expectedRowAmount);
    }

    @Test//(groups = "getMatrix")
    public void testGetMatrixReturnRowsLength() {
        String[] rows = matrixRows.split("\n");
        for (String row: rows) {
            int expectedRowLength = 5;
            int actualRawLength = row.split(" ").length;
            assertEquals(actualRawLength, expectedRowLength);
        }
    }

    //параметризированный тест:
    @Test(dataProvider = "dp")
    public void testGetAge2(int ageToChange, int expectedAge){
        System.out.printf("Test 1 with age to change = '%d' and expected age = '%d'\n", ageToChange, expectedAge);
        Cat cat = new Cat();
        cat.setAge(ageToChange);
        int actualAge = cat.getAge();

        assertEquals(actualAge, expectedAge/*, String.format ("Expected cat age to be '%d'", expectedAge)*/);
    }
    @DataProvider(name = "dp")
    public Object[][] provider() {
        return new Object[][] {
                {-1, 20},
                {0, 20},
                {1, 1},
                {10, 10},
                {21, 21},
                {22, 20}
        };
    }
}
