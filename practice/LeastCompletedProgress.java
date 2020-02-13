package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeastCompletedProgress {
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/pages/table.html");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement table = driver.findElementById("table_id");
	List<WebElement> row = driver.findElementsByXPath("//table//tr/td[2]");
	List<Integer> vital = new ArrayList<Integer>();
	for (WebElement mark : row) {
		String least = mark.getText().replaceAll("%", "");
		vital.add(Integer.parseInt(least));
	}
	Collections.sort(vital);
	Integer lowest = vital.get(0);

	driver.findElementByXPath("//td[contains(text(),'"+lowest+"')]/following-sibling::td/input").click();
	/*
	for(int i=0;i<row.size(); i++)
	{
		System.out.println(row.get(i).getText());
		if(row.get(i).getText().contains(lowest.toString()))
		{
			System.out.println(row.get(i).getText()+" "+lowest);
			driver.findElementByXPath("(//table//tr/td[3]/input)["+i+"]").click();;
		}
	*/
	
	}
}
	
	
	
	
	

