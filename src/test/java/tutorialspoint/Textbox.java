package tutorialspoint;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class Textbox {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/text-box.php";
	WebDriver driver=null;
  @Test
  public void f() throws InterruptedException {
	
	  WebElement heading=driver.findElement(By.xpath("//body//header//div//h1[normalize-space()='Selenium - Automation Practice Form']"));
	  WebElement Fullname=driver.findElement(By.id("fullname"));
	  WebElement Email=driver.findElement(By.id("email"));
	  WebElement Currentaddress=driver.findElement(By.id("address"));
	  WebElement Password=driver.findElement(By.id("password"));
	  WebElement submit=driver.findElement(By.xpath("//input[@value='Submit']"));
	  
	  System.out.println("The form name is :: "+heading.getText());
	  Fullname.sendKeys("Harini");
	  Email.sendKeys("harini@gmail.com");
	  Currentaddress.sendKeys("No 1 street, Chennai");
	  Password.sendKeys("Tutorialpoint@1234");
	  submit.click();
	  Thread.sleep(6000);
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
