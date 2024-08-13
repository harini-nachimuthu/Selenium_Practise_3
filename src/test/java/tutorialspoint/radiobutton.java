package tutorialspoint;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class radiobutton {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/radio-button.php";
	WebDriver driver=null;
  @Test
  public void f() throws InterruptedException {
	  WebElement buttonclick=driver.findElement(By.xpath("//input[@onclick='show2();']"));
	  buttonclick.click();
	  String out=driver.findElement(By.xpath("//div[@id='check']")).getText();
	  System.out.println(out);
	  WebElement button2click=driver.findElement(By.xpath("//input[@onclick='show3();']"));
	  button2click.click();
	  String out1=driver.findElement(By.xpath("//div[@id='check1']")).getText();
	  System.out.println(out1);
	
	  WebElement button3click=driver.findElement(By.xpath("//input[@name='inlineRadioOptions']"));
	  if(button3click.isEnabled()) {
		  button3click.click();
	  }else {
		  System.out.println("No it is disabled");
	  }
	  Thread.sleep(2000);
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
	  driver.navigate().to(url);
  }
  @AfterSuite
  public void afterSuite() {
	  if(driver!=null) {
		  driver.close();
	  }
  }

}
