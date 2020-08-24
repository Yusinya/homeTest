package lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.naming.ldap.LdapReferralException;

public class A_RunBrowser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        //options.addArguments("window-size=500,1200");
        //options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/notebooks/c80004/");

        By city = By.cssSelector("a[class='header-cities__link link-dashed']");
        By city2 = By.xpath("//a[@class='header-cities__link link-dashed']");
        By city3 = By.partialLinkText("Запорожье");
        /*By city4 = By.id("SomeId");
        By city5 = By.cssSelector("#SomeId");*/

        Thread.sleep(5000);

        //String cityValue = driver.findElement(city).getText();
        /*WebElement cityElement = driver.findElement(city);
        String cityValue = cityElement.getText();*/
        String cityValue = driver.findElement((By.cssSelector("a[class='header-cities__link link-dashed']"))).getText();
        System.out.println(cityValue);

        WebElement producerInput = driver.findElement(By.cssSelector("*[data-filter-name='producer'] input[name='searchline']"));
        producerInput.sendKeys("Apple");
        Thread.sleep(5000);

        driver.quit();
    }
}
