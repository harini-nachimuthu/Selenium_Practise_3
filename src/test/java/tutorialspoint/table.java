package tutorialspoint;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class table {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/webtables.php";
	WebDriver driver=null;
  @Test
  public void f() {
	  WebElement table=driver.findElement(By.xpath("//table[@class='table table-striped mt-3']"));
	  WebElement thead=table.findElement(By.tagName("thead"));
	  List<WebElement> therow=thead.findElements(By.tagName("tr"));
	  for(WebElement therows:therow) {
		  System.out.println(therows.getText()+" ");
	  }
	  WebElement thbody=table.findElement(By.tagName("tbody"));
	  List<WebElement> row=thbody.findElements(By.tagName("tr"));
	  for(WebElement rows:row) {
		  List<WebElement> cells = rows.findElements(By.tagName("td"));
		  for(WebElement cell:cells) {
			  System.out.print(cell.getText()+" ");
		  }
		  System.out.println();
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
