package Learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item2 = driver.findElementByXPath("//li[text()='Item 3']");
		WebElement item3 = driver.findElementByXPath("//li[text()='Item 5']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 6']");
		act.keyDown(item1, Keys.CONTROL).build().perform();
		act.keyDown(item2, Keys.CONTROL).build().perform();
		act.keyDown(item3, Keys.CONTROL).build().perform();
		act.keyDown(item4, Keys.CONTROL).build().perform();
		act.keyUp(Keys.CONTROL);
	}

}