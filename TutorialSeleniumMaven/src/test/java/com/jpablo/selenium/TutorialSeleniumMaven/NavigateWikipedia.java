package com.jpablo.selenium.TutorialSeleniumMaven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.rules.ExternalResource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigateWikipedia{
	private static WebDriver driver;
    private WebElement link;
    private WebElement searchBox;
    private WebElement partialLinkText;
    private WebElement linkText;
    private WebElement formElement;
    private WebDriverWait wait;
    
 
    public NavigateWikipedia(){
    }
    
    
    
    @Rule
    public TestRule watcher = new TestWatcher(){
    	protected void starting (Description desc){
    		System.out.println("Starting test " + desc.getMethodName());
    	}
    };
    
    @BeforeClass
    public static void openBrowser(){
    	driver = new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @Test
    public void openWikiEnglishFirefox(){
    	System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
    	
    	driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }
    
    @Test
    public void doSearchAutoSuggestion(){
    	System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
    	
    	final String word = "Apple";
    	wait = new WebDriverWait (driver,30);
    	
    	driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(word);
        
        List<WebElement> autoSuggestions = driver.findElements(By.xpath("//div[@class='suggestions-result']"));
        System.out.println("Autosuggestions elements: " + autoSuggestions.size());
        System.out.println("Word to search: " + word);
        
        for(WebElement au : autoSuggestions){
        	System.out.println("Autosuggestions values are " + au.getText());
        	
        	if(au.getText().equals(word)){
        		System.out.println("Searching: " + word);
        		
        		//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//div[contains(text(),'" + word + "')]")));
        		au.click();
        		break;
        	}
        }
        
    	System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }
    
    @Test
    public void doSearchENWiki(){
    	System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
    	
    	driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Apple");
        searchBox.submit();
    	
    	System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }
    

    
    @AfterClass
    public static void closeBrowser(){
    	driver.quit();
    }
}
