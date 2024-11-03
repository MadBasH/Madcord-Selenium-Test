package com.madcord.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ActionsUtility;

import java.time.Duration;

public class ChatsPage extends  BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle
    ActionsUtility actionsUtility = new ActionsUtility();

    private By getChatName(String chatName) {
        return By.xpath("//p[contains(text(),'" + chatName + "')]");
    }

    private By chatMessages = By.xpath("//div[@class='flex-1 flex flex-col py-4 overflow-y-auto']");
    private By chatMessageInputField = By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/main[1]/div[1]/form[1]/div[1]/div[1]/input[1]");
    private By chatEditIcon = By.cssSelector("div:nth-child(2) > svg:nth-child(1)");
    private By chatEditInput = By.xpath("//input[@name='content' and @placeholder='Edited message']");
    private By chatDeleteIcon = By.cssSelector("div:nth-child(2) > svg:nth-child(2)");
    private By deleteButton = By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/button[2]");

    public boolean isMessageSended(String sendedMessageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(chatMessages));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(chatMessages, sendedMessageName));
        String messageText = find(chatMessages).getText();
        return messageText.contains(sendedMessageName);
    }

    public boolean isMessageDeleted(String sendedMessageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(chatMessages));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(chatMessages, sendedMessageName));

        // Mesajın görünmez olmasını bekle
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='" + sendedMessageName + "']")));

        String messageText = find(chatMessages).getText();
        return messageText.contains(sendedMessageName);
    }

    public void clickSelectedChat(String chatName) {
        By selectedChat = getChatName(chatName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedChat));
        click(selectedChat);
    }


    public void setSendChatMessage(String messageText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(chatMessageInputField));
        WebElement channelNameField = driver.findElement(chatMessageInputField);
        channelNameField.sendKeys(messageText + Keys.ENTER);
    }

    public void clickSelectedChatMessage(String chatMessage) {
        By selectedChatMessage = getChatName(chatMessage);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedChatMessage));
        WebElement messageElement = driver.findElement(selectedChatMessage);
        // Mesajın üzerine gelme işlemi
        actionsUtility.hoverOverElement(messageElement);
    }


    public void clickMessageEdit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(chatEditIcon));
        click(chatEditIcon);
    }

    public void setChatEditMessage(String editText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(chatEditInput));
        WebElement chatEditField = driver.findElement(chatEditInput);
        chatEditField.clear();
        chatEditField.sendKeys(editText + Keys.ENTER);
    }

    public void clickMessageDelete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(chatDeleteIcon));
        click(chatDeleteIcon);
    }

    public void clickDeteleButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        click(deleteButton);
    }
}
