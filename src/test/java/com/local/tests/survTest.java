package com.local.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.LoggerFactory;

public class survTest {
    org.slf4j.Logger log = LoggerFactory.getLogger(survTest.class);
    private String filePath = System.getProperty("filePath");
    private String username = System.getProperty("username");
    private String password = System.getProperty("password");
    private String baseUrl;
    
    public survTest() {
    String tempDirectory = System.getProperty("user.dir") + File.separator + "chromedriver_win32";
    filePath = tempDirectory;   
    }
     
   @Test
   public void HeadlessChromeDriverTest() throws IOException, InterruptedException {
    
   System.setProperty("webdriver.chrome.driver", (filePath + File.separator + "chromedriver.exe"));
   ChromeOptions chromeOptions = new ChromeOptions();
   //chromeOptions.addArguments("--headless");
   WebDriver driver = new ChromeDriver(chromeOptions);
   
   baseUrl = "https://chpl.ahrqstg.org/";
   driver.get("https://chpl.ahrqstg.org/#/admin/dpManagement");
   
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   //driver.wait().until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Edit Certified Product"));
   driver.findElement(By.name("username")).sendKeys(username);

   driver.findElement(By.name("password")).sendKeys(password);

   driver.findElement(By.cssSelector("[id^='login_']")).click();  
   
   //Thread.sleep(5000);   
   
   driver.findElement(By.linkText("Manage Surveillance Activity")).click();
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

   driver.findElement(By.id("surveillance-search")).sendKeys("15.04.04.2484.Updo.16.00.0.170720");
   driver.findElement(By.id("surveillance-search-button")).click();
  
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

   String actualString = driver.findElement(By.xpath("//*[@id=\"surveillance-search-single-result\"]/tbody/tr[1]/td")).getText();
   
   System.out.println(actualString);
   
   driver.quit();
}
}