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

    @Test
    public void testServersManageMembers() {
        ServersPage serversPage = new ServersPage();
        serversPage.clickMenuButton();
        serversPage.clickManageMembersButton();
        assertTrue(serversPage.isManageMembersOpened(),
                "\n Manage Members page is not displayed \n");
    }

    @Test
    public void testServersCreateChannels() {
        ServersPage serversPage = new ServersPage();
        serversPage.clickMenuButton();
        serversPage.clickCreateChannelButton();
        assertTrue(serversPage.isCreateChannelsOpened(),
                "\n Create Channel page is not displayed \n");
    }

    @Test
    public void testServersDeleteServer() {
        ServersPage serversPage = new ServersPage();
        serversPage.clickMenuButton();
        serversPage.clickDeleteServerButton();
        assertTrue(serversPage.isDeleteServerOpened(),
                "\n Delete Server page is not displayed \n");
    }

    @Test
    public void testServersToggleMode() {
        ServersPage serversPage = new ServersPage();
        serversPage.clickToggleMode();
        serversPage.lightMode();
        assertTrue(serversPage.isLightModeApplied(),
                "\n Light Mode is not applied \n");
        serversPage.clickToggleMode();
        serversPage.darkMode();
        assertTrue(serversPage.isDarkModeApplied(),
                "\n Dark Mode is not applied \n");
    }
    
    @Test
    public void testServersSignOut() {
        ServersPage serversPage = new ServersPage();
        serversPage.clickUserSettingsButton();
        serversPage.clickSignOutButton();
        assertTrue(serversPage.isSignOutSuccessful(),
                "\n Sign Out is not successful \n");
    }

    @Test
    public void testServersSearchBarShortcut() {
        ServersPage serversPage = new ServersPage();
        serversPage.searchBarShortCut();
        assertTrue(serversPage.isSearchBarOpened(),
                "\n Search Bar Shortcut is not working \n");
    }

    @Test
    public void testServersSearchBar() {
        ServersPage serversPage = new ServersPage();
        serversPage.clickSearchButton();
        String searchParameter = "test-server";
        serversPage.setSearchBar(searchParameter);
        assertTrue(serversPage.isSearchSucessful(searchParameter),
                "\n Searching is not successful \n");
    }
}
