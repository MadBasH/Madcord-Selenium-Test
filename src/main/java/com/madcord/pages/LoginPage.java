package com.madcord.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    private By usernameField = By.xpath("//input[@id='identifier-field']");
    private By passwordField = By.cssSelector("#password-field");
    private By loginButton = By.xpath("//span[@class='cl-internal-2iusy0']");
    private By missingUsername = By.xpath("//body[@class='__variable_d7237b antialiased bg-white dark:bg-[#313338]']/div[@class='h-full flex items-center justify-center']/div[@class='cl-rootBox cl-signIn-root \uD83D\uDD12\uFE0F cl-internal-phfxlr']/div[@class='cl-cardBox cl-signIn-start \uD83D\uDD12\uFE0F cl-internal-7hb1uf']/div[@class='cl-card cl-signIn-start \uD83D\uDD12\uFE0F cl-internal-1p733cp']/div[@class='cl-main \uD83D\uDD12\uFE0F cl-internal-qo3qk7']/form[@class='cl-form \uD83D\uDD12\uFE0F cl-internal-tgducu']/div[@class='cl-internal-w8uam1']/div[@class='cl-formFieldRow cl-formFieldRow__identifier \uD83D\uDD12\uFE0F cl-internal-1yma7i9']/div[@class='cl-formField cl-formField__identifier \uD83D\uDD12\uFE0F cl-internal-10rdw13']/div[@class='cl-internal-wl6txu']/p[2]");
    private By incorrectPassword = By.xpath("//body[@class='__variable_d7237b antialiased bg-white dark:bg-[#313338]']/div[@class='h-full flex items-center justify-center']/div[@class='cl-rootBox cl-signIn-root \uD83D\uDD12\uFE0F cl-internal-phfxlr']/div[@class='cl-cardBox cl-signIn-password \uD83D\uDD12\uFE0F cl-internal-7hb1uf']/div[@class='cl-card cl-signIn-password \uD83D\uDD12\uFE0F cl-internal-1p733cp']/div[@class='cl-main \uD83D\uDD12\uFE0F cl-internal-13hikk6']/form[@class='cl-form \uD83D\uDD12\uFE0F cl-internal-tgducu']/div[@class='cl-formFieldRow cl-formFieldRow__password \uD83D\uDD12\uFE0F cl-internal-1yma7i9']/div[@class='cl-formField cl-formField__password \uD83D\uDD12\uFE0F cl-internal-10rdw13']/div[@class='cl-internal-wl6txu']/p[2]");

    public boolean waitForUrlToChange(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
        wait.until(ExpectedConditions.urlToBe(expectedUrl)); // Beklenen URL'ye ulaşmayı bekle
        return true;
    }

    public By getLoginButtonLocator() {
        return loginButton;
    }

    public By getUsernameFieldLocator() {
        return usernameField;
    }

    public void setUsername(String username) {
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    // Sayfa değişeceği için return lazım
    public ServersPage clickLoginButton() {
        click(loginButton);
        return new ServersPage();
    }

    // Sayfa değişeceği için return lazım
    public ServersPage logIntoApplication(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessageUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(missingUsername)); // Hata mesajının görünmesini bekle
        return find(missingUsername).getText();
    }

    public String getErrorMessagePassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectPassword)); // Hata mesajının görünmesini bekle
        return find(incorrectPassword).getText();
    }

    public String getCurrentUrl () {
        return driver.getCurrentUrl();
    }
}
