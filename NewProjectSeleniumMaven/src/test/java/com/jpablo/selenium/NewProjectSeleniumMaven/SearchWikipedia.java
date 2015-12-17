package com.jpablo.selenium.NewProjectSeleniumMaven;

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

public class SearchWikipedia {
	  private WebDriver driver;
	  private WebElement searchBox;
	  private WebElement link;
	  private String title;
	  private NavigateUtilities nu = new NavigateUtilities();
	  
	  @Test
	  public void searchWikipediaES(){
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		  try{
			  driver.navigate().to("http://www.wikipedia.org");
			  link = driver.findElement(By.linkText("Español"));
			  link.click();
			  
			  searchBox = driver.findElement(By.id("searchInput"));
			  searchBox.sendKeys("Robert Downey Jr.");
			  searchBox.submit();
			  
			  title = driver.getTitle().toString();
			  nu.takeScreenShot(driver,"SearchWikipediaES");
			  Assert.assertTrue(title.contains(driver.getTitle()));
			  wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  nu.takeScreenShot(driver, "Exception_SearchWikipediaES");
		  }
		  System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	
	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }
}
