package Keyboardactions.Keyboard1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class key1 {
	protected static String url="https://demoqa.com/text-box";
	WebDriver driver;
	
  @BeforeSuite
  public void browserinitialisation() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @BeforeClass
  public void openUrl() {
	  driver.get(url);
  }

  @Test
  public void gettitle() throws InterruptedException {
	  
	  String title=driver.getTitle();
	  System.out.println(title);
	  //Thread.sleep(1000);
  }

//  @Test
//  public void beforeSuite() {
//  }

  @AfterSuite
  public void closebrowser() {
	  driver.close();
  }

}
