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
import java.util.List;

public class BasePageObject {
    protected WebDriver driver;
    protected Logger log;
    public BasePageObject(WebDriver driver,Logger log){
        this.driver=driver;
        this.log=log;
    }
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
    /**
     * open with page with input url
     * @param url
     */
    protected void openUrl(String url){
        driver.get(url);
    }

    /**
     * find the element for given locator
     * @param locator
     * @return
     */
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    /**
     * Find all elements using given locator
     * @param locator
     * @return
     */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /**
     * click on element identified by locator
     * @param locator
     */
    protected void click(By locator){
        waitForVisibilityOf(locator,5);
        find(locator).click();
    }

    /**
     * enter the input text on element identified by locator
     * @param text
     * @param locator
     */
    protected void type(String text,By locator){
        waitForVisibilityOf(locator,5);
        find(locator).sendKeys(text);
    }

}
