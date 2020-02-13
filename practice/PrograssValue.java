package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrograssValue {
public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement table = driver.findElementById("table_id");
		List<WebElement> row = table.findElements(By.tagName("tr"));
		List<WebElement> col = driver.findElementsByXPath("//table//tr[1]/th");
		System.out.println("The row count o fthis table is: "+ row.size());
		System.out.println("The column count of this table is: "+col.size());
		
		
		for(int i=2; i<row.size();i++)
		{
		WebElement name = driver.findElementByXPath("//table//tr["+i+"]/td[1]");
		if(name.getText().contains("Elements")) {
			
		WebElement check = driver.findElementByXPath("//table//tr["+i+"]/td[2]");
		System.out.println(check.getText());
			}
		
		
		}
		
		
}
}
