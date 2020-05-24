package week3.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parent = driver.getWindowHandle();
		driver.findElementByXPath("//h5[text()='Window']").click();
		driver.findElementByXPath("//button[text()='Open Home Page']").click();
		for(String current : driver.getWindowHandles()) {
			driver.switchTo().window(current);
		}
		
		//driver.close();
		driver.switchTo().window(parent);
		driver.findElementByXPath("//button[text()='Open Multiple Windows']").click();
		Set<String> allHandles = driver.getWindowHandles();
		List<String> winHandle = new ArrayList<String>(allHandles);
		System.out.println("Count of windows:"+allHandles.size());
		driver.switchTo().window(winHandle.get(2));
		//driver.switchTo().window((new ArrayList<String>(driver.getWindowHandles()).get(2)));
	
		System.out.println(driver.getTitle());
		driver.close();
		//driver.switchTo().window(winHandle.get(2)).close();
		driver.switchTo().window(winHandle.get(1)).close();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button[text()='Wait for 5 seconds']")));		  

	}
}
