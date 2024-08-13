package tabletutorial;

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

public class table_NewTest_tutorial {
	protected static String url="https://www.tutorialspoint.com/selenium/practice/webtables.php";
	WebDriver driver=null;
  @Test
  public void tablerccount() {
	  
	
	  List<WebElement> column=driver.findElements(By.xpath("//*[@class='bd-example table-responsive']/table/thead/tr/th"));
	  System.out.println("column count : "+column.size());
	  for(WebElement columndata:column) {
		  String cdata=columndata.getText();
		  System.out.print("/n"+cdata+"||");
	  }
	  
	  List<WebElement> row=driver.findElements(By.xpath("//table/tbody/tr['+i+']"));
	  System.out.println();
	  System.out.println("Row size : "+row.size());
	  
	  //rowdata 
	  List<WebElement> rowdata=driver.findElements(By.xpath("//table/tbody/tr['+i+']/td['+j=']"));
	  for(WebElement rdata:rowdata) {
		  String rd=rdata.getText();
		  System.out.println("row data : "+rd);
	  }
	  
	  //particular cells data
	  List<WebElement> particularrowdata=driver.findElements(By.xpath("//table/tbody/tr[1]/td[\"+i+\"]"));
	  for(WebElement particular:particularrowdata) {
		  String particular1=particular.getText();
		  System.out.println("row data of 1 : "+particular1 +"|");
	  }
	  
	  //particular column data 
	  List<WebElement> particularcoldata=driver.findElements(By.xpath("//table/tbody/tr['+i+']/td[3]"));
	  for(WebElement particularcol:particularcoldata) {
		  String particular2=particularcol.getText();
		  System.out.println("column data of 3 : "+particular2 +"|");
	  }
  }
  @BeforeClass
  public void beforclasss() {
	  driver.get(url);
  }
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  @AfterSuite
  public void afterSuite() {
	  if(driver!=null) {
		  driver.close();
	  }
  }

}
