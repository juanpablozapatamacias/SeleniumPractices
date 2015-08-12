/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpablo.test.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
/**
 *
 * @author JP
 */
public class MyTest {
    
    private static WebDriver driver;
    private static WebElement link;
    private static WebElement searchBox;
    
    public MyTest() {
    }
    
    @BeforeClass
    public static void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        System.out.print("Window maximise");
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
        System.out.print("End of Test");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test() {
        driver.get("http://es.wikipedia.org");
        System.out.print("Site Open");
    }
    
    @Test
    public void doSearchWikiENFF(){
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Apple");
        searchBox.submit();
    }
    
    /*@Test
    public void doTwoSearchsWikiFF(){
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Soccer");
        searchBox.submit();
        
        link = driver.findElement(By.linkText("Español"));
        link.click();
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Alejandro Fernandez");
        searchBox.submit();
    }*/
}
