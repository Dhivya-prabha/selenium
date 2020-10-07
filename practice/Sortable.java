package Sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		WebElement item2 = driver.findElementByXPath("//ul[@id='sortable']/li[5]");
		WebElement item3 = driver.findElementByXPath("//ul[@id='sortable']/li[2]");
		Actions act = new Actions(driver);

		int x = item2.getLocation().getX();
		int y = item2.getLocation().getY();
//		Thread.sleep(2000);
		act.dragAndDropBy(item1, x, y).perform();

	}

}
