package com.theherokoapp.internet.alerttests;

import com.theherokoapp.internet.base.TestUtilities;
import com.theherokoapp.internet.pages.JavaScriptAlertsPage;
import com.theherokoapp.internet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends TestUtilities {
    @Test
    public void jsAlertTest(){
        WelcomePage welcomePage=new WelcomePage(driver,log);
        welcomePage.openPage();

        //Click on js alert link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
        alertsPage.openJSAlert();
        sleep(1000); //this can be removed as we want to see alert

        //Get the alert text
        String alertMessage = alertsPage.getAlertText();

        // Click OK button
        alertsPage.acceptAlert();

        // Get Results text
        String result = alertsPage.getResultText();
        sleep(1000);

        //Verification
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        Assert.assertTrue(result.equals("You successfully clicked an alert"),
                "result is not expected. \nShould be 'You successfuly clicked an alert', but it is '" + result + "'");
    }

    @Test
    public void jsDismissTest() {
        log.info("Starting jsDismissTest");

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Confirm button
        alertsPage.openJSConfirm();
        sleep(1000);
        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Click Cancel button
        alertsPage.dismissAlert();

        // Get Results text
        String result = alertsPage.getResultText();
        sleep(1000);
        // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        Assert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
    }

    @Test
    public void jsPromptTest() {
        log.info("Starting jsDismissTest");

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Prompt button
        alertsPage.openJSPrompt();
        sleep(1000);
        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Type text into alert
        alertsPage.typeTextIntoAlert("Hello Alert, it's Dmitry here");
        sleep(1000);
        // Get Results text
        String result = alertsPage.getResultText();
        sleep(1000);
        // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        Assert.assertTrue(result.equals("You entered: Hello Alert, it's Dmitry here"),
                "result is not expected. \nShould be 'You entered: Hello Alert, its Dmitry here', but it is '" + result
                        + "'");
    }
}
