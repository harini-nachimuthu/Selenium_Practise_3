package tutorialspoint;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class NewTest {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/browser-windows.php";
	WebDriver driver;
  @Test
  public void f() {
	  WebElement web1=driver.findElement(By.xpath("//button[@title='New Tab']"));
	  web1.click();
	  
	  String parent=driver.getWindowHandle();
	  Set<String> s=driver.getWindowHandles();
	  Iterator<String> iter1=s.iterator();
	  
	  while(iter1.hasNext()) {
		  String child=iter1.next();
		  if( !parent.equals(child)) {
			  driver.switchTo().window(child);
			  System.out.println("child :: "+driver.switchTo().window(child).getTitle());
			  
			  driver.close();
			  
		  }
	  }
	  
	  driver.switchTo().window(parent);
	  System.out.println("parent :: "+ driver.switchTo().window(parent).getTitle());
	  
	  
	  
	  
  }
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @BeforeClass
  public void beforclass() {
	  driver.get(url);
  }
  @AfterSuite
  public void afterSuite() {
	  if(driver!=null) {
		  driver.quit();
	  }
  }

}
