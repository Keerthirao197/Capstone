package capstone;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDown_Checkbox_RadioButton {
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
			driver.get(p.getProperty("URL3"));
			driver.manage().window().maximize();
		}
	
	
	@Test(priority=0)
	public void SelectDropDown() throws InterruptedException {
	
	//creating select class for dropdown1
	WebElement dropdown1=driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']"));
	Select dropdown_menu_1=new Select(dropdown1);
	dropdown_menu_1.selectByVisibleText("C#");
	
	//creating select class for dropdown2
	WebElement dropdown2=driver.findElement(By.xpath("//select[@id='dropdowm-menu-2']"));
	Select dropdowm_menu_2=new Select(dropdown2);
	dropdowm_menu_2.selectByValue("maven");
	
	//creating select class for dropdown3
	WebElement dropdown3=driver.findElement(By.xpath("//select[@id='dropdowm-menu-3']"));
	Select dropdowm_menu_3=new Select(dropdown3);
	dropdowm_menu_3.selectByIndex(3);
	}
	
	@Test(priority=1)
	public void checkbox() throws InterruptedException {
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		//unselect checkboxes if they are selected
		for(int i=0;i<3;i++)
		{
			checkboxes.get(i).click();	
		}	
		for(int i=0;i<checkboxes.size();i++)
		{
			if(checkboxes.get(i).isSelected())
			{
			checkboxes.get(i).click();	
			}
		}
		
		Thread.sleep(3000);

		//select specify checkbox
		//driver.findElement(By.xpath("//input[@value='option-1']")).click();
		
		//select multiple checkboxes
		/*for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}*/
		
		for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}
		
		
	/*	//select last 3 checkboxes
		//total number of checkboxes-how many checkboxes want to select =starting index
				//4-3=1
				for(int i=1;i<checkboxes.size();i++)
				{
					checkboxes.get(i).click();	
				}
				
		//select first 3 checkboxes	
				for(int i=0;i<3;i++)
				{
					checkboxes.get(i).click();	
				}*/

	}
	
	@Test(priority=2)
	public void Radio_Button() throws InterruptedException {
		
		List<WebElement> Radio_btns=driver.findElements(By.xpath("//input[@name='color']"));
		
		for(int i=0;i<Radio_btns.size();i++)
		{
			Radio_btns.get(i).click();
			Thread.sleep(1000);
		}
	}
	
	@Test(priority=3)
	public void Enable_disable() throws InterruptedException {
		
			//disabled or Selected from radio buttons
	
			List<WebElement> vegetable=driver.findElements(By.xpath("//input[@name='vegetable']"));
			
			for(int i=0;i<vegetable.size();i++)
			{
				if(vegetable.get(i).isSelected())
					System.out.println(vegetable.get(i)+" is selected");
				
				else if(vegetable.get(i).isEnabled())
					System.out.println(vegetable.get(i)+" is Enabled");
				
				else
					System.out.println(vegetable.get(i)+" is disabled");
						
			}
			
			//disabled or Selected from dropdown
			
			WebElement drop_down=driver.findElement(By.xpath("//select[@id='fruit-selects']"));
			Select dropdown_menu=new Select(drop_down);
			
			List<WebElement> drpdwn=dropdown_menu.getOptions();
			
			for(int i=0;i<drpdwn.size();i++)
			{
				if(drpdwn.get(i).isEnabled())
					System.out.println(drpdwn.get(i)+" is Enabled");
				else
					System.out.println(drpdwn.get(i)+" is Disabled");
			}
	}
			
	
	@AfterClass
	public void tearDown()
	{
		if (driver != null)
		driver.quit();
	}
}
