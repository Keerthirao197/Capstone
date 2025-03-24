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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class button_Clicks {
	
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
			driver.get(p.getProperty("URL2"));
			driver.manage().window().maximize();
		}
	
	
	//clicking Button1 using xpath locator and WebElement click method
	
	@Test(priority=0)
	public void button1() throws InterruptedException 
	{
	
		WebElement Button1=driver.findElement(By.xpath("//span[@id='button1']"));
		Button1.click();
		Thread.sleep(2000);
		WebElement Window1=driver.findElement(By.xpath("//div[@id='myModalClick']//button[@type='button'][normalize-space()='Close']"));
		Window1.click();
	
	}
	
	//clicking Button2 using cssSelector and javaScript click method
	
	@Test(priority=1)
	public void button2() throws InterruptedException 
	{
		WebElement Button2=driver.findElement(By.cssSelector("span#button2"));
		Button2.click();
		Thread.sleep(2000);
		WebElement Window2=driver.findElement(By.xpath("//div[@class='modal-dialog modal-md']//button[@type='button'][normalize-space()='Close']"));
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Window2);
		
	}
	
	//clicking Button3 using xpath locator and WebElement click method
	
	@Test(priority=2)
	public void button3() throws InterruptedException 
	{
		WebElement Button3=driver.findElement(By.xpath("//span[@id='button3']"));
		Button3.click();
		Thread.sleep(2000);
		WebElement Window3=driver.findElement(By.xpath("//div[@id='myModalMoveClick']//button[@type='button'][normalize-space()='Close']"));
		Window3.click();
	}
	
	@AfterClass
	public void tearDown()
	{
		if (driver != null)
		driver.quit();
	}
}

