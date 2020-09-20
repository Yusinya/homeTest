package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.ContactPage;
import test.java.pages.HomePage;
import test.java.pages.QaPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PoDummy {
    WebDriver driver;
    HomePage homePage;
    ContactPage contactPage;
    QaPage qaPage;
    String expectedFondColor = "rgba(62, 119, 170, 1)";


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
        qaPage = new QaPage(driver);
    }

    @Test
    public void test1() {
        homePage
                .open()
                .clickContacts();
        contactPage
                .clickQa();
        List<WebElement> questions = qaPage.getQuestion();
        for (WebElement question :
                questions) {
            String actualFontColor = question.getCssValue("color");
            assertEquals(
                    actualFontColor,
                    expectedFondColor,
                    String.format("Expected blue color for question '%s'", question.getText()));
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
