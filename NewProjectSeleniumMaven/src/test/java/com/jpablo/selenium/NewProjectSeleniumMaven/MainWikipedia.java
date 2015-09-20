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

public class MainWikipedia {
	private WebDriver driver;
	private WebElement link;
	private String title;
	private NavigateUtilities nu = new NavigateUtilities();
	
	@Test
	public void openMainWikiEN(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		try{
			driver.navigate().to("http://www.wikipedia.org");
			link = driver.findElement(By.xpath("//div/a[strong='English']"));
			link.click();
			
			title = driver.getTitle().toString();
			nu.takeScreenShot(driver,"OpenMainWikiEN");
			Assert.assertTrue(title.contains(driver.getTitle()));
			wait.until(ExpectedConditions.titleContains(driver.getTitle()));			
		}
		catch(Exception e){
			e.printStackTrace();
			nu.takeScreenShot(driver, "Exception_OpenMainWikiEN");
		}	
		System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void openMainWikiES(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		try{
			driver.navigate().to("http://www.wikipedia.org");
			link = driver.findElement(By.xpath("//div/a[strong='Español']"));
			link.click();
			
			title = driver.getTitle().toString();
			nu.takeScreenShot(driver,"OpenMainWikiES");
			Assert.assertTrue(title.contains(driver.getTitle()));
			wait.until(ExpectedConditions.titleContains(driver.getTitle()));			
		}
		catch(Exception e){
			e.printStackTrace();
			nu.takeScreenShot(driver, "Exception_OpenMainWikiES");
		}	
		System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void openMainWikiDE(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		try{
			driver.navigate().to("http://www.wikipedia.org");
			link = driver.findElement(By.xpath("//div/a[strong='Deutsch']"));
			link.click();
			
			title = driver.getTitle().toString();
			nu.takeScreenShot(driver,"OpenMainWikiDE");
			Assert.assertTrue(title.contains(driver.getTitle()));
			wait.until(ExpectedConditions.titleContains(driver.getTitle()));			
		}
		catch(Exception e){
			e.printStackTrace();
			nu.takeScreenShot(driver, "Exception_OpenMainWikiDE");
		}	
		System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@BeforeTest
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}
}
