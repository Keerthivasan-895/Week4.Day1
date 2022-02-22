package week4.day1Assignments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ExplicitWaitTextChange {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		WebDriverWait wait =new WebDriverWait(driver,30);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button")));
		Thread.sleep(3000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./src/main/resources/Snapshots/Img2.jpg");
		FileUtils.copyFile(source, dest);
		until.click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		boolean equals = text.equals("Click ME!");
		System.out.println("Verified : " + equals);
	}

}
