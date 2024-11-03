package com.madcord.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ChannelsPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle

    private By welcomeToChat = By.cssSelector(".text-xl");
    private By createChannelButton = By.xpath("//*[@class='lucide lucide-plus h-4 w-4']");
    private By createChannelName = By.xpath("/html[1]/body[1]/div[5]/form[1]/div[1]/div[1]/input[1]");
    private By createChannelTypeButton = By.xpath("//*[@class='lucide lucide-chevron-down h-4 w-4 opacity-50']");
    private By createChannelTypeSelect = By.xpath("/html[1]/body[1]/div[5]/form[1]/div[1]/div[2]/select[1]");
    private By createButton = By.xpath("/html[1]/body[1]/div[5]/form[1]/div[2]/button[1]");
    private By channelsField = By.cssSelector("div.px-3:nth-child(2) > div:nth-child(2) > div:nth-child(1)");
    private By editChannelButton = By.cssSelector("div:nth-child(3) > svg:nth-child(1)");
    private By videoChannelIcon = By.cssSelector(".lucide-video");
    private By deleteChannelIcon = By.cssSelector("div:nth-child(3) > svg:nth-child(2)");
    private By deleteChannelButton = By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/button[2]");
    private By getChannelName(String channelName) {
        return By.xpath("//p[contains(text(),'" + channelName + "')]");
    }


    public boolean isWelcomeToChatDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeToChat));
        return find(welcomeToChat).isDisplayed();
    }

    public boolean isChannelCreated(String createdChannelName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(channelsField));
        // Belirli bir süre boyunca yeni kanalın görünür olup olmadığını kontrol edin
        wait.until(ExpectedConditions.textToBePresentInElementLocated(channelsField, createdChannelName));
        String channelName = find(channelsField).getText();
        return channelName.contains(createdChannelName);
    }

    public boolean isChannelDeleted(String deletedChannelName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(channelsField));
        // Belirli bir süre boyunca yeni kanalın görünür olup olmadığını kontrol edin
        boolean isChannelInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//*[contains(text(), '" + deletedChannelName + "')]")
        ));
        // Kanal gerçekten görünmüyorsa, 'true' döner
        return isChannelInvisible;
    }

    public boolean isVideoChannelCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(videoChannelIcon));
        return find(videoChannelIcon).isDisplayed();
    }

    public String clickedChannelOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeToChat));
        String channelText = find(welcomeToChat).getText();
        System.out.println(channelText);
        return channelText;
    }

    public void clickCreateChannelButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createChannelButton));
        click(createChannelButton);
    }

    public void setCreateChannelName(String channelName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createChannelName));
        WebElement channelNameField = driver.findElement(createChannelName);
        channelNameField.sendKeys(channelName);
    }

    public void clickCreateChannelTypeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createChannelTypeButton));
        click(createChannelTypeButton);
    }

    public void selectChannelTypeButton(String pickType) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createChannelTypeSelect));
        scrollToElementJS(createChannelTypeSelect);
        WebElement selectElement = find(createChannelTypeSelect);

        // `JavaScript` ile `option` seçme ve `click` olayını doğrudan tetikleme
        String script = "let select = arguments[0];" +
                "for (let i = 0; i < select.options.length; i++) {" +
                "    if (select.options[i].text === '" + pickType + "') {" +
                "        select.selectedIndex = i;" +
                "        select.options[i].selected = true;" +
                "        select.dispatchEvent(new Event('change', { bubbles: true }));" +
                "        select.options[i].click();" +  // Seçimi tıklayarak doğrula
                "        setTimeout(() => select.blur(), 0);" + // `blur` olayını küçük bir gecikme ile çağır
                "        break;" +
                "    }" +
                "}";
        ((JavascriptExecutor) driver).executeScript(script, selectElement);

        // Seçim yapıldıktan sonra, görünmez bir öğeye tıklayarak menüyü kapat
        WebElement hiddenElement = driver.findElement(By.cssSelector("body")); // Veya sayfanızda uygun başka bir öğe
        hiddenElement.click();
    }

    public void clickCreateButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
        click(createButton);
    }

    public void clickSelectedChannel(String channelName) {
        By selectedChannel = getChannelName(channelName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedChannel));
        click(selectedChannel);
    }

    public void clickEditChannelButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editChannelButton));
        click(editChannelButton);
    }

    public void clickDeleteChannelIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteChannelIcon));
        click(deleteChannelIcon);
    }

    public void clickDeleteChannelButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteChannelButton));
        click(deleteChannelButton);
    }

}
