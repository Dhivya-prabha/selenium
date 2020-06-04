package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Basics.ProjectSpecificMethods;

public class CreateLead extends ProjectSpecificMethods{  
	@BeforeTest
	public void sendExcel() {
		excelBook = "testData"; 
	}
	@Test(dataProvider="fetchdata")
	public void runCreateLead(String cname, String fname, String lname){	
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(cname);
		driver.findElementById("createLeadForm_firstName").sendKeys(fname);
		driver.findElementById("createLeadForm_lastName").sendKeys(lname);
		driver.findElementByName("submitButton").click();
		
		}


}

