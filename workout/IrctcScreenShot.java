package LearningString;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeOptions;


public class IrctcScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElementByXPath("//button[@type='submit']").click();
		Thread.sleep(3000);
		driver.findElementByLinkText("FLIGHTS").click();
		Thread.sleep(2000);

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listValues = new ArrayList<String>(windowHandles);
		String secondWindow = listValues.get(1);
		driver.switchTo().window(secondWindow);
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='Ok']").click();
		Thread.sleep(2000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/IRCTC.png");
		FileUtils.copyFile(source, target);

	}

}