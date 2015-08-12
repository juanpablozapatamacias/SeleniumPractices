/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpablo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 *
 * @author JP
 */

public class TutorialSelenium {
    
    public static WebElement link;
    public static WebElement searchBox;
    public static WebElement partialLinkText;
    public static WebElement linkText;
    public static WebDriver driver;
    
    public void testFirefox() throws InterruptedException{
        driver = new FirefoxDriver();
        
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(10000);
        
        /*partialLinkText = driver.findElement
            (By.partialLinkText("the Bank"));
        partialLinkText.click();
        */
        
        //Thread.sleep(10000);
        
        link = driver.findElement(By.linkText("Español"));
        link.click();
        
        Thread.sleep(30000);
        
        linkText = driver.findElement(By.linkText("Software"));
        linkText.click();
        
        Thread.sleep(10000);
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Software");
        searchBox.submit();
        
        Thread.sleep(5000);
        driver.quit();
    }
    
    public void testIE() throws InterruptedException{
        System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
        
        /*DesiredCapabilities caps = DesiredCapabilities.internetExplorer(); 
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true);
        
        driver = new InternetExplorerDriver(caps);
        */
        driver = new InternetExplorerDriver();
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(5000);
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Software");
        searchBox.submit();
        
        Thread.sleep(5000);
        driver.quit();
    }
    
    public static void main(String[] args) throws InterruptedException{
        TutorialSelenium ts = new TutorialSelenium();
        ts.testFirefox();
        //ts.testIE();
    }
}
