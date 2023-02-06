package com.theherokoapp.internet.loginpagetests;

import com.theherokoapp.internet.base.TestUtilities;
import com.theherokoapp.internet.pages.LoginPage;
import com.theherokoapp.internet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTest extends TestUtilities {

    @Parameters({"username","password","expectedErrorMessage"})
    @Test
    public void negativeLoginTest(String username, String password, String expectedErrorMessage){
        log.info("started the test");
        WelcomePage welcomePage=new WelcomePage(driver,log);
        welcomePage.openPage();
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        loginPage.login(username,password);
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();
        Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");

    }
}
