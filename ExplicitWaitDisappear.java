package week4.day1Assignments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDisappear {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/disapper.html");
		WebDriverWait wait = new WebDriverWait(driver,30);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains (text(),'I know you can do it! Button is disappeared!')]"))).getText();
	    System.out.println(text);
	    File source = driver.getScreenshotAs(OutputType.FILE);
	    File dest=new File("./src/main/resources/Snapshots/Imag01.jpg");
	    FileUtils.copyFile(source, dest);
	}

}
