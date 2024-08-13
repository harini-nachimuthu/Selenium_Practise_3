package tutorialspoint;

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

public class button {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/buttons.php";
	WebDriver driver=null;
  @Test
  public void f() {
	  Actions actions=new Actions(driver);
	  
	  WebElement click1=driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
	  click1.click();
	
	  String click1out=driver.findElement(By.xpath("//div[@id=\"welcomeDiv\"]")).getText();
	  System.out.println(click1out);
	  WebElement doubleclick1=driver.findElement(By.xpath("//button[normalize-space()='Double Click Me']"));
	  
	  actions.doubleClick(doubleclick1);
	  actions.build().perform();
	  String click2out=driver.findElement(By.xpath("//p[@id=\"doublec\"]")).getText();
	  System.out.println(click2out);
	
	  WebElement rightclick=driver.findElement(By.xpath("//button[normalize-space()='Right Click Me']"));
	  actions.contextClick(rightclick); 
	  actions.build().perform();
	  System.out.println("right click is done........");
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
