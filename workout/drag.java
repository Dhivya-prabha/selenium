package week3.day1;


import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class drag {
	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);

		Thread.sleep(1000);
		
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		
		
		Point item4Loc = driver.findElementByXPath("//li[text()='Item 4']").getLocation();
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(item1).moveToElement(item4, item4Loc.x, item4Loc.x).release(item1).perform();
		System.out.println("moved");
	}
}

/*
 * package com.latest; import java.io.File; import java.io.FileInputStream;
 * import java.util.Iterator;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class ReadExcelDemo { public static void main(String[] args) { try {
 * FileInputStream file = new FileInputStream(new
 * File("howtodoinjava_demo.xlsx"));
 * 
 * //Create Workbook instance holding reference to .xlsx file XSSFWorkbook
 * workbook = new XSSFWorkbook(file);
 * 
 * //Get first/desired sheet from the workbook XSSFSheet sheet =
 * workbook.getSheetAt(0);
 * 
 * //Iterate through each rows one by one Iterator<Row> rowIterator =
 * sheet.iterator(); while (rowIterator.hasNext()) { Row row =
 * rowIterator.next(); //For each row, iterate through all the columns
 * Iterator<Cell> cellIterator = row.cellIterator();
 * 
 * while (cellIterator.hasNext()) { Cell cell = cellIterator.next(); //Check the
 * cell type and format accordingly switch (cell.getCellType()) { case
 * Cell.CELL_TYPE_NUMERIC: System.out.print(cell.getNumericCellValue() + "t");
 * break; case Cell.CELL_TYPE_STRING: System.out.print(cell.getStringCellValue()
 * + "t"); break; } } System.out.println(""); } file.close(); } catch (Exception
 * e) { e.printStackTrace(); } } }
 * 
 * 
 * Example demonstrating how to write to Excel file :
 * 
 * import java.io.File; import java.io.FileInputStream; import
 * java.io.FileOutputStream; import java.util.Iterator; import java.util.Map;
 * import java.util.TreeMap;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class WriteExcelDemo { public static void main(String[] args) {
 * //Blank workbook XSSFWorkbook workbook = new XSSFWorkbook();
 * 
 * //Create a blank sheet XSSFSheet sheet =
 * workbook.createSheet("Employee Data");
 * 
 * //This data needs to be written (Object[]) Map<String, Object[]> data = new
 * TreeMap<String, Object[]>(); data.put("1", new Object[] {"ID", "NAME",
 * "LASTNAME"}); data.put("2", new Object[] {1, "Amit", "Shukla"});
 * data.put("3", new Object[] {2, "Lokesh", "Gupta"}); data.put("4", new
 * Object[] {3, "John", "Adwards"}); data.put("5", new Object[] {4, "Brian",
 * "Schultz"});
 * 
 * //Iterate over data and write to sheet Set<String> keyset = data.keySet();
 * int rownum = 0; for (String key : keyset) { Row row =
 * sheet.createRow(rownum++); Object [] objArr = data.get(key); int cellnum = 0;
 * for (Object obj : objArr) { Cell cell = row.createCell(cellnum++); if(obj
 * instanceof String) cell.setCellValue((String)obj); else if(obj instanceof
 * Integer) cell.setCellValue((Integer)obj); } } try { //Write the workbook in
 * file system FileOutputStream out = new FileOutputStream(new
 * File("howtodoinjava_demo.xlsx")); workbook.write(out); out.close();
 * System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
 * } catch (Exception e) { e.printStackTrace(); } } }
 * 
 * 
 */
