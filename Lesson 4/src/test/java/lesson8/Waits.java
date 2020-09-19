package test.java.lesson8;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;

public class Waits {
    WebDriver driver;
    WebDriverWait wait;
    By goodlist = By.cssSelector("[class='menu-categories menu-categories_type_main']");
    By wishBy = By.cssSelector("[class='header-actions__item header-actions__item_type_wish js-app-wishlist']");
    By registerBy = By.xpath("//a[contains(text(),'авторизуйтесь')]");
    By authEmailBy = By.cssSelector("[id='auth_email']");
    By authPasswordBy = By.cssSelector("[id='auth_pass']");
    By EnterBy = By.xpath("//button[contains(text(),'Войти')]");
    By errorMsgBy = By.cssSelector("[class^='error-message']");
    By requireTempPass = By.xpath("//button[contains(text(),'Пришлите мне')]");


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    public void test1() throws InterruptedException {
        String email = "a@a.a";
        driver.get("https://rozetka.com.ua/");
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(wishBy));
        actions
                .moveToElement(driver.findElement(wishBy))
                //.click(driver.findElement(registerBy))
                .perform();
        //driver.findElement(registerBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerBy));
        driver.findElement(wishBy).findElement(registerBy).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(authEmailBy),
                ExpectedConditions.elementToBeClickable(authPasswordBy),
                ExpectedConditions.elementToBeClickable(EnterBy)
        ));
        driver.findElement(authEmailBy).sendKeys(email);
        driver.findElement(authPasswordBy).sendKeys("1");
        driver.findElement(EnterBy).click();
        wait.until(ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(requireTempPass),
                ExpectedConditions.presenceOfAllElementsLocatedBy(errorMsgBy)
        ));
        if(driver.findElement(requireTempPass).isDisplayed()) {
            driver.findElement(requireTempPass).click();
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(errorMsgBy),
                    ExpectedConditions.invisibilityOfElementLocated(requireTempPass)
            ));
        }

       /* new WebDriverWait(driver, 15).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return driver.findElement(errorMsgBy).getText().contains("Пользователь с логином");
            }
        });*/

        //new WebDriverWait(driver, 15).until(d -> d.findElement(errorMsgBy).getText().contains("Пользователь с логином"));

        String actualErrorMsg = driver.findElement(errorMsgBy).getText();
        String expextedErrorMsg = String.format("Пользователь с логином %s не зарегистрирован", email);
        assertEquals(actualErrorMsg, expextedErrorMsg);
        /*driver.navigate().refresh();
        driver
                .findElement(goodlist)
                .click();*/
        Thread.sleep(500);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
