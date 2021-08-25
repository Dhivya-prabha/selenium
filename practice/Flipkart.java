package Oops2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		// Launch Chrome Browser in Headleass Mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		ChromeDriver driver = new ChromeDriver();
		// ChromeDriver driver = new ChromeDriver();
		// Launch Zomato.com
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//button[@class='_2KpZ6l _2doB4z']").click();
		driver.findElementByXPath("//input[@title='Search for products, brands and more']").sendKeys("wireless speaker", Keys.ENTER);
		
		List<WebElement> price = driver.findElementsByXPath("//div[@class='_30jeq3']");
		List<Integer> val = new ArrayList<Integer>();
		for (int i = 0; i < price.size(); i++) {
			String pr = price.get(i).getText().replaceAll("[^a-zA-Z0-9]", "");
			val.add(Integer.parseInt(pr));
		}
		
		System.out.println(val);
		Integer min = Collections.min(val);
		System.out.println();
		driver.findElementByXPath("//div[text()='"+min+"']").click();
		
	}

}
