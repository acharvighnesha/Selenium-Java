package com.theherokoapp.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class BasePageObject {
    protected WebDriver driver;
    protected Logger log;

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds){
        timeoutInSeconds=timeoutInSeconds!=null?timeoutInSeconds:30;
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator,Integer...timeoutInSeconds){
        int attempts=0;
        while (attempts<2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),timeoutInSeconds!=null?timeoutInSeconds[0]:null);
                break;
            }catch (StaleElementReferenceException e){
                log.info("element is not visible, locator:",locator);
            }
        }
    }

}
