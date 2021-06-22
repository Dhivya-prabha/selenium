package sample;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BrokenImage {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Image.html");
		WebElement brokenImage = driver.findElementByXPath("//img[@src='../images/abcd.jpg']");
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(brokenImage.getAttribute("src"));
		HttpResponse response = client.execute(request);

		// verifying response code he HttpStatus should be 200 if not,
		// increment as invalid images count

		if (response.getStatusLine().getStatusCode() != 200) {
			System.out.println("Image is broken");
		}
	}

}
