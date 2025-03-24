package capstone;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HiddenElements {
	
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
				driver.get(p.getProperty("URL6"));
				driver.manage().window().maximize();
			}
		
		@Test
		public void button1() throws InterruptedException 
		{
				WebElement btn1=driver.findElement(By.xpath("//p[normalize-space()='CLICK ME!']"));
			
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", btn1);
				
				/*Alert alert=driver.switchTo().alert();
				alert.accept();*/
				
				/*try
				{
				js.executeScript("window.alert=function{};");
				}catch(Exception e)
				{
				}*/	
			
		}
		
		/*@Test
		public void button2() throws InterruptedException 
		{
				WebElement btn2=driver.findElement(By.xpath("//span[@id='button2']"));
			
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", btn2);
			
		}*/
			
	}

