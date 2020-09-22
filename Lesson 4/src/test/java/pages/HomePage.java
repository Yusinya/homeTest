package test.java.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    WebDriver driver;
    By contactBtnBy = By.cssSelector("[class='header-topline__links-item'] a[href$='/contacts/']");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomePage open() {
        this.logger.trace("Trace");
        this.logger.debug("Debug");
        this.logger.info("Info");
        this.logger.warn("Warn");
        this.logger.error("Error");
        this.logger.fatal("Fatal");


        this.logger.info("Home page was opened");
        logger.debug("Debug");
        this.driver.get("https://rozetka.com.ua/");
        return this;
    }
    public HomePage clickContacts() {
        logger.info("Click Contact page");
        WebElement contactButton = driver.findElement(contactBtnBy);
        wait.until(ExpectedConditions.elementToBeClickable(contactBtnBy));
        contactButton.click();
        return this;
    }
}
