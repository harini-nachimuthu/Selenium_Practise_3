package practise_form_testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class tutorialspoint {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";
	WebDriver driver=null;
  @Test
  public void func() throws InterruptedException {
	  String title=driver.getTitle();
	  System.out.println("Title of the website is :: "+title);
	  String pageurl=driver.getCurrentUrl();
	  System.out.println("url of the website is :: "+pageurl);
	  WebElement firstname=driver.findElement(By.id("name"));
	  firstname.sendKeys("Harini");
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("harivasanthan37@gmail.com");
	  WebElement gender=driver.findElement(By.xpath("//label[normalize-space()='Female']"));
	  gender.click();
	  WebElement mobile=driver.findElement(By.id("mobile"));
	  mobile.sendKeys("9514248426");
	  WebElement dob=driver.findElement(By.id("dob"));
	  WebElement subjects=driver.findElement(By.id("subjects"));
	  subjects.sendKeys("JAVA Automation Testing");
	  WebElement hobbies=driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
	  hobbies.click();
	  WebElement address=driver.findElement(By.cssSelector("textarea[placeholder='Currend Address']"));
	  address.sendKeys("No-1 street chennai");
	  WebElement selectstate=driver.findElement(By.cssSelector("select[id='state']"));
	  WebElement selectedstate=driver.findElement(By.xpath("//option[@value='Haryana']"));
	  selectedstate.click();
	  WebElement selectcity=driver.findElement(By.cssSelector("select[id='city']"));
	  WebElement selectedcity=driver.findElement(By.xpath("//option[@value='Agra']"));
	  selectedcity.click();
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
  public void before() {
	  driver.get(url);
  }

  @AfterSuite
  public void afterSuite() {
	  if(driver!=null) {
		  driver.close();
	  }
  }

}
