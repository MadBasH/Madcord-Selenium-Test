package com.madcord.tests.servers;

import com.madcord.pages.ServersPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import com.madcord.base.BaseTest;

public class ServersTest extends BaseTest  {

    @Test
    public void testServersHeaderIsDisplayed() {
        ServersPage serversPage = loginPage.
                logIntoApplication("bayrakdar32@hotmail.com", "Testke123.");
        assertTrue(serversPage.isServersHeaderDisplayed(),
                "\n Servers Header is not displayed \n");
    }
}
