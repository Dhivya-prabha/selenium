package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class windows {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		/*driver.findElementByXPath("//button[text()='Open Home Page']").click();
		Set<String> HomePage = driver.getWindowHandles();
		List<String> lstHome = new ArrayList<String>(HomePage);
		for (int i = 0; i < lstHome.size(); i++) {
			driver.switchTo().window(lstHome.get(i));
			System.out.println(driver.getTitle());
		}*/
		
		driver.findElementByXPath("//button[text()='Open Multiple Windows']").click();
		Set<String> MulWindows = driver.getWindowHandles();
		System.out.println(MulWindows);
		for (String eachwin : MulWindows) {
			driver.switchTo().window(eachwin);
			System.out.println(driver.getTitle());
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
