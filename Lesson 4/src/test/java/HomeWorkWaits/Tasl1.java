package test.java.HomeWorkWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Tasl1 {
    WebDriver driver;
    WebDriverWait wait;
    By cabinet = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By registrationHome = By.cssSelector("[class='auth-modal__register-link']");
    By surname = By.xpath("//input[@formcontrolname='surname']");
    By name = By.xpath("//input[@formcontrolname='name']");
    By username = By.xpath("//input[@formcontrolname='username']");
    By password = By.xpath("//input[@formcontrolname='password']");
    By registrationPopup = By.cssSelector("[class='button button_size_large button_color_green auth-modal__submit']");
    String nameValue = "Юлька";
    String surnameValue = "Крамаренко";
    String expectedRedBorder = "rgb(248, 65, 71)";
    String expectedWhiteBorder = "rgb(210, 210, 210)";


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10,1000);
        driver.get("https://rozetka.com.ua/");
        driver.findElement(cabinet).click();
        driver.findElement(registrationHome).click();
        wait.until(ExpectedConditions.elementToBeClickable(surname));

    }

    @Test
    public void test1() {
    driver.findElement(surname).click();
    driver.findElement(name).click();
    driver.findElement(username).click();
    driver.findElement(password).click();
    driver.findElement(registrationPopup).click();
    String borderName = driver.findElement(name).getCssValue("border-color");
    String borderSurname = driver.findElement(surname).getCssValue("border-color");
    String borderUsername = driver.findElement(username).getCssValue("border-color");
    String borderPassword = driver.findElement(password).getCssValue("border-color");
    assertEquals(borderName, expectedRedBorder, String.format("%s border is not red", name));
    assertEquals(borderPassword, expectedRedBorder, String.format("%s border is not red", password));
    assertEquals(borderSurname, expectedRedBorder, String.format("%s border is not red", surname));
    assertEquals(borderUsername, expectedRedBorder, String.format("%s border is not red", username));
    }


    @Test
    public void test2() {
        driver.findElement(surname).sendKeys(surnameValue);
        driver.findElement(name).sendKeys(nameValue);
        driver.findElement(username).click();
        driver.findElement(password).click();
        driver.findElement(registrationPopup).click();
        String borderName = driver.findElement(name).getCssValue("border-color");
        String borderSurname = driver.findElement(surname).getCssValue("border-color");
        String borderUsername = driver.findElement(username).getCssValue("border-color");
        String borderPassword = driver.findElement(password).getCssValue("border-color");
        assertEquals(borderName, expectedWhiteBorder, String.format("%s border is not white", name));
        assertEquals(borderSurname, expectedWhiteBorder, String.format("%s border is not white", surname));
        assertEquals(borderUsername, expectedRedBorder, String.format("%s border is not white", username));
        assertEquals(borderPassword, expectedRedBorder, String.format("%s border is not white", password));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
