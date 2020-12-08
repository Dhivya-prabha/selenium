package plainScript;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.findElementByXPath("//a[text()='Sortable']").click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		driver.switchTo().frame(0);

		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");

		Point item4Loc = driver.findElementByXPath("//li[text()='Item 4']").getLocation();

		System.out.println(item4Loc);
		int cordX = item4Loc.x;
		int cordY = item4Loc.y;

		Actions builder = new Actions(driver);
		builder.dragAndDropBy(item1, cordX, cordY).perform();

		WebElement item5 = driver.findElementByXPath("//li[text()='Item 5']");
		WebElement item6 = driver.findElementByXPath("//li[text()='Item 6']");
		
		Point item6Loc = driver.findElementByXPath("//li[text()='Item 6']").getLocation();

		builder.clickAndHold(item5).moveToElement(item6, item6Loc.x, item6Loc.x).release(item5).perform();
		System.out.println("moved");



	}

}
