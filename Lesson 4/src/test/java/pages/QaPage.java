package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class QaPage extends BasePage{
    WebDriver driver;
    By questionBy = By.cssSelector("[name='slider-block-active']");

    public QaPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public QaPage open() {
        logger.info("QA page is open");
        driver.get("https://rozetka.com.ua/faq/");
        return this;
    }

    public List<WebElement> getQuestion() {
        logger.info("Get question");
        List<WebElement> questions = driver.findElements(questionBy);
        wait.until(ExpectedConditions.elementToBeClickable(questions.get(0)));
        return questions;
    }
}
