package test.java.pagesHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.pages.HomePage;

public class HomePageRozetka {
    WebDriver driver;
    WebDriverWait wait;
    By searchFieldBy = By.cssSelector("[class='search-form__input ng-untouched ng-pristine ng-valid']");
    By searchBtnBy = By.cssSelector("[class='button button_color_green button_size_medium search-form__submit']");

    public HomePageRozetka (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public HomePageRozetka open () {
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    public HomePageRozetka inputSearchValue(String str) {
        wait.until(ExpectedConditions.elementToBeClickable(searchFieldBy));
        driver.findElement(searchFieldBy).sendKeys(str);
        return this;
    }
    public HomePageRozetka clickSearchBtn() {
        driver.findElement(searchBtnBy).click();
        return this;
    }
}
