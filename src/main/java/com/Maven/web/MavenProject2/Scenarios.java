package com.Maven.web.MavenProject2;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.hamcrest.core.Is;
import org.junit.*;
import org.openqa.jetty.html.List;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.omg.DynamicAny.NameValuePair;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class Scenarios {
	
	private  FirefoxDriver driver = new FirefoxDriver();
	
	private  String strBaseUrl ="http://www.n11.com";
	private  String strLastWindow = null;
	private  String strPage="2";
	
	private  String xpFacebookButton = "/html/body/div[1]/div[1]/div/div[1]/div/div/div[1]/form/div[4]";
	private  String xpSearchResults = "//div[@id='view']//ul//li//div//div[@class='pro']//a[@class='plink']";
	private  String xpAddToFavourites= "/html/body/div[1]/div[1]/div/div[2]/div[2]/div[1]/div/h1";
	private  String xpItemInFavourites= "/html/body/div[2]/div[1]/div/div[2]/div[2]/div[2]/table/tbody/tr[1]/td[3]/p/a";
	
	
	public void delay(int timeSeconds)
	{
	 driver.manage().timeouts().implicitlyWait(timeSeconds,TimeUnit.SECONDS);	
	}
	
	
	
	
	@Before
	public void openBrowser()
	{
		driver.get(strBaseUrl);
		
	}
	
	
	@Test
	public void Scenario1withFacebookLogin()
	{
		
		driver.findElement(By.className("btnSignIn")).click();
		driver.findElement(By.xpath(xpFacebookButton)).click();
		
		
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) 
		{
		        strLastWindow = handle;
		}
		
		driver.switchTo().window(strLastWindow);
		delay(20);
			
		driver.findElement(By.id("email")).sendKeys("test.keytorc@gmail.com");
	    driver.findElement(By.id("pass")).sendKeys("2754648592");
		driver.findElement(By.id("loginbutton")).click();
		
		
		handles = driver.getWindowHandles();
		for (String handle : handles) 
		{
		        strLastWindow = handle;
		}
		driver.switchTo().window(strLastWindow);
				
		
	    driver.findElement(By.id("searchData")).clear();
		driver.findElement(By.id("searchData")).sendKeys("Samsung");
	    driver.findElement(By.className("searchBtn")).click();
	    
		assertTrue(driver.getCurrentUrl().endsWith("Samsung")); // Validate that search result for samsung
	
		driver.findElement(By.linkText(strPage)).click();
		assertTrue(driver.getCurrentUrl().endsWith("pg="+strPage)); // Validate that the current page is 2
	
	
		//add all items on a list
		ArrayList<WebElement> searchList =(ArrayList<WebElement>) driver.findElements(By.xpath(xpSearchResults));
		searchList.get(5).click(); // click on 5th item
		delay(10);

		driver.findElement(By.id("addToFavourites")).click();
		String itemAddedToFavourites  = driver.findElement(By.xpath(xpAddToFavourites)).getText();
		
		
		driver.findElement(By.linkText("Hesabım")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Favorilerim')])[2]")).click();
	    delay(10);
	    String itemInFavourites = driver.findElement(By.xpath(xpItemInFavourites)).getText();
	    assertTrue(itemAddedToFavourites.equals(itemInFavourites)); // Validation 
 	    delay(5);
	    driver.findElement(By.linkText("Kaldır")).click();
	
	    assertTrue( driver.findElements(By.linkText("Kaldır")).size() == 0); // Validate Item is deleted.
	 	
	}
	
	
	  @Test
	  public void Scenario1withStandartLogin()  
	  {
		 
		 
		
		driver.findElement(By.className("btnSignIn")).click();
		
		 
		driver.findElement(By.id("email")).sendKeys("test1@test.com");
		driver.findElement(By.id("password")).sendKeys("a123123");
	    driver.findElement(By.id("loginButton")).click();
	    
	    driver.findElement(By.id("searchData")).sendKeys("Samsung");
	    driver.findElement(By.className("searchBtn")).click();
		
		assertTrue(driver.getCurrentUrl().endsWith("Samsung")); // Validate that search result for samsung
	
		driver.findElement(By.linkText(strPage)).click();
		assertTrue(driver.getCurrentUrl().endsWith("pg="+strPage)); // Validate that the current page is 2
	
	
		//add all items on a list
		ArrayList<WebElement> searchList =(ArrayList<WebElement>) driver.findElements(By.xpath(xpSearchResults));
		searchList.get(5).click(); // click on 5th item
				
		
		delay(10);
		driver.findElement(By.id("addToFavourites")).click();
		
		
		String itemAddedToFavourites = driver.findElement(By.xpath(xpAddToFavourites)).getText();
		
		driver.findElement(By.linkText("Hesabım")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Favorilerim')])[2]")).click();
	    delay(10);
	    String itemInFavourites = driver.findElement(By.xpath(xpItemInFavourites)).getText();
	    assertTrue(itemAddedToFavourites.equals(itemInFavourites)); // Validation 
 	    delay(5);
	    driver.findElement(By.linkText("Kaldır")).click();

	    assertTrue( driver.findElements(By.linkText("Kaldır")).size() == 0); // Validate Item is deleted.
	    	
	    
	  }
	
	  
	  
	  @After
	  public void LogoutandQuit()
	  {
		driver.findElement(By.linkText("Hesabım")).click();
		driver.findElement(By.linkText("Çıkış Yap")).click(); 
		driver.close();
		driver.quit();

	  }	  
	  


}
