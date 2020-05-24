package week3.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Point;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver,chrome.silentOutput", "true");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.findElementByXPath("//a[text()='Sortable']").click();

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