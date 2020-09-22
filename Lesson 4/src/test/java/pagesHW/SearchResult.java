package test.java.pagesHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResult {
    WebDriver driver;
    WebDriverWait wait;
    By searchItemBy = By.cssSelector("[class='goods-tile__title']");


    public SearchResult(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }
    public List<WebElement> getSearchItem() {
        wait.until(ExpectedConditions.elementToBeClickable(searchItemBy));
        List<WebElement> searchItems = driver.findElements(searchItemBy);
        return searchItems;
    }

    public SearchResult clickCheckBox(By checkBox) {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
    driver.findElement(checkBox).click();
    wait.until(ExpectedConditions.elementToBeClickable(searchItemBy));
    return this;
    }
}
