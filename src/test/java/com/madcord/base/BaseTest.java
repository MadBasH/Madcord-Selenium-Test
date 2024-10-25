package com.madcord.base;

import com.madcord.pages.BasePage;
import com.madcord.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;

    private String url = "https://madcord-final-production.up.railway.app/";
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // WebDriver'ı başlatma
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);

        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();

        // WebDriverWait oluşturma
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login sayfasındaki öğeleri bekleme
        waitForElement(loginPage.getLoginButtonLocator());
        waitForElement(loginPage.getUsernameFieldLocator());
    }

    protected void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
