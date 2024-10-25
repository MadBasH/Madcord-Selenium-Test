package com.madcord.tests.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.madcord.base.BaseTest;

public class LoginTests extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);

    @Test
    public void testPassedLogin() {
        loginPage.setUsername("bayrakdar32@hotmail.com");
        loginPage.clickLoginButton();
        loginPage.waitForUrlToChange("https://madcord-final-production.up.railway.app/sign-in/factor-one?redirect_url=https%3A%2F%2Fmadcord-final-production.up.railway.app%2F");
        loginPage.setPassword("Testke123.");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.waitForUrlToChange("https://madcord-final-production.up.railway.app/"));
    }

    @Test
    public void testFailedLoginUsername() {
        loginPage.setUsername("unregistered@hotmail.com");
//      loginPage.setPassword("Testke123.");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessageUsername();
        Assert.assertTrue(actualMessage.contains("Couldn't find"));
    }

    @Test
    public void testFailedLoginPassword() {
        loginPage.setUsername("bayrakdar32@hotmail.com");
        loginPage.clickLoginButton();
        loginPage.waitForUrlToChange("https://madcord-final-production.up.railway.app/sign-in/factor-one?redirect_url=https%3A%2F%2Fmadcord-final-production.up.railway.app%2F");
        loginPage.setPassword("incorrect");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessagePassword();
        Assert.assertTrue(actualMessage.contains("Password is incorrect"));
    }
}
