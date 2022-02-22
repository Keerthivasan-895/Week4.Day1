package week4.day1Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class WebTable {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./src/main/resources/Snapshots/Img2.jpg");
		FileUtils.copyFile(source, dest);
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> column = table.findElements(By.tagName("th"));
		System.out.println("Total Number of Columns :" +column.size());
		List<WebElement> row = table.findElements(By.xpath("//table[@id='table_id']//tr/td[1]"));
	    System.out.println("Total Number of Rows :" +row.size());
	    String progress = table.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText();
	    System.out.println("Learn to interact with Elements :" + progress);
	    List<WebElement> progressColumn = table.findElements(By.xpath("//table[@id='table_id']//tr/td[2]"));
	   for (int i = 0; i<progressColumn.size(); i++) { 
		WebElement index = progressColumn.get(i);
		String text = index.getText();
	  if (text.equals("30%")) {
		  driver.findElement(By.xpath("//table/tbody/tr[4]/td/input")).click();
		    }  
	}				 
	}
	}