package com.jpablo.selenium.TutorialSeleniumMavenTestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class NavigateGoogleFirefox {

	private WebDriver driver;
	private WebElement link;
	private WebElement searchBox;
	private WebDriverWait wait;
	
	//BeforeClass interface to launch FBrowser
	@BeforeClass
	public void openFirefoxBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//wait = new WebDriverWait(driver,5);
	}
	
	//Test interface to code out test cases
	@Test
	public void openGoogle(){
		System.out.println("Starting test " + 
				new Object(){}.getClass().getEnclosingMethod().getName().toString());
		driver.get("http://www.google.com");
		System.out.println("Ending test " + 
				new Object(){}.getClass().getEnclosingMethod().getName().toString());
	} 
	
	@Test
	public void openImagesLink(){
		System.out.println("Starting test " + 
				new Object(){}.getClass().getEnclosingMethod().getName().toString());
		driver.get("http://www.google.com");
		
		link = driver.findElement(By.linkText("Imágenes"));
		link.click();
		
		System.out.println("Ending test " + 
				new Object(){}.getClass().getEnclosingMethod().getName().toString());
	}
	
	@Test
	public void doSearch(){
		System.out.println("Starting test " + 
				new Object(){}.getClass().getEnclosingMethod().getName().toString());
		
		String searchKey = "TestNG";
		
		System.out.println("Search " + searchKey + " in google");
		driver.get("http://www.google.com");
		searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(searchKey);
		searchBox.submit();
		
		System.out.println("Ending test " + 
				new Object(){}.getClass().getEnclosingMethod().getName().toString());
	}
	
	@Test
	public void selectAutoSuggestions(){
		System.out.println("Starting test " + 
				new Object(){}.getClass().getEnclosingMethod().getName().toString());
		
		String searchKey = "TestNG";
		driver.get("http://www.google.com");
		searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(searchKey);
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='sbqs_c']"));
		
		System.out.println("Word to search: " + searchKey);
		System.out.println("Number of elements: " + options.size());
		
		for (WebElement ele : options){
			System.out.println("Values are: " + ele.getText());
			System.out.println(ele.getText().equals(searchKey.toLowerCase()));
			if (ele.getText().equals(searchKey.toLowerCase())){
				System.out.println("Selecting: " + searchKey);
				ele.click();
				break;
			}
		}
		
		System.out.println("Ending test " + 
				new Object(){}.getClass().getEnclosingMethod().getName().toString());
	}
	
	//AfterClass to do generally to close the driver execution
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
}
