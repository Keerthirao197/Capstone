package capstone;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scrolling {
	WebDriver driver;
	public Properties p;
	
	@BeforeClass	
	public void setup() throws InterruptedException, IOException 
		{

			//Loading config.properties file
			FileReader file=new FileReader("./src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(p.getProperty("URL5"));
			driver.manage().window().maximize();
		}
	
	@Test
	public void scroll() throws InterruptedException {
		
		WebElement Zone1=driver.findElement(By.xpath("//div[@id='zone1']"));
		WebElement Zone2=driver.findElement(By.xpath("//h1[@id='zone2-entries']"));
		WebElement Zone3=driver.findElement(By.xpath("//h1[@id='zone3-entries']"));
		//WebElement Zone4=driver.findElement(By.xpath("//div[@id='zone4']"));

		
		Actions act=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//Zone1
		act.moveToElement(Zone1).perform();
		js.executeScript("arguments[0].scrollIntoView();", Zone1);
		Long v = (Long)js.executeScript("return window.pageYOffset;");
		System.out.println("Scroll position after launch: " + v);
		
		//Zone2 and Zone3
		act.moveToElement(Zone2).perform();
		act.moveToElement(Zone3).perform();
		
		Thread.sleep(3000);
		
		//Zone4
		js.executeScript("window.scrollBy(539,966)", "");
		Long u = (Long)js.executeScript("return window.pageYOffset;");
		System.out.println("Scroll position after launch: " + u);	

	}
	@AfterClass
	public void tearDown()
	{
		if(driver!=null)
		driver.quit();
	}
}