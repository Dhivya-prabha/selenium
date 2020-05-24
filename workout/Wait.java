package week3.day2;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");


	ChromeDriver driver = new ChromeDriver(options);

	driver.get("http://leafground.com/pages/disapper.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	
	WebElement disapper = driver.findElementByXPath("//button[@id='btn']//b[1]");
	
	WebDriverWait wait=new WebDriverWait(driver, 20);
	
	wait.until(ExpectedConditions.invisibilityOf(disapper));
	System.out.println(driver.findElementByTagName("strong").getText());
}
}
