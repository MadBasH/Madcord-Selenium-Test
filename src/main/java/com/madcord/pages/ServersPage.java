package com.madcord.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ServersPage extends BasePage {

    private By serversHeader = By.xpath("//*[@class='lucide lucide-hash w-5 h-5 text-zinc-500 dark:text-zinc-400 mr-2']");

    public boolean isServersHeaderDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(serversHeader)); // Hata mesajının görünmesini bekle
        return find(serversHeader).isDisplayed();
    }
}
