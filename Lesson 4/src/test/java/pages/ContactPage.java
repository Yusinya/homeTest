package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage {
    WebDriver driver;
    By qaBtnBy = By.cssSelector("[class ='chips__item'] a[href$='/faq/']");

    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public ContactPage open() {
        driver.get("https://rozetka.com.ua/contacts/");
        return this;
    }

    public ContactPage clickQa() {
        logger.info("Click QA");
        wait.until(ExpectedConditions.elementToBeClickable(qaBtnBy));
        WebElement qaBtn = driver.findElement(qaBtnBy);
        qaBtn.click();
        return this;
    }
}
