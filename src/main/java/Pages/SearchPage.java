package Pages;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Page {

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}




	@FindBy(id="searchData")
	public WebElement txtSearch;
	
	@FindBy(className="searchBtn")
	public WebElement btnSearch;
	
	@FindBy(linkText="2")
	public WebElement btnPage2;
	
	@FindBy(xpath="//div[@id='view']//ul//li//div//div[@class='pro']//a[@class='plink']")
	public WebElement searchResults;
	
	
	




public void search(String search){
	
	
	txtSearch.sendKeys("Samsung");
	btnSearch.click();
	assertTrue(driver.getCurrentUrl().endsWith("Samsung"));	
	System.out.println("Validate : Search results belongs to Samsung");
	
	btnPage2.click();
	assertTrue(driver.getCurrentUrl().endsWith("pg=2"));
	System.out.println("Validate : Current Page number is 2 ");
	
	
	
	
}


public void selectItem( int listNo){
	
	
	
	ArrayList<WebElement> searchList =(ArrayList<WebElement>) driver.findElements(By.xpath("//div[@id='view']//ul//li//div//div[@class='pro']//a[@class='plink']"));

	searchList.get(listNo).click(); 
	
	
	
	
}






}