package com.madcord.tests.servers;

import com.madcord.pages.ServersPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import com.madcord.base.BaseTest;

public class ServerTests extends BaseTest  {
    @Test
    public void testServersHeaderIsDisplayed() {
        ServersPage serversPage = new ServersPage();
        assertTrue(serversPage.isServersHeaderDisplayed(),
                "\n Servers Header is not displayed \n");
    }

    @Test
    public void testServersImageIsDisplayed() {
        ServersPage serversPage = new ServersPage();
        assertTrue(serversPage.isServersImgDisplayed(),
                "\n Servers Image is not displayed \n");
    }

    @Test
    public void testServersInvitePeople() {
        ServersPage serversPage = new ServersPage();
        serversPage.clickMenuButton();
        serversPage.clickInvitePeopleButton();
        serversPage.clickGenerateNewLinkButton();
        serversPage.alertPass();
        serversPage.copyLinkButton();
        assertTrue(serversPage.isCopied(),
                "\n Link is not copied \n");
    }

    @Test
    public void testServersChangeServerName() {
        ServersPage serversPage = new ServersPage();
        String oldServerName = serversPage.getServerName();
        System.out.println("Old server name: " + oldServerName);
        serversPage.clickMenuButton();
        serversPage.clickServerSettingsButton();
        String newName = "changed-server-name";
        serversPage.changeServerName(newName);
        serversPage.clickSaveButton();
        serversPage.setWaitForServerNameChange(newName);
        String newServerName = serversPage.getServerName();
        System.out.println("New server name: " + newServerName);
        assertNotEquals(oldServerName, newServerName,
                "\n Server name is not changed \n");
    }
}
