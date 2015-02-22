package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Maven.web.MavenProject2.N11TestCases;

public class Page  {
	

	
	 WebDriver driver;
	 
	 public Page(WebDriver driver) {
		 
		 this.driver= driver;
	}


	 public void delay(int timeSeconds)
	 {
		 driver.manage().timeouts().implicitlyWait(timeSeconds,TimeUnit.SECONDS);
		 
	 }
		
	 
	 
	 
	 
	public void openBrowser(WebDriver driver){};
	public void closeBrowser(){}
	public void openBrowser() {};
	
	 

}
