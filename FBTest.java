package testNGsample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FBTest {
	
	WebDriver driver;
	WebElement email, pass, submit;
	
  
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  
  @BeforeTest
  public void beforeTest() {  
	  driver.get("https://www.facebook.com");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
  }
  
  @BeforeMethod
  public void beforeTestMethod() {
	  email = driver.findElement(By.cssSelector("input[id='email']"));
	  pass = driver.findElement(By.cssSelector("#pass"));
	  submit = driver.findElement(By.xpath("//div/button[text()=\"Log in\"]"));
  }
  
  @Test()
  public void bothAreEmpty(){
	  email.sendKeys("");
	  pass.sendKeys("");
	  submit.click();
  }
  
  @Test()
  public void emailISEmpty() {
	  email.sendKeys("");
	  pass.sendKeys("12334");
	  submit.click();
  }
  
  @Test()
  public void passIsEmpty() {
	  email.sendKeys("jobberscafe@gmail.com");
	  pass.sendKeys("");
	  submit.click();
  }
  
  
  @AfterMethod
  public void afterTestMethod() throws InterruptedException {

	  Thread.sleep(3000);

	 
  }
  
 
  
  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
