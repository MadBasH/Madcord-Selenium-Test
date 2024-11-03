package com.madcord.tests.chats;

import com.madcord.base.BaseTest;
import com.madcord.pages.ChatsPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class ChatTests extends BaseTest {

    @Test
    public void testChatsSendMessage() {
        ChatsPage chatsPage = new ChatsPage();
        String chatName = "test-server";
        chatsPage.clickSelectedChat(chatName);
        String chatMessage = "This is a test message new";
        chatsPage.setSendChatMessage(chatMessage);
        assertTrue(chatsPage.isMessageSended(chatMessage),
                "Message Send is not successful");
    }

    @Test
    public void testChatsEditMessage() {
        ChatsPage chatsPage = new ChatsPage();
        String chatName = "test-server";
        chatsPage.clickSelectedChat(chatName);
        String chatMessage = "This is a test message..";
        chatsPage.clickSelectedChatMessage(chatMessage);
        chatsPage.clickMessageEdit();
        String editMessage = "This is an edited message.";
        chatsPage.setChatEditMessage(editMessage);
        assertTrue(chatsPage.isMessageSended(editMessage),
                "Message Edit is not successful");
    }

    @Test
    public void testChatsDeleteMessage() {
        ChatsPage chatsPage = new ChatsPage();
        String chatName = "test-server";
        chatsPage.clickSelectedChat(chatName);
        String chatMessage = "aaaaa";
        chatsPage.clickSelectedChatMessage(chatMessage);
        chatsPage.clickMessageDelete();
        chatsPage.clickDeteleButton();
        assertFalse(chatsPage.isMessageDeleted(chatMessage),
                "Message Delete is not successful");
    }

}
