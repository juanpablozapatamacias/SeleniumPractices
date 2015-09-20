package com.jpablo.selenium.NewProjectSeleniumMaven;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class WordsFile{

  private WebDriver driver;
  private WebElement searchBox;
  private WebElement link;
  private String title;
  private WebDriverWait wait;
  
  private NavigateUtilities nu = new NavigateUtilities();
  
    
  @Test
  public void getWordsFromTXT(){
	  wait = new WebDriverWait(driver,40);
	  System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	  try{
		  Map<String,String> map = new HashMap<String,String>();
		  List<String> list = new ArrayList<String>();
		  int i = 0;
		  
		  driver.navigate().to("http://www.wikipedia.org");
	      link = driver.findElement(By.linkText("English"));
	      link.click();
	      
	      list = nu.readLinesFile();
	      map = nu.mapWords(list);

		  Iterator<String> it = map.keySet().iterator();
	      
		  while(it.hasNext()){
			  String key = it.next();
			  System.out.println(map.get(key));
			  		  
		   	  searchBox = driver.findElement(By.id("searchInput"));
	          searchBox.sendKeys(map.get(key));
	          searchBox.submit();
	          
	          title = driver.getTitle().toString();
	    	  nu.takeScreenShot(driver,"GetWordsFromTXT_" + i);
	    	  Assert.assertTrue(title.contains(driver.getTitle()));
	          wait.until(ExpectedConditions.titleContains(driver.getTitle()));
	          i++;
		  }
	  }
	  catch (Exception e){
		  e.printStackTrace();
		  nu.takeScreenShot(driver, "ExceptionGetWordsTXTScenario");
	  }
	  System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.wikipedia.org");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
