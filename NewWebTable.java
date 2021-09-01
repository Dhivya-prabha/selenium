package JavaBasics;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWebTable {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
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
		
		
		for(int i = 1; i< allRows.size(); i++)
		{
			WebElement rowtext = allRows.get(i);
			List<WebElement> allcolumn =  rowtext.findElements(By.tagName("td"));
			int colcount = allcolumn.size();
			System.out.println(allcolumn.get(1).getText());
	}

}

	}

