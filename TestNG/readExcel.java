package Basics;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readExcel extends ProjectSpecificMethods {
	public static String[][] excelData(String filename) throws IOException { 

		XSSFWorkbook wb= new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet ws= wb.getSheetAt(0);
		//to get row count
		int rowscount= ws.getLastRowNum();
		System.out.println(rowscount);
		//to get column count
		int cellscount= ws.getRow(0).getLastCellNum();
		System.out.println(cellscount);
		String[][] data = new String[rowscount][cellscount];
		for(int i=1;i<=rowscount;i++)
		{
			for(int j=0;j<cellscount;j++)
			{
				data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
			}
			System.out.println("****");
		}
		
	wb.close();
		
		return data;
	}

}