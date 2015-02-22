package com.Maven.web.MavenProject2;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.SearchPage;



public class N11TestCases {
	
	public  WebDriver driver = new FirefoxDriver();
	
	
	
	

	HomePage homePage= new HomePage(driver);
	LoginPage loginPage= new LoginPage(driver);
	SearchPage searchPage= new SearchPage(driver);
	ProductPage productPage = new ProductPage(driver);

	
	//Ps:The required validations are inside the functions
	@Test
	public void SuccesfulLoginAndAddToFavouritesAndRemoveFromFavourites() 
	{
		
		homePage.openBrowser();
		loginPage.login("test1@test.com","a123123" );		
		searchPage.search("Samsung");
		searchPage.selectItem(3);
		productPage.addToFavourites();
		productPage.removeFromFavourites();
		
		
		
	}
	
	
	
	
	
	

}
