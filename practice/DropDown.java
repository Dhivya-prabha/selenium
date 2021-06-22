package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement byId = driver.findElementById("dropdown1");
		Select dd1 = new Select(byId);
		dd1.selectByIndex(1); 
		
		
		WebElement byTxt = driver.findElementByName("dropdown2");
		Select text = new Select(byTxt);
		text.selectByVisibleText("Appium"); 
		
		WebElement byVal = driver.findElementById("dropdown3");
		Select Val = new Select(byVal);
		Val.selectByVisibleText("UFT/QTP"); 

		WebElement total = driver.findElementByClassName("dropdown");
		Select num = new Select(total);
		int totOptions = num.getOptions().size();
		System.out.println(totOptions);
		
		driver.findElementByXPath("//div[@class='example'][5]//select").sendKeys("Selenium");
		driver.findElementByXPath("//option[text()='Select your programs']/following-sibling::option").click();
		driver.findElementByXPath("//option[text()='Select your programs']/following::option[2]").click();
		driver.findElementByXPath("//option[text()='Select your programs']/following::option[4]").click();
		
	}

}
