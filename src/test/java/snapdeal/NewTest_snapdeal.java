package snapdeal;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class NewTest_snapdeal {
	protected static String url="http://www.snapdeal.com";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException{
	  Actions actions=new Actions(driver);
	  WebElement sigin=driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']"));
	  actions.clickAndHold(sigin).build().perform();
	  actions.click(sigin);
	  Thread.sleep(2000);
  }
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }
  @BeforeClass
  public void beforclass() {
	  driver.get(url);
  }

  @AfterSuite
  public void afterSuite() {
	  if(driver!=null) {
		  driver.close();
	  }
  }

}
