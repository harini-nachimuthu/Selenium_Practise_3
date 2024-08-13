package Practise_selenium;

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

public class NewTest1 {
	protected static String url="https://demoqa.com/radio-button";
	WebDriver driver=null;
  @Test
  public void radio() throws InterruptedException {
	  WebElement radio=driver.findElement(By.cssSelector("label[for='yesRadio']"));
	  radio.click();
	  Thread.sleep(2000);
	  WebElement radio1=driver.findElement(By.cssSelector("p[class$='mt-3']"));
	  System.out.println(radio.getText());
  }
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  @BeforeClass
  public void before() {
	  driver.get(url);
  }

  @AfterSuite
  public void afterSuite() {
	  if(driver != null) {
		  driver.close();
	  }
  }

}
