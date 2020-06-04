package testcase;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Basics.ProjectSpecificMethods;
import cucumber.api.java.Before;

public class EditLead extends ProjectSpecificMethods{
	@BeforeTest
	public void sendExcel() {

		excelBook = "editLead";
	}
	
	@Test(dataProvider="fetchdata")
	public void runEditLead(String fname, String cName) throws InterruptedException {
		
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys(fname);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").sendKeys(cName);
		driver.findElementByName("submitButton").click();
		
}
}






