package com.madcord.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

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
    private By manageMembers = By.xpath("//*[@class='lucide lucide-users h-4 w-4 ml-auto']");
    private By manageMemberList = By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[1]/div[1]/span[1]/img[1]");
    private By createChannelSettings = By.xpath("//*[@class='lucide lucide-circle-plus h-4 w-4 ml-auto']");
    private By createChannelButton = By.xpath("/html[1]/body[1]/div[5]/form[1]/div[2]/button[1]");
    private By deleteServerSettings = By.xpath("//*[@class='lucide lucide-trash h-4 w-4 ml-auto']");
    private By deleteServerText = By.xpath("//p[@id='radix-:rk:']");
    private By toggleMode = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/button[1]");
    private By lightMode = By.xpath("//div[contains(text(),'Light')]");
    private By darkMode = By.xpath("//div[contains(text(),'Dark')]");
    private By lightModeIcon = By.cssSelector(".lucide-sun");
    private By darkModeIcon = By.cssSelector(".lucide-moon");
    private By userSettingsButton = By.cssSelector(".cl-avatarImage");
    private By signOutButton = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[2]");
    private By signInPage = By.cssSelector(".cl-headerTitle");
    private By searchButton = By.cssSelector(".mt-2 > button:nth-child(1)");
    private By searchBar = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/input[1]");
    private By channelName = By.cssSelector("p.font-semibold:nth-child(3)");
    private By searchGeneral = By.xpath("//span[contains(text(),'general')]");

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

    public boolean isManageMembersOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(manageMemberList));
        return find(manageMemberList).isDisplayed();
    }

    public boolean isCreateChannelsOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createChannelButton));
        return find(createChannelButton).isDisplayed();
    }

    public boolean isDeleteServerOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteServerText));
        String deleteText = find(deleteServerText).getText();
        return deleteText.contains("permanently deleted");
    }

    public boolean isLightModeApplied() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lightModeIcon));
        return find(lightModeIcon).isDisplayed();
    }

    public boolean isDarkModeApplied() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(darkModeIcon));
        return find(darkModeIcon).isDisplayed();
    }

    public boolean isSearchSucessful(String isServerName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(channelName));
        String channelNameText = find(channelName).getText();
        return channelNameText.equals(isServerName);
    }

    public boolean isSignOutSuccessful() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInPage));
        String signInText = find(signInPage).getText();
        return signInText.contains("Sign in");
    }

    public boolean isSearchBarOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchGeneral));
        String searchBarText = find(searchGeneral).getText();
        return searchBarText.contains("general");
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

    public void clickManageMembersButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(manageMembers));
        click(manageMembers);
    }

    public void clickCreateChannelButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createChannelSettings));
        click(createChannelSettings);
    }

    public void clickDeleteServerButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteServerSettings));
        click(deleteServerSettings);
    }

    public void clickToggleMode() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toggleMode));
        click(toggleMode);
    }

    public void lightMode() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lightMode));
        click(lightMode);
    }

    public void darkMode() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(darkMode));
        click(darkMode);
    }

    public void clickUserSettingsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userSettingsButton));
        click(userSettingsButton);
    }

    public void clickSignOutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
        click(signOutButton);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        click(searchButton);
    }

    public void setSearchBar(String searchText) {
        WebElement searchBarField = driver.findElement(searchBar);
        searchBarField.sendKeys(searchText + Keys.ENTER);
    }

    public void searchBarShortCut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        WebElement searchButtonField = driver.findElement(searchButton);
        searchButtonField.sendKeys(Keys.CONTROL + "k");
    }
}
