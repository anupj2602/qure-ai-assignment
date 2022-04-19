package com.qureai.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataUtil {
	@DataProvider(name="articleData")
	public String[][] readExcelData() throws IOException {
		String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\ConduitArticles.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Articles");

		//Getting total row count
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);

		//Getting total column count
		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println(cols);

		String[][] excelData = new String[rows-1][cols];
		System.out.println(excelData);

		for(int i=1;i<rows-1;i++) {
			for(int j=1;j<cols-1;j++) {
				//DataFormatter used to convert all types of data into String
				DataFormatter df = new DataFormatter();
				//excelData[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				excelData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(excelData[i][j]);
				//String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();// - Same as Line 37
				//System.out.println(cellValue);
			}
		}
		workbook.close();
		fis.close();
		//System.out.println(Arrays.toString(excelData));
		return excelData;
	}

}
