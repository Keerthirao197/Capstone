package capstone;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Page {
	
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
			driver.get(p.getProperty("URL1"));
			driver.manage().window().maximize();
		}
	
	@Test
	public void Login() throws InterruptedException 
	{
		
		WebElement usernameField = driver.findElement(By.id("text"));
		WebElement passwordField = driver.findElement(By.id("password"));

		usernameField.sendKeys(p.getProperty("username"));
		passwordField.sendKeys(p.getProperty("password"));
		
		WebElement Login_btn=driver.findElement(By.xpath("//button[@id='login-button']"));
		Login_btn.click();
		
		Thread.sleep(3000);
		
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.accept();
	}
	
	@AfterClass
	public void tearDown()
	{
        if (driver != null) 
            driver.quit();
	}

	
	
}