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

public class CorreoDemo {
	Thread t = new Thread();
	
	private WebDriver driver;
	private WebElement txtLogin;
	private WebElement txtPwd;
	private WebElement button1;
	private WebElement button2;
	private WebElement linkCreateLabel;
	private WebElement tree;
	
	private String title;
	
	private NavigateUtilities nu = new NavigateUtilities();
	
	@Test
	public void autheticate(){
		WebDriverWait wait = new WebDriverWait(driver,120);
		System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		try{
			/*Authenticate with gmail user*/
			txtLogin = driver.findElement(By.id("Email"));
			txtLogin.sendKeys("test.fmi.gdl@gmail.com");
			
			button1 = driver.findElement(By.id("next"));
			button1.click();
			
			txtPwd = driver.findElement(By.id("Passwd"));
			txtPwd.sendKeys("tester10");
			
			if(driver.findElement(By.id("PersistentCookie")).isSelected())
				driver.findElement(By.id("PersistentCookie")).click();
			
			button2 = driver.findElement(By.id("signIn"));
			button2.submit();
			
			try{
				t.currentThread().sleep(10000);
			}
			catch(Exception e){}
			
			/*Create Label*/
			tree = driver.findElement(By.xpath("id(':iy')/x:span[1]"));
			tree.click();
			
			
			linkCreateLabel = driver.findElement(By.className("CL Wj NQ"));
			linkCreateLabel.click();
			
			title = driver.getTitle().toString();
			Assert.assertTrue(title.contains(driver.getTitle()));
			wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		}
		catch(Exception e){
			e.printStackTrace();
			nu.takeScreenShot(driver, "CorreoDemoException");
		}
	}
	
	@BeforeTest
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.get("https://accounts.google.com/"
				+ "ServiceLogin?service=mail&passive=true&rm=false"
				+ "&continue=https://mail.google.com/mail/&ss=1&scc=1"
				+ "&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}
}
