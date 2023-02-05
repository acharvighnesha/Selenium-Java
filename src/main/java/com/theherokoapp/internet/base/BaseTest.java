package com.theherokoapp.internet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class BaseTest {
    protected WebDriver driver;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        // Create driver
        System.out.println("Create driver: " + browser);
        BrowserDriverFactory driverFactory=new BrowserDriverFactory(browser);
        driver=driverFactory.createDriver();

        // This sleep here is for demo only,In Actual it can be avoided
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Close driver");
        // Close browser
        driver.quit();
    }
}
