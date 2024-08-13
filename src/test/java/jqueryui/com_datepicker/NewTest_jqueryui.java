package jqueryui.com_datepicker;

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

public class NewTest_jqueryui {
	protected static String url="https://jqueryui.com/datepicker/";
	WebDriver driver=null;
  @Test
  public void f() {
	  driver.switchTo().frame(0);
	  WebElement date=driver.findElement(By.id("datepicker"));
	  date.click();
	  WebElement month=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
	  month.click();
	  WebElement select=driver.findElement(By.xpath("//a[@data-date='22']"));
	  select.click();
	  String selecteddate=date.getAttribute("value");
	  System.out.print("Datepicker : "+selecteddate);
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
