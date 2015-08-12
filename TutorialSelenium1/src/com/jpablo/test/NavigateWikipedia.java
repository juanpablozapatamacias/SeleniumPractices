/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpablo.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author JP
 */
public class NavigateWikipedia {
    
    private WebElement link;
    private WebElement searchBox;
    private WebElement partialLinkText;
    private WebElement linkText;
    private WebDriver driver;
    private WebDriverWait wait;
    
    public NavigateWikipedia(){}
    
    public NavigateWikipedia(WebElement link, WebElement searchBox, 
            WebElement partialLinkText, WebElement linkText, WebDriver driver){
        this.link = link;
        this.searchBox = searchBox;
        this.partialLinkText = partialLinkText;
        this.linkText = linkText;
        this.driver = driver;
    }
    
    public void openWikiEnglishFirefox() throws InterruptedException{
        /*
        1. Launch Firefox
        2. Open Wikipedia main page
        3. Open Wikipedia in English
        4. Close Firefox
        */
        
        driver = new FirefoxDriver();
        
        
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(10000);
        
        driver.quit();            
    }   
    
    public void doSearchWikiENFF(String sendKeys) throws InterruptedException{
        /*
        1. Launch Firefox
        2. Open Wikipedia main page
        3. Open Wikipedia in English
        4. Type a word to search
        5. Click on Search button
        6. Close Firefox
        */
        
        driver = new FirefoxDriver();
        
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(10000);
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(sendKeys);
        searchBox.submit();
        
        Thread.sleep(5000);
        driver.quit();
    }
    
    public void doAnotherSearchFF(String sendKeys1, String sendKeys2) 
            throws InterruptedException{
        /*
        1. Launch Firefox explorer
        2. Open Wikipedia main page
        3. Open Wikipedia in English
        4. Type a word to search
        5. Click on Search button
        6. Open Wikipedia in Spanish
        7. Type another word to search
        8. Click on Search button
        9. Close Firefox
        */
        
        driver = new FirefoxDriver();
        
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(10000);
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(sendKeys1);
        searchBox.submit();
        
        Thread.sleep(5000);
        
        link = driver.findElement(By.linkText("Español"));
        link.click();
        
        Thread.sleep(10000);
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(sendKeys2);
        searchBox.submit();
        
        Thread.sleep(5000);
        driver.quit();
    }

    public void openWikiEnglishIE() throws InterruptedException{
         /*
        1. Launch IE
        2. Open Wikipedia main page
        3. Open Wikipedia in English
        4. Close IE
        */
        
        System.setProperty("webdriver.ie.driver", "C:\\SeleniumUtilities\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(5000);
        
        driver.quit();
    }
    
    public void openWikiEnglishChrome() throws InterruptedException{
         /*
        1. Launch Chrome
        2. Open Wikipedia main page
        3. Open Wikipedia in English
        4. Close Chrome
        */
        
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumUtilities\\chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(5000);
        
        driver.quit();
    }
    
    public void doSearchWikiENIE(String sendKeys) throws InterruptedException{
        /*
        1. Launch IE
        2. Open Wikipedia main page
        3. Open Wikipedia in English
        4. Type a word to search
        5. Click on Search button
        6. Close IE
        */
        
        System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(10000);
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(sendKeys);
        searchBox.submit();
        
        Thread.sleep(5000);
        driver.quit();
    }
    
    public void doSearchAutoSuggest(String sendKeys) throws InterruptedException{
        /*
        1. Launch Firefox explorer
        2. Open Wikipedia main page
        3. Open Wikipedia in English
        4. Type a word to search
        5. Compare the word to search vs the list elements
        */
        driver = new FirefoxDriver();
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(8000);
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(sendKeys);
        
        List<WebElement> optionsToSelect = driver.findElements(By.xpath
            ("//div[@class='suggestions-result']"));
        
        System.out.println("Word to search: " + sendKeys);
        System.out.println("Size of Autosuggest is: " + optionsToSelect.size());
        
        for (WebElement option : optionsToSelect){
            System.out.println("");
            System.out.println("Values are: \n" + option.getText());
            System.out.println("Band " + option.getText().equals(sendKeys));        
            
            if(option.getText().equals(sendKeys)){
                System.out.println("Selecting: " + sendKeys);
                option.click();
                break;
            }
        }
        Thread.sleep(5000);
        driver.quit();
    }
    
    public void doSearchAutoSuggestIndex(String sendKeys) throws InterruptedException{
        /*
        1. Launch Firefox explorer
        2. Open Wikipedia main page
        3. Open Wikipedia in English
        4. Type a word to search
        5. Compare the word to search vs the list elements
        */
        int ind;
        driver = new FirefoxDriver();
        driver.get("http://www.wikipedia.org");
        link = driver.findElement(By.linkText("English"));
        link.click();
        
        Thread.sleep(8000);
        
        searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(sendKeys);
        
        List<WebElement> optionsToSelect = driver.findElements(By.xpath
            ("//div[@class='suggestions-result']"));
        
        System.out.println("Word to search: " + sendKeys);
        System.out.println("Size of Autosuggest is: " + optionsToSelect.size());
        
        for (WebElement option : optionsToSelect){
            System.out.println("Values are: \n" + option.getText());
            System.out.println("Band " + option.getText().equals(sendKeys));        
        }
        
        ind = indice(optionsToSelect.size());
        
        System.out.println("Index is " + ind);
        optionsToSelect.get(ind).click();
        
        Thread.sleep(5000);
        driver.quit();
    }
    
    public int indice(int tam){
        return ((int)(Math.random()*tam + 1));
    }
    /*public static void main(String[] args) throws InterruptedException{
        NavigateWikipedia nw = new NavigateWikipedia();
        nw.doAnotherSearchFF("Salma Hayek", "Steve Jobs");
    }*/
}
