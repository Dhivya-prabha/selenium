package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Adding the ChromeDriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

	   
		
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
				
		//opening browser
		driver.get("https://www.redbus.in/");

		//enter source location
		driver.findElementById("src").sendKeys("Chennai");
		Thread.sleep(5000);
		driver.findElementById("src").sendKeys(Keys.TAB);

		//entering dest location
		driver.findElementById("dest").sendKeys("Bengaluru");
		Thread.sleep(5000);
		driver.findElementById("dest").sendKeys(Keys.TAB);

		//selection date
		driver.findElementById("onward_cal").click();
		//enter 30/4 as date
		driver.findElementByXPath("(//td[text()='30'])[2]").click();


		//checking after 6pm departure
		driver.findElementByXPath("(//label[@for='dtAfter 6 pm'])[1]").click();

		//checking sleeper
		driver.findElementByXPath("(//label[@for='bt_SLEEPER'])[1]").click();

		//seats available
		driver.findElementByXPath("(//div[contains(@class,'w-15 fl')]//a)[2]").click();
			}

		}