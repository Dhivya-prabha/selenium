package test;

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
			
				
				driver.get("https://erail.in/");
				driver.manage().window().maximize();
				driver.findElementByXPath("//input[@id = 'chkSelectDateOnly']").click();
				Thread.sleep(3000);
				driver.findElementById("txtStationFrom").clear();  
		        driver.findElementById("txtStationFrom").sendKeys("MS", Keys.TAB);
				driver.findElementById("txtStationTo").clear();
				driver.findElementById("txtStationTo").sendKeys("KKDI", Keys.TAB);
				Thread.sleep(3000);
				WebElement table = driver.findElementByXPath("//table[@class = 'DataTable TrainList TrainListHeader']");
				List<WebElement> allRows = table.findElements(By.tagName("tr"));
				WebElement rowCount = allRows.get(1);
				List<WebElement> allColumns = table.findElements(By.tagName("td"));
				WebElement secColumn = allColumns.get(1);
				int columnCount = allColumns.size();
				
				
				for(int i = 1; i< allRows.size(); i++)
				{
					WebElement rowtext = allRows.get(i);
					List<WebElement> allcolumn =  rowtext.findElements(By.tagName("td"));
					int colcount = allcolumn.size();
					System.out.println(allcolumn.get(1).getText());
			}

		}
		}