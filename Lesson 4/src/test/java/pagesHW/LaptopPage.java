package test.java.pagesHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class LaptopPage {
    WebDriver driver;
    WebDriverWait wait;

    public LaptopPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public LaptopPage open () {
        driver.get("https://rozetka.com.ua/notebooks/c80004/preset=workteaching/");
        return this;
    }
}
