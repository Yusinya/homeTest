package test.java.lesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestCollections {
    WebDriverWait wait;
    WebDriver driver;
    String expectedFontColor = "rgba(62, 119, 170, 1)";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 10, 500);

    }

    @Test
    public void test1() {
        driver.get("https://rozetka.com.ua/");
        List<WebElement> categories = driver.findElements(By.cssSelector("[class='menu-categories__link']"));
        for (WebElement category:  categories) {
            String actualFontColor = category.getCssValue("color");
            assertEquals(
                    actualFontColor,
                    expectedFontColor,
                    String.format("Expected blue font color for element '%s'", category.getText()));
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
