package com.theherokoapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject{
    private String pageUrl= "http://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void opeanPage(){
        log.info("opening page:"+pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    /**
     * clicks on authentication link and returns login page
     * @return
     */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

}
