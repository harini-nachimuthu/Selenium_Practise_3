package Keyboardactions.Keyboard1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class NewTest4 {
	protected static String url="https://jqueryui.com/droppable/";
	WebDriver drive;
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  drive=new ChromeDriver();
	  drive.manage().window().maximize();
	  drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @BeforeClass
  public void chrome() {
	 drive.get(url); 
  }
  @Test
  public void f() throws InterruptedException {
	  Actions actions=new Actions(drive);
	  drive.switchTo().frame(0);
	  WebElement drag=drive.findElement(By.id("draggable"));
	  WebElement drop=drive.findElement(By.id("droppable"));
	  String bfr_drp=drop.getCssValue("color");
	  String bfr_drop=drop.getText();
	  System.out.println("before : "+bfr_drp);
	  System.out.println("before : "+bfr_drop);
	  Thread.sleep(2000);
	  actions.dragAndDrop(drag, drop).perform();;
	  String aftr_drp=drop.getCssValue("color");
	  String aftr_drop=drop.getText();
	  System.out.println("after : "+aftr_drp);
	  System.out.println("after : "+aftr_drop);
	  Thread.sleep(2000);
  }
  @AfterSuite
  public void afterSuite() {
	  if(drive!=null) {
		  drive.close();
	  }
  }

}
