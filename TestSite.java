package testNGsample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSite {
	
	public static void main(String[] args) throws InterruptedException {	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www2.asx.com.au");
		
		WebElement cookie =	driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
		
		if(cookie.isDisplayed()) {
			cookie.click();
		}
		
		driver.findElement(By.xpath("//div[@id=\"pnProductNavContents\"]/h5[2]")).click();
	
		
		for (int i = 2; i<=6;i++) {
			
			for (int j = 1; j<=3;j++) {
				WebElement tb = driver.findElement(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr["+i+"]/td["+j+"]"));
				System.out.print(tb.getText()+"\t");	
			}
			System.out.println();
		}

		
		Thread.sleep(3000);
		
		driver.close();
		
	
	
	}

}
