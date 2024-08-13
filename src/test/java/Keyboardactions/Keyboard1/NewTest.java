package Keyboardactions.Keyboard1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;

public class NewTest {
	protected static String url="https://demoqa.com/text-box";
	WebDriver driver;
	@BeforeSuite
	  public void chromeInitialisation() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	  }
	@BeforeClass
	  public void chromelaunch() {
		driver.get(url);
	  }

	  @Test
	  public void gettingtitle() throws InterruptedException {
		  String title=driver.getTitle();
		  System.out.println(title);
		  Thread.sleep(1000);
	  }
	  @Test
	  public void keyboardevents() {
		  Actions actions=new Actions(driver);
		  WebElement fullname=driver.findElement(By.id("userName"));
		  fullname.sendKeys("Harini");
		  WebElement Email=driver.findElement(By.id("userEmail"));
		  Email.sendKeys("harini.nachimuthu@gmail.com");
		  WebElement curraddress=driver.findElement(By.id("currentAddress"));
		  curraddress.sendKeys("Chennai");
		  
		  
		  actions.keyDown(Keys.CONTROL);
		  actions.sendKeys("a");
		  actions.keyUp(Keys.CONTROL);
		  actions.build().perform();
		  
		  actions.keyDown(Keys.CONTROL);
		  actions.sendKeys("c");
		  actions.keyUp(Keys.CONTROL);
		  actions.build().perform();
		  
		  actions.sendKeys(Keys.TAB);
		  actions.build().perform();
		  
		  actions.keyDown(Keys.CONTROL);
		  actions.sendKeys("v");
		  actions.keyUp(Keys.CONTROL);
		  actions.build().perform();
		  
		  WebElement permanentAdress=driver.findElement(By.id("permanentAddress"));
			 
		   assertEquals(curraddress.getAttribute("value"), permanentAdress.getAttribute("value"));
	  }
  @AfterSuite
  public void afterSuite() {
  }

}
