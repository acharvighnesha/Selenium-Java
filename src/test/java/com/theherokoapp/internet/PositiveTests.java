package com.theherokoapp.internet;

import com.theherokoapp.internet.base.TestUtilities;
import com.theherokoapp.internet.pages.LoginPage;
import com.theherokoapp.internet.pages.SecureAreaPage;
import com.theherokoapp.internet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests extends TestUtilities {
    @Test
    public void logInTest() {
        System.out.println("Starting logIn test");
        WelcomePage welcomePage=new WelcomePage(driver,log);
        welcomePage.opeanPage();
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");
        String expectedSuccessMessage = "You logged into a secure area!";
        // write the assertion
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible());
        Assert.assertTrue(secureAreaPage.getSuccessMessageText().contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + secureAreaPage.getSuccessMessageText());

        /* commented the basic implementation

        // open main page
        String url = "http://the-internet.herokuapp.com/";
        driver.get(url);
        System.out.println("Main page is opened.");

        // Click on Form Authentication link
        driver.findElement(By.linkText("Form Authentication")).click();

        // enter username and password
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // push log in button
        WebElement logInButton = driver.findElement(By.className("radius"));
        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();

        // verifications
        // new url
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        // log out button is visible
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),
                "logOutButton is not visible.");

        // Successful log in message

        String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);*/

    }
}
