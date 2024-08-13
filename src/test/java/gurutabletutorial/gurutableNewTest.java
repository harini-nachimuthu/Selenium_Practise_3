package gurutabletutorial;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class gurutableNewTest {
	protected static String url="https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
	WebDriver driver=null;
  @Test
  public void f() {
	  //Verify that there are only 4 structure values present in the table with Selenium
	  List<WebElement> columntest=driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr/th['+i+']"));
	  System.out.println("Structure thead size:: "+columntest.size());
	  for(WebElement columntestdata:columntest) {
		  String cdata=columntestdata.getText();
		  System.out.println(cdata);
	  }
	  //Verify that the 6th row of the table (Last Row) has only two columns with Selenium
	  List<WebElement> tfootth=driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tfoot//tr//th"));
	  List<WebElement> tfoottd=driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tfoot//tr//td"));
	  for(WebElement thfootdata:tfootth) {
		  String fdata=thfootdata.getText();
		  System.out.println(fdata+"---th");
	  } 
	  for(WebElement tdfootdata:tfoottd) {
		  String fddata=tdfootdata.getText();
		  System.out.println(fddata+"---td");
	  } 
	  tfootth.addAll(tfoottd);
	  System.out.println("last row size : "+tfootth.size());
	  if(tfootth.size()==2) {
		  System.out.println("yes size is 2");
	  }else {
		  System.out.println("No size is not two");
	  }
	  
	  //Find the tallest and smallest structure in the table with Selenium
	  List<WebElement> commonrow=driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tbody//tr"));
	  
	  int max=0;
	  int min=Integer.MAX_VALUE;
	  String  largestructure="";
	  String smallstructure="";
	  
	  for(WebElement column_row:commonrow) {
		  WebElement col_row_3=column_row.findElement(By.xpath(".//td[3]"));
		  String heighttext=col_row_3.getText().replace("m", "");
		  int number=Integer.parseInt(heighttext);
		  if(number>max) {
			  max=number;
			  largestructure=column_row.findElement(By.xpath(".//th")).getText();
		  }
	  }
	  System.out.println("largest structure : "+largestructure);
	  
	  for(WebElement column_row:commonrow) {
		  WebElement col_row_3=column_row.findElement(By.xpath(".//td[3]"));
		  String heighttext=col_row_3.getText().replace("m", "");
		  int number=Integer.parseInt(heighttext);
		  if(number<min) {
			  min=number;
			  smallstructure=column_row.findElement(By.xpath(".//th")).getText();
		  }
	  }
	  System.out.println("smallest structure : "+smallstructure);
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
