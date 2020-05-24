package week3.day1;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//h5[text()='Alert']").click();
		driver.findElementByXPath("//button[text()='Alert Box']").click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElementByXPath("//button[text()='Confirm Box']").click();
		alert.accept();
		driver.findElementByXPath("//button[text()='Prompt Box']").click();
		alert.accept();
		driver.findElementByXPath("//button[text()='Line Breaks?']").click();
		alert.accept();
		driver.findElementByXPath("//button[text()='Sweet Alert']").click();
		driver.findElementByXPath("//button[@class='swal-button swal-button--confirm']").click();
				
		/*Set<String> windows = driver.getWindowHandles();
		List<String>allwindow = new ArrayList<String>(windows);
		driver.switchTo().window(allwindow.get(2));
		*/
		
		
		
	}
}