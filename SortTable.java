package week4.day1Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Comparator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./src/main/resources/Snapshots/Img3.jpg");
		FileUtils.copyFile(source, dest);
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> list = table.findElements(By.xpath("//table[@id='table_id']//tbody/tr/td[2]"));
		List<String> addList=new ArrayList<String>();
	    for (WebElement eachElementAdd : list) {
	    	String listValues1 = eachElementAdd.getText();
	    	addList.add(listValues1);
		}
	    Collections.sort(addList);
	    driver.findElement(By.xpath("//table/thead/tr/th[2]")).click();
	    List<WebElement> againList = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
	    List<String> list2=new ArrayList<>();
	    for (WebElement secondList : againList) {
			String listValues2 = secondList.getText();
			list2.add(listValues2);
		}
	    Collections.sort(list2);
	     if (addList.equals(list2)==true) {
	    	 System.out.println("List Values get matched");
			
		} else {
			System.out.println("List Values not get matched");

		}
	    
	}
	

}
