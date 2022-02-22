package week4.day1Assignments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ExplicitWaitAppear {
	public static void main(String[] args) throws IOException {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/appear.html");
		WebDriverWait wait=new WebDriverWait(driver,30);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn"))).getText();
	    System.out.println(text);
	    File source = driver.getScreenshotAs(OutputType.FILE);
	    File dest=new File("./src/main/resources/Snapshots/Img1.jpg");
	    FileUtils.copyFile(source, dest);
	}

}
