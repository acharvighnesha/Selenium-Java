package com.theherokoapp.internet.checkboxtests.com.theherokoapp.internet.loginpagetests;

import com.theherokoapp.internet.base.TestUtilities;
import com.theherokoapp.internet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest() {
        log.info("Starting selectingTwoCheckboxesTest");

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        // Select All Checkboxes
        checkboxesPage.selectAllCheckboxes();

        // Verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");

    }
}
