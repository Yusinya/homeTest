package test.java.HomeworkWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1_Rozetka_Open {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rozetka.com.ua/");
        By phone = By.xpath("//button[@class='header-phones__button']");
        Thread.sleep(1000);
        String phoneNumber = driver.findElement(phone).getText();
        phoneNumber = phoneNumber.replaceAll("[^A-Za-z0-9]","");
        System.out.println(phoneNumber);
        driver.quit();
    }
}
