package plainScript;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		driver.switchTo().frame(0);

		WebElement item1 = driver.findElementByXPath("//ol/li[1]");
		WebElement item2 = driver.findElementByXPath("//ol/li[2]");
		WebElement item3 = driver.findElementByXPath("//ol/li[5]");
		WebElement item4 = driver.findElementByXPath("//ol/li[7]");
		/*act.keyDown(item1, Keys.CONTROL).build().perform();
		act.keyDown(item2, Keys.CONTROL).build().perform();
		act.keyDown(item3, Keys.CONTROL).build().perform();
		act.keyDown(item4, Keys.CONTROL).build().perform();*/
		
		act.keyDown(Keys.CONTROL).click(item1).click(item3).click(item2);
		act.keyUp(Keys.CONTROL).perform();

	}

}
