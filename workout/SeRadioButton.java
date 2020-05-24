package week2.day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeRadioButton {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElementByXPath("//h5[text()='Radio Button']").click();
		driver.findElementById("yes").click();
		String path = "//label[text()='Find default selected radio button']/following::label";
		if(driver.findElementByXPath(path+"[1]").isSelected()) {
			System.out.println(driver.findElementByXPath(path+"[1]").getText());
		}else
		{
			System.out.println(driver.findElementByXPath(path+"[2]").getText());
		}
		
		String radio = "//label[contains(text(), 'Select your age group')]/following::input[2]";
		 System.out.println(driver.findElementByXPath(radio).getText());
     
      if(driver.findElementByXPath(radio).isSelected()) {
    	  System.out.println("came");
    	  System.out.println(driver.findElementByXPath(radio).getText());
          }
     
           
           
		
		
	}
	
	
	/*
	 * //Pseudo Code
	 * 
	 * 1. Launch URL "http://www.leafground.com/"
	 * 
	 * 2. Click on RadioButton
	 * 
	 * 3. Click the RadioButton Option for Are you enjoying the classes?
	 * 
	 * 4. Get the text for default selected radio button
	 * 
	 * 5.  Get the text for ,Select your age group (Only if choice wasn't selected) if not 
	      Select your age Group and get the text.
	 * 
	 * 
	 */

}
