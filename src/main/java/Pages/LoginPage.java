package Pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page	{

	public LoginPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(linkText="Giriş Yap")
	public WebElement btnGirisYap;
	
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[1]/div/div/div[1]/form/div[4]")
	public WebElement btnFbGiris;
	
	
	@FindBy(id="email")
	public WebElement txtEmail;
	
	
	
	@FindBy(xpath="/html/body/div/div[2]/div/form/div[2]/div[1]/input")
	public WebElement xpathEmail;
	
	
	
	@FindBy(id="password")
	public WebElement txtPassword;
	
	
	
	@FindBy(id="loginButton")
	public WebElement btnLogin;
	
	
	
	
	
	public void login(String email , String pass)
	{
		
		btnGirisYap.click();
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pass);
		btnLogin.click();
		
	
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
