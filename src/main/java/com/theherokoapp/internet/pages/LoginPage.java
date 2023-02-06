package com.theherokoapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {
    private By usernNameLocator=By.id("username");
    private By passwordLocator=By.id("password");
    private By logInButtonLocator = By.tagName("button");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * login to using given username and password
     * @param userName
     * @param password
     * @return
     */
    public SecureAreaPage login(String userName, String password){
        log.info("Executing LogIn with username [" + userName + "] and password [" + password + "]");
        type(userName,usernNameLocator);
        type(password,passwordLocator);
        click(logInButtonLocator);
        return new SecureAreaPage(driver,log);
    }

}
