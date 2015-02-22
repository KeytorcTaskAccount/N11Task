package Pages;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Maven.web.MavenProject2.N11TestCases;

public class HomePage  extends Page{

	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public String baseURL="http://www.n11.com/";

	
	
	@FindBy(linkText="Giriş Yap")
	public WebElement btnGirisYap;


	@FindBy(css="img[alt=\"Alışverişin Uğurlu Adresi\"]")
	public WebElement btnLogo;
	
	
	
	public void login()
	{
		
		btnGirisYap.click();
		
	}
	
	
	
	@Override
	public void openBrowser() {
	
		driver.get("https://www.n11.com");
		driver.manage().window().maximize();
		assertTrue(driver.getCurrentUrl().equals(baseURL));
		System.out.println("Validate : The current page adress is  http://www.n11.com ");
		
		
	}
	

	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		
	}

	
	public void closeApp() {
	
		driver.close();
		
	}
	

	

}
