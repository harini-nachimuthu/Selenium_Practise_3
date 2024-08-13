package tutorialspoint;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class Checkbox {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/check-box.php";
	WebDriver driver=null;
  @Test
  public void f() throws InterruptedException {
	
	  WebElement heading=driver.findElement(By.xpath("//h1[normalize-space()='Check Box']"));
	  System.out.println("The heading :: "+heading.getText());
	  WebElement plusclick=driver.findElement(By.xpath("//li[@id='bs_1']//span[@class='plus']"));
	  plusclick.click();
	  
	  WebElement sub1click=driver.findElement(By.cssSelector("input[id='c_bf_1']"));
	  sub1click.click();
	  
	  WebElement sub2plusclick=driver.findElement(By.xpath("(//span[@class='plus'])[2]"));
	  sub2plusclick.click();
	  
	  WebElement sub2subclick=driver.findElement(By.id("c_io_5"));
	  sub2subclick.click();
	  
	  WebElement sub2sub1click=driver.findElement(By.id("c_io_7"));
	  sub2sub1click.click();
	  
	  WebElement check2mainbox = driver.findElement(By.xpath("//input[@id='c_bs_2']"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", check2mainbox);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", check2mainbox);
      
      WebElement main2plis = driver.findElement(By.xpath("//body/main/div[@class='container']/div[@class='row d-flex justify-content-center logindiv bg-white rounded']/div[@class='col-md-8 col-lg-8 col-xl-8']/div[@class='tree_main']/ul[@id='bs_main']/li[@id='bs_2']/span[1]"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", main2plis);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", main2plis);
      
      WebElement check2sub1box = driver.findElement(By.xpath("//li[@id='bf_3']//span[@class='plus']"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", check2sub1box);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", check2sub1box);
      
      WebElement check2sub2box = driver.findElement(By.xpath("//li[@id='bf_4']//span[@class='plus']"));
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", check2sub2box);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", check2sub2box);
      
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", check2sub1box);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", check2sub1box);
      
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", check2sub2box);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", check2sub2box);
      
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", main2plis);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", main2plis);

	  
	  Thread.sleep(1000);
	  
	  
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


