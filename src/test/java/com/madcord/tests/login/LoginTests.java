package com.madcord.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.madcord.base.BaseTest;

public class LoginTests extends BaseTest {

    @Test
    public void testPassedLogin() {
        // Kullanıcı adını ve şifreyi Credentials sınıfından alıyoruz
        loginPage.setUsername(username); // username, BaseTest'ten alındı
        loginPage.clickLoginButton();
        loginPage.waitForUrlToChange("https://madcord-final-production.up.railway.app/sign-in/factor-one?redirect_url=https%3A%2F%2Fmadcord-final-production.up.railway.app%2F");
        loginPage.setPassword(password); // password, BaseTest'ten alındı
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.waitForUrlToChange("https://madcord-final-production.up.railway.app/"));
    }

    @Test
    public void testFailedLoginUsername() {
        loginPage.setUsername("unregistered@hotmail.com");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessageUsername();
        Assert.assertTrue(actualMessage.contains("Couldn't find"));
    }

    @Test
    public void testFailedLoginPassword() {
        loginPage.setUsername(username); // username, BaseTest'ten alındı
        loginPage.clickLoginButton();
        loginPage.waitForUrlToChange("https://madcord-final-production.up.railway.app/sign-in/factor-one?redirect_url=https%3A%2F%2Fmadcord-final-production.up.railway.app%2F");
        loginPage.setPassword("incorrect");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessagePassword();
        Assert.assertTrue(actualMessage.contains("Password is incorrect"));
    }
}
