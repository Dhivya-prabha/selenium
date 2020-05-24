package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebTable {
		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");			
			ChromeDriver driver = new ChromeDriver();			
			driver.get("http://leafground.com/pages/table.html");
			driver.manage().window().maximize();
			//WebElement table = driver.findElementById("table_id");
			List<WebElement> row = driver.findElementsByXPath("//table//tr/td[2]");
			List<Integer> vital = new ArrayList<Integer>();
			for (WebElement mark : row) {
				String least = mark.getText().replaceAll("%", "");
				vital.add(Integer.parseInt(least));
			}
			Collections.sort(vital);
			System.out.println(vital);
			Integer lowest = vital.get(0);

			driver.findElementByXPath("//td[contains(text(),'"+lowest+"')]/following-sibling::td/input").click();
			
			
			}
		}