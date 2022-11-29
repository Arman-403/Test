package testNGsample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class NewTest {
	 
	WebDriver driver;
	  
	  @BeforeTest 
	  public void pre() {
		  WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		  driver.get("https://www.meesho.com");
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  }
	
  @Test(priority=1)
  public void validate() {
	 
	  
	  Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[2]/div[1]/input")).isEnabled());
	  
	  
  }
  @Test (priority=2)
  public void button() {

	  Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[3]/div[1]")).isEnabled());
	 
  }
  @Test (priority=3)
  public void title() {
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/h4")).isDisplayed());
	 
  }
  @AfterTest 
  public void end() {
	  driver.close();
  }
  
}
