package guvi_signandlogin;

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

public class NewTest_guvi {
	protected static String url="https://www.guvi.in/";
	WebDriver driver=null;
//  @Test
//  public void f() throws InterruptedException {
//	  driver.findElement(By.xpath("//a[normalize-space()='Sign up']")).click();
//	  WebElement name=driver.findElement(By.cssSelector("input[id='name']"));
//	  name.sendKeys("Vasanth");
//	  WebElement email=driver.findElement(By.cssSelector("input[id='email']"));
//	  email.sendKeys("vasanthan@gmail.com");
//	  WebElement password=driver.findElement(By.cssSelector("input[id='password']"));
//	  password.sendKeys("Guvi@12345");
//	  WebElement mobilenumber=driver.findElement(By.cssSelector("input[id='mobileNumber']"));
//	  mobilenumber.sendKeys("8976450934");
//	  driver.findElement(By.xpath("(//a[normalize-space()='Sign Up'])[1]")).click();
//	  driver.findElement(By.id("laterBtn")).click();
//	  Thread.sleep(2000);
//	  WebElement signupcheck=driver.findElement(By.cssSelector("small[class='email-wrap text-secondary']"));
//	  String final_login=signupcheck.toString();
//	  if(final_login.equals("vasanthan@gmail.com")) {
//		  System.out.println("Yes signup is successfull");
//	  }else {
//		  System.out.println("No signup not successfull");
//	  }
//  }
  @Test
  public void g() throws InterruptedException {
	  driver.findElement(By.cssSelector("#login-btn")).click();
	  WebElement logemail=driver.findElement(By.cssSelector("input[id='email']"));
	  logemail.sendKeys("vasanthan@gmail.com");
	  WebElement logpassword=driver.findElement(By.cssSelector("input[id='password']"));
	  logpassword.sendKeys("Guvi@12345");
	  driver.findElement(By.xpath("a[id='login-btn']")).click();
	  Thread.sleep(2000);
	  WebElement logincheck=driver.findElement(By.cssSelector("small[class='email-wrap text-secondary']"));
	  String final_login=logincheck.toString();
	  if(final_login.equals("vasanthan@gmail.com")) {
		  System.out.println("Yes login is successfull");
	  }else {
		  System.out.println("No login not successfull");
	  }
	  
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
