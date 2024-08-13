package Keyboardactions.Keyboard1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class NewTest1 {
	protected static String url="https://the-internet.herokuapp.com/";
	WebDriver driver;
	@BeforeSuite
	  public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  }
	@BeforeClass
	public void urlopen(){
		driver.get(url);
	}

  @Test
  public void internetapptest() throws InterruptedException, IOException {
	  WebElement elementselection=driver.findElement(By.linkText("Add/Remove Elements"));
	  elementselection.click();
	  Thread.sleep(2000);
	  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file, new File("C:\\Users\\harin\\eclipse-workspace\\Keyboard1\\src\\test\\java\\Keyboardactions\\Keyboard1\\NewTest1.png"));
	  WebElement addelement=driver.findElement(By.cssSelector("button[onclick='addElement()']"));
	  addelement.click();
	  Thread.sleep(2000);
	  File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file1,new File("C:\\Users\\harin\\eclipse-workspace\\Keyboard1\\src\\test\\java\\Keyboardactions\\Keyboard1\\NewTest1.1.png"));
	  WebElement deleteelement=driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
	  deleteelement.click();
	  Thread.sleep(1000);
	  File file2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file2, new File("C:\\Users\\harin\\eclipse-workspace\\Keyboard1\\src\\test\\java\\Keyboardactions\\Keyboard1\\NewTest1.2.png"));
	  driver.navigate().refresh();
	  }
  @AfterSuite
  public void afterSuite() {
	  if(driver!=null) {
		  driver.close();
	  }
  }

}
