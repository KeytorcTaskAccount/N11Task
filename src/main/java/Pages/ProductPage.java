package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;

public class ProductPage extends Page {

	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	public String productName;
	
	
	@FindBy(className="myAccount")
	public WebElement btnMyAccount;
	
	@FindBy(id="addToFavourites")
	public WebElement btnAddtoFav;
	
	
	@FindBy(linkText="Favorilerim")
	public WebElement btnMyFav;
	
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[3]/div[2]/div[1]/div/h1")
	public WebElement txtProductName;
	
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/p/a")
	public WebElement txtFavItemName;
	
	
	@FindBy(linkText="Kaldır")
	public WebElement btnRemoveFromFavs;
	
	
	
	public void addToFavourites()
	{
		delay(1);
		btnAddtoFav.click();
		productName=txtProductName.getText();
		delay(1);
		btnMyAccount.click();
		delay(3);
		btnMyFav.click();
		delay(3);
		assertTrue(productName.equals(txtFavItemName.getText()));
		System.out.println("Validate : The item added to favourites is in the Favourities List");
		
	
		
	}
	
	
	
	public void removeFromFavourites()
	{
		
		btnRemoveFromFavs.click();
		System.out.println("Item is deleted from Favourites");
		
	}
	
	
	
	

}
