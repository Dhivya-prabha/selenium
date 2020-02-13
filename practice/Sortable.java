package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		WebElement item2 = driver.findElementByXPath("//ul[@id='sortable']/li[5]");
		WebElement item3 = driver.findElementByXPath("//ul[@id='sortable']/li[2]");
		Actions act = new Actions(driver);
//		Thread.sleep(2000);
		act.dragAndDrop(item1, item3).perform();
		
		
	}

}
