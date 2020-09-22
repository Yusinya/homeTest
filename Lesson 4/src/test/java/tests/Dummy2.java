package test.java.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.ContactPage;
import test.java.pages.HomePage;
import test.java.pages.QaPage;

import java.util.concurrent.TimeUnit;

public class Dummy2 extends TestBaseSetup{
    HomePage homePage;
    ContactPage contactPage;

    @BeforeMethod
    public void pageFactory() {
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }

    @Test
    public void test1() {
        homePage.open();
    }
    @Test
    public void test2(){
        contactPage.open();
    }
}




