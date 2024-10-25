package com.madcord.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServersPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle

    private By serversHeader = By.xpath("//*[@class='lucide lucide-hash w-5 h-5 text-zinc-500 dark:text-zinc-400 mr-2']");
    private By serversImg = By.xpath("//img[@alt='Channel']");
    private By serverMenu = By.xpath("//*[@class='lucide lucide-chevron-down h-5 w-5 ml-auto']");
    private By invitePeopleButton = By.xpath("//*[@class='lucide lucide-user-plus h-4 w-4 ml-auto']");
    private By generateNewLink = By.xpath("//*[@class='lucide lucide-refresh-cw w-4 h-4 ml-2']");
    private By copyIcon = By.xpath("//*[@class='lucide lucide-copy w-4 h-4']");
    private By checkIcon = By.xpath("//*[@class='lucide lucide-check w-4 h-4']");
    private By serverSettings = By.xpath("//*[@class='lucide lucide-settings h-4 w-4 ml-auto']");
    private By changeServerName = By.xpath("/html[1]/body[1]/div[5]/form[1]/div[1]/div[2]/input[1]");
    private By saveButton = By.cssSelector(".bg-indigo-500");
    private By serverName = By.xpath("//button[text()]");

    public boolean isServersHeaderDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serversHeader));
        return find(serversHeader).isDisplayed();
    }

    public boolean isServersImgDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serversImg));
        return find(serversImg).isDisplayed();
    }

    public boolean isCopied() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkIcon));
        return find(checkIcon).isDisplayed();
    }

    public void clickMenuButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serverMenu));
        click(serverMenu);
    }

    public void clickInvitePeopleButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(invitePeopleButton));
        click(invitePeopleButton);
    }

    public void clickGenerateNewLinkButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(generateNewLink));
        click(generateNewLink);
    }

    public void alertPass() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void copyLinkButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(copyIcon));
        click(copyIcon);
    }

    public void clickServerSettingsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serverSettings));
        click(serverSettings);
    }

    public void changeServerName(String changedName) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(changeServerName));
        WebElement serverNameField = driver.findElement(changeServerName);
        click(changeServerName);
        serverNameField.clear();
        serverNameField.sendKeys(changedName);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
        click(saveButton);
    }

    public String getServerName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serverName));
        return find(serverName).getText();
    }

    public void setWaitForServerNameChange(String changedName) {
        wait.until(ExpectedConditions.textToBe(serverName, changedName));
    }

}
