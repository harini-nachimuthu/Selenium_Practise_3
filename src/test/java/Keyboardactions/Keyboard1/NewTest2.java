package Keyboardactions.Keyboard1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class NewTest2 {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/menu.php#";
	WebDriver driveclick;
  @BeforeSuite
  public void firefoxinitialize() {
	  WebDriverManager.firefoxdriver().setup();
	  driveclick=new FirefoxDriver();
	  driveclick.manage().window().maximize();
	  driveclick.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @BeforeClass
  public void firefoxinit() {
	  driveclick.get(url);
  }
  @Test
  public void seleniumcheck() throws InterruptedException {
	  Actions actions=new Actions(driveclick);
	  WebElement checking=driveclick.findElement(By.cssSelector("a[class='navbar-brand']"));
	  System.out.println("colour earlier: "+checking.getCssValue("color"));
	  actions.clickAndHold(checking);
	  actions.build().perform();
	  Thread.sleep(2000);
	  System.out.println("After colour : "+checking.getCssValue("color"));
  }
  

  @AfterSuite
  public void afterSuite() {
	  if(driveclick!=null) {
		  driveclick.quit();
	  }
  }

}
