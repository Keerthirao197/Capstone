package capstone;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionClass {
	
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
			driver.get(p.getProperty("URL4"));
			driver.manage().window().maximize();
		}
	
		@Test(priority=0)
		public void Drag_Drop() throws InterruptedException {
			
			Actions act=new Actions(driver);
			
			//drag and drop
			WebElement src=driver.findElement(By.xpath("//div[@id='draggable']//p"));
			WebElement des=driver.findElement(By.xpath("//div[@id='droppable']"));
	
			act.dragAndDrop(src,des).perform();
		}
		
		@Test(priority=1)
		public void DoubleClk_Action() throws InterruptedException {
			
			Actions act=new Actions(driver);

			WebElement dc=driver.findElement(By.xpath("//h2[normalize-space()='Double Click Me!']"));
			
			act.doubleClick(dc).perform();
			Thread.sleep(3000);
		}
		
		@Test(priority=2)
		public void Hoven_Over_Me() throws InterruptedException {
			
			Actions act=new Actions(driver);
			
			WebElement HOM1=driver.findElement(By.xpath("//button[normalize-space()='Hover Over Me First!']"));
			WebElement HOM2=driver.findElement(By.xpath("//button[normalize-space()='Hover Over Me Second!']"));
			WebElement HOM3=driver.findElement(By.xpath("//button[normalize-space()='Hover Over Me Third!']"));

			act.moveToElement(HOM1).perform();
			Thread.sleep(1000);
			
			act.moveToElement(HOM2).perform();
			Thread.sleep(1000);
			
			act.moveToElement(HOM3).perform();
			Thread.sleep(1000);
		}
		
		@Test(priority=3)
		public void click_hold() throws InterruptedException {
			Actions act=new Actions(driver);

			WebElement clkhld =driver.findElement(By.xpath("//div[@id='click-box']"));

			act.clickAndHold(clkhld).perform();
		}
		
		@AfterClass
		public void tearDown()
		{
			if(driver!=null)
			driver.quit();
		}

}
