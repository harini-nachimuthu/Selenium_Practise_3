package Keyboardactions.Keyboard1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class NewTest3 {
	protected static String url="https://demo.guru99.com/test/simple_context_menu.html";
	WebDriver driver;
 // @Test
//  public void f() throws InterruptedException {
//	  Actions actions=new Actions(driver);
//	  WebElement doubleclick=driver.findElement(By.cssSelector("button[ondblclick='myFunction()']"));
//	  actions.doubleClick(doubleclick).perform();
//	  Thread.sleep(2000);
//	  Alert al=driver.switchTo().alert();
//	  System.out.println("Alert message received : "+al.getText());
//	  al.accept();
//	  Thread.sleep(2000);
//}
  @Test
  public void g() throws InterruptedException {
	  Actions actions=new Actions(driver);
	  WebElement click=driver.findElement(By.cssSelector("span[class='context-menu-one btn btn-neutral']"));
	  actions.contextClick(click).perform();;
	  Thread.sleep(1000);
	  WebElement copy=driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']"));
	  copy.click();
	  Thread.sleep(3000);
	  Alert al=driver.switchTo().alert();
      System.out.println("Copied alert msg :: "+al.getText());
	  al.accept();
	  Thread.sleep(2000);
}
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @BeforeClass
  public void firefoxinit() {
	  driver.get(url);
  }
  @AfterSuite
  public void afterSuite() {
	  if(driver!=null) {
		  driver.quit();
	  }
  }

}
