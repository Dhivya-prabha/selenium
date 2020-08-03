package Learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class FrameCount {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		int size = driver.findElementsByTagName("iframe").size();
		int count = size;
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			count = count + driver.findElementsByTagName("iframe").size();
			driver.switchTo().defaultContent();
		}
		System.out.println(count);

	}
}