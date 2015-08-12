/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpablo.test;


import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author JP
 */
public class TestWikipediaFF {
    private static WebElement link;
    private static WebElement searchBox;
    private static WebElement partialLinkText;
    private static WebElement linkText;
    private static WebDriver driver;
    
    private static String baseURL;
    
    private boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
        baseURL = "http://www.wikipedia.org";

        try{
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);            
        }
        catch(Exception e){
            throw new IllegalStateException("Can't start a web driver",e);
        }
    }
    
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
    
    @Test
    public void openWikiEnglishFirefox() throws InterruptedException{
        /*
        1. Launch Firefox
        2. Open Wikipedia main page
        3. Open Wikipedia in English
        4. Close Firefox
        */
        driver.get(baseURL);
        link = driver.findElement(By.linkText("English"));
        link.click();
        assertTrue(isElementPresent(By.linkText("English")));
    }
    
    
    public static void main(String[] args){
        TestWikipediaFF.main(args);
    }
}
