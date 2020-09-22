package test.java.HomeWorkLogging;

import oracle.jvm.hotspot.jfr.Producer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.pagesHW.LaptopPage;
import test.java.pagesHW.SearchResult;
import test.java.utils.Screenshot;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Logs {
    LaptopPage laptopPage;
    SearchResult searchResult;
    WebDriver driver;
    Logger logger = LogManager.getLogger(this.getClass().getName());

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        laptopPage = new LaptopPage(driver);
        searchResult = new SearchResult(driver);
    }


        @Test(dataProvider = "DProvider")
        public void test1 (String producer) throws InterruptedException {
            String producerBy = "//label[@for='" + producer + "']";
            By checkbox = By.xpath(producerBy);
            laptopPage.open();
            logger.info("Page with laptops is opened");
                searchResult.clickCheckBox(checkbox);
                logger.info("Checkbox is clicked");
                List<WebElement> searchItems = searchResult.getSearchItem();
                for (WebElement searchItem : searchItems
                ) {
                    Boolean actualTitle = searchItem.getText().toLowerCase().contains(producer.toLowerCase());
                    Boolean expectedTitle = true;
                    assertEquals(
                            actualTitle,
                            expectedTitle,
                            String.format("%s does not contain right title", searchItem.getText()));
                }
                logger.debug("Test was finished");
            }


    @DataProvider(name = "DProvider")
    public Object[][] provider() {
        return new Object[][]{
                {"Acer"},{"Apple"},{"Asus"},{"Dell"},{"Dream Machines"},{"HP"},{"Lenovo"},{"MSI"},{"Microsoft"},{"Razer"},{"Xiaomi"},{"Google"},{"Panasonic"},{"Vinga"},{"Yepo"}
        };
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        Screenshot screenshot = new Screenshot(driver);
        screenshot.makeScreenshot(result);
        driver.quit();
    }

        }


