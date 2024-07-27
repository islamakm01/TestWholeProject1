package com.ExcelData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {
	
	
	@Test
	public void readExcelData() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Data\\Book1.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		XSSFRow row = sheet.getRow(2);
		
		int numberOfCells = row.getLastCellNum();
		
		for (int i = 0; i < numberOfCells; i++) {
			XSSFCell cells = row.getCell(i);
			System.out.print(cells + " | ");
		}
		
		
	}

}
