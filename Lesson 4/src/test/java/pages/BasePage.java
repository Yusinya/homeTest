package test.java.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriverWait wait;
    Logger logger = LogManager.getLogger(this.getClass().getName());

    BasePage (WebDriver driver) {
        wait = new WebDriverWait(driver, 10, 500);
    }

    public abstract BasePage open();

}
