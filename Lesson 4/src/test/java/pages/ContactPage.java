package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    WebDriver driver;
    WebDriverWait wait;
    By qaBtnBy = By.cssSelector("[class ='chips__item'] a[href$='/faq/']");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10,500);
    }
    public ContactPage clickQa() {
        wait.until(ExpectedConditions.elementToBeClickable(qaBtnBy));
        WebElement qaBtn = driver.findElement(qaBtnBy);
        qaBtn.click();
        return this;
    }
}
