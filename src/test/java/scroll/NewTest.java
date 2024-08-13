package scroll;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class NewTest {
	protected static String url="https://writingcenter.unc.edu/tips-and-tools/paragraphs/#:~:text=Paragraphs%20are%20the%20building%20blocks,is%20what%20constitutes%20a%20paragraph.";
	WebDriver driver=null;
  @Test
  public void f() throws InterruptedException {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  for(int i=0;i<5;i++) {
		  js.executeScript("window.scrollBy(0, 1);");
		  Thread.sleep(2000);
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
