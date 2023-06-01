package com.paramountplus.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * Used to read data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/TestDat.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String data= wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * Set excel data in multiple rows and columns
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String setExcelValue(String sheetName, int rowNum, int cellNum, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resouces/TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(value);
		FileOutputStream fos= new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
		return value;	
	}
	/**
	 * Used to get last row number in a excel sheet
	 * @param sheetName
	 * @return int
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();

	}
}
