package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class QaPage {
    WebDriver driver;
    WebDriverWait wait;
    By questionBy = By.cssSelector("[name='slider-block-active']");

    public QaPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public List<WebElement> getQuestion() {
        List<WebElement> questions = driver.findElements(questionBy);
        wait.until(ExpectedConditions.elementToBeClickable(questions.get(0)));
        return questions;
    }
}
