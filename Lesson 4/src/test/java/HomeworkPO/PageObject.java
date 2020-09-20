package test.java.HomeworkPO;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pagesHW.HomePageRozetka;
import test.java.pagesHW.SearchResult;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PageObject {
    HomePageRozetka homePageRozetka;
    WebDriver driver;
    SearchResult searchResult;
    Boolean expectedTitle = true;

    @BeforeMethod
            public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        homePageRozetka = new HomePageRozetka(driver);
        searchResult = new SearchResult(driver);
    }

    @Test
    public void test1 () throws InterruptedException {

        String goodName = "iPhone";
        homePageRozetka
                .open()
                .inputSearchValue(goodName)
                .clickSearchBtn();
        List<WebElement> searchItems = searchResult.getSearchItem();
        for (WebElement searchItem:  searchItems
             ) {
            Boolean actualTitle = searchItem.getText().contains("iPhone");
            assertEquals(
                    actualTitle,
                    expectedTitle,
                    String.format("%s does not contain iPhone in title", searchItem.getText()));
        }
    }

    @Test
    public void test2 () throws InterruptedException {
        String goodName = "Samsung";
        homePageRozetka
                .open()
                .inputSearchValue(goodName)
                .clickSearchBtn();
        List<WebElement> searchItems = searchResult.getSearchItem();
        for (WebElement searchItem:  searchItems
        ) {
            Boolean actualTitle = searchItem.getText().toLowerCase().contains("samsung");
            assertEquals(
                    actualTitle,
                    expectedTitle,
                    String.format("%s does not contain Samsung in title", searchItem.getText()));
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
