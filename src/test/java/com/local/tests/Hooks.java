package com.local.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class Hooks definition.
 */
public class Hooks {

    private static WebDriver driver;
    private static final int DELAY = 30;
    /**
     * Launch ChromeDriver.
     */
    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
    }
    /**
     * Close browser windows and terminate WebDriver session.
     */
    @After
    public void afterMethod() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
