package com.jpablo.selenium.NewProjectSeleniumMaven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NavigateWikipedia{

	  private WebDriver driver;
	  private WebElement searchBox;
	  private WebElement link;
	  private WebElement button;
	  private Select selec;
	  private String title;
	  private NavigateUtilities nu = new NavigateUtilities();
	  
	  @Test
	  public void openWikipediaEs() {
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		  try{

			  driver.navigate().to("http://www.wikipedia.org");
			  link = driver.findElement(By.linkText("Español"));
			  link.click();
			  
			  title = driver.getTitle().toString();
			  nu.takeScreenShot(driver,"OpenWikipediaES");
			  Assert.assertTrue(title.contains(driver.getTitle()));
			  wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  nu.takeScreenShot(driver, "Exception_OpenWikipediaES");
		  }
		  System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	  }
	
	  @Test
	  public void openWikipediaEn() {
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());		  
		  try{
			  driver.navigate().to("http://www.wikipedia.org");
			  link = driver.findElement(By.linkText("English"));
			  link.click();
			  
			  title = driver.getTitle().toString();
			  nu.takeScreenShot(driver,"OpenWikipediaEN");
			  Assert.assertTrue(title.contains(driver.getTitle()));
			  wait.until(ExpectedConditions.titleContains(driver.getTitle()));  
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  nu.takeScreenShot(driver, "Exception_OpenWikipediaEN");
		  }
		  System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	  }
	     
	  @Test
	  public void clickWikiMainImage(){
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		  try{
			  driver.navigate().to("http://www.wikipedia.org");
			  link = driver.findElement(By.linkText("English"));
			  link.click();
			  	  
			  link = driver.findElement(By.xpath("//div[@id='p-logo']"));
			  link.click();
			  
			  title = driver.getTitle().toString();
			  nu.takeScreenShot(driver,"ClickWikiMainImage");
			  Assert.assertTrue(title.contains(driver.getTitle()));
			  wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  nu.takeScreenShot(driver, "Exception_ClickWikiMainImage");
		  }
		  System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	  }
	  
	  @Test
	  public void searchWikipediaEN(){
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		  try{
			  driver.navigate().to("http://www.wikipedia.org");
			  link = driver.findElement(By.linkText("English"));
			  link.click();
			  
			  searchBox = driver.findElement(By.id("searchInput"));
			  searchBox.sendKeys("Apple, Inc.");
			  searchBox.submit();
			  
			  title = driver.getTitle().toString();
			  nu.takeScreenShot(driver,"SearchWikipediaEN");
			  Assert.assertTrue(title.contains(driver.getTitle()));
			  wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  nu.takeScreenShot(driver, "Exception_SearchWikipediaEN");
		  }
		  System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	  }
		  
	  @Test
	  public void doSearchAutoSuggest(){
		  WebDriverWait wait = new WebDriverWait(driver,30);		  
		  System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		  try{
			  String word = "The Godfather";
			  
			  driver.navigate().to("http://www.wikipedia.org");
		      link = driver.findElement(By.linkText("English"));
		      link.click();
			  
			  searchBox = driver.findElement(By.id("searchInput"));
			  searchBox.sendKeys(word);
			  
			  List<WebElement> elements = driver.findElements(
					  By.xpath("//div[@class='suggestions-result']"));
			  
			  System.out.println("Autosuggest size: " + elements.size() );
			  
			  for(WebElement ele : elements){
				  System.out.println("Autosuggest words: " + ele.getText());
				  System.out.println("Band " + ele.getText().equals(word));
				  if(ele.getText().equals(word)){
					  ele.click();
					  title = driver.getTitle().toString();
					  nu.takeScreenShot(driver,"DoSearchAutoSuggest");
					  Assert.assertTrue(title.contains(driver.getTitle()));
					  wait.until(ExpectedConditions.titleContains(driver.getTitle()));
					  break;
				  }
			  }
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  nu.takeScreenShot(driver, "Exception_DoSearchAutoSuggest");
		  }
		  System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	  }
		  
	  @Test
	  public void doSearchAutoSuggestIndex(){
		  WebDriverWait wait = new WebDriverWait(driver,20);		  
		  System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		  try{
			  String word = "Apple";
			  
			  driver.navigate().to("http://www.wikipedia.org");
		      link = driver.findElement(By.linkText("English"));
		      link.click();
			  
			  searchBox = driver.findElement(By.id("searchInput"));
			  searchBox.sendKeys(word);
			  
			  List<WebElement> elements = driver.findElements(
					  By.xpath("//div[@class='suggestions-result']"));
			  
			  System.out.println("Autosuggest size: " + elements.size() );
			  
			  for(WebElement ele : elements){
				  System.out.println("Autosuggest words: " + ele.getText());	  
			  }
			  
			  int ind = (int)((Math.random()*elements.size()) + 1);
			  System.out.println("Index " + ind);
			  
			  elements.get(ind).click();
			  nu.takeScreenShot(driver,"DoSearchAutoSuggestIndex");
			  wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  nu.takeScreenShot(driver, "Exception_DoSearchAutoSuggestIndex");
		  }
		  System.out.println("Ending Test " + new Object(){}.getClass().getEnclosingMethod().getName());
	  }
	  
	  @Test
	  public void searchMainWikiPage(){
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  System.out.println("Starting Test " + new Object(){}.getClass().getEnclosingMethod().getName());
		  try{
			  driver.navigate().to("http://www.wikipedia.org");
			  searchBox = driver.findElement(By.id("searchInput"));
			  searchBox.sendKeys("Avengers");
			  
			  selec = new Select(driver.findElement(By.id("searchLanguage")));
			  selec.selectByValue("es");
			  
			  button = driver.findElement(By.className("formBtn"));
			  button.submit();
			  
			  title = driver.getTitle().toString();
			  nu.takeScreenShot(driver,"SearchMainWikiPage");
			  Assert.assertTrue(title.contains(driver.getTitle()));
			  wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  nu.takeScreenShot(driver, "Exception_SearchMainWikiPage");
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
