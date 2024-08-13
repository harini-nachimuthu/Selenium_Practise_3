package frameseleniumpractise;

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

public class frameNewTest {
	protected static String url="https://ui.vision/demo/webtest/frames/";
	WebDriver driver=null;
  @Test
  public void f() throws InterruptedException {
	  List<WebElement> framesize=driver.findElements(By.tagName("frame"));
	  System.out.println("Total frames in one website is : "+framesize.size());
	 
	  //WebElement frame1=driver.findElement(By.xpath("src=\"frame_1.html\""));
	  driver.switchTo().frame(0);
	  WebElement frame1box=driver.findElement(By.name("mytext1"));
	  frame1box.sendKeys("Hello frame 'mytext1'");
	  Thread.sleep(2000);
	  
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(1);
	  WebElement frame2box=driver.findElement(By.name("mytext2"));
	  frame2box.sendKeys("Hello frame 'mytext2'");
	  Thread.sleep(2000);
	  
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(2);
	  WebElement frame3box=driver.findElement(By.name("mytext3"));
	  frame3box.sendKeys("Hello frame 'mytext3'");
	  driver.switchTo().frame(0);
	
	  WebElement option1=driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']"));
	  option1.click();
	  WebElement option2=driver.findElement(By.xpath("//div[@data-answer-value=\"General Web Automation\"]"));
	  option2.click();
	  WebElement option3=driver.findElement(By.xpath("//div[@class='Qr7Oae']//div[@class='e2CuFe eU809d']"));
	  option3.click();
	  WebElement option4=driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']//span[.='Well, now I know :-)']"));
	  option4.click();
	  Thread.sleep(2000);
	  
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame(3);
	  WebElement frame4box=driver.findElement(By.name("mytext4"));
	  frame4box.sendKeys("Hello frame 'mytext4'");
	  Thread.sleep(2000);
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
