package selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class selenium_scroll {
	protected static String url="https://www.selenium.dev/";
	WebDriver driver=null;
  @Test
  public void f() throws InterruptedException {
	  for(int i=0;i<13;i++) {
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("window.scrollTo(0,300)");
		  //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  Thread.sleep(1000);
		  //document.body.scrollHeight
		  js.executeScript("window.scrollTo(0,0)");
          Thread.sleep(1000); 
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
