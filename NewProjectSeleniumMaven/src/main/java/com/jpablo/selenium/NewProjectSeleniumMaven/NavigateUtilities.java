package com.jpablo.selenium.NewProjectSeleniumMaven;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.*;

public class NavigateUtilities {
	private WebDriver driver;
		
	public NavigateUtilities(){}
	
	public void takeScreenShot(WebDriver driver, String scenario){
		try{
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").
				  format(Calendar.getInstance().getTime());
		  	File dir = new File(".");
		  	File fin = new File(dir.getCanonicalPath() + 
				  File.separator + "screenshots" + File.separator + "Screenshot_" + scenario +"_"+ timeStamp + ".png");
		  	
		  	TakesScreenshot scrShot = ((TakesScreenshot)driver);
		  
		  	File scrShtFile =  scrShot.getScreenshotAs(OutputType.FILE);
		  	File destFile = fin;
		  	FileUtils.copyFile(scrShtFile,destFile);
		}
		catch (NullPointerException np){
			np.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		} 
	}
	
	public ArrayList<String> readLinesFile(){
        ArrayList<String> readLine =  new ArrayList<String>();
        String line = null;
        
        try{
        	File dir = new File(".");
            File fin = new File(dir.getCanonicalPath() 
                + File.separator + "wordsForWikipedia.txt");
            
            BufferedReader br = new BufferedReader(new FileReader(fin));
            while((line = br.readLine()) != null){
                System.out.println("Adding the string content per line");
                readLine.add(line);
            }
            br.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        
        return readLine;
    }
    
    public Map<String,String> mapWords(List<String> list){
    	Map<String,String> map = new HashMap<String,String>();
    	map.clear();
    	for(String ele : list){
    		map.put(ele, ele.toString());
    	}
    	return map;
    }
    
	@BeforeClass
	public void setup(){
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	public void teardown(){
		driver.quit();
	}
}
