package Practise_selenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class NewTest {
	String baseUrl = "https://www.toolsqa.com/";
	WebDriver driver;
	
	 @BeforeSuite
	  public void beforeSuite() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  }
//	 @BeforeClass
//	  public  void beforeclas() {
//		  
//	  }
	  @Test
	  public void function() {
		  driver.get(baseUrl);
		  String testTitle = baseUrl;
		  String originalurl=driver.getCurrentUrl();
		  Assert.assertEquals(originalurl,testTitle);
	  }
	  @AfterSuite
	  public void afterSuite() {
		  driver.close();
		  System.out.print("after suite");
	  }

}
