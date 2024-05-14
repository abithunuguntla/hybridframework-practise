package com.allianz.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class demo2ExcelTest {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("src/test/resources/test_data/Hrm_data.xlsx");

		// selectingxcel
		XSSFWorkbook book = new XSSFWorkbook(file);

		// extracting sheet from excel
		XSSFSheet sheet = book.getSheet("invalidLogin");
	
Object data[][] = new Object[2][3];

//writing a logic to print all values
for(int ro = 1 ; ro<=2;ro++) {
	for(int co = 0 ;co<=2;co++) {
		String value1 = sheet.getRow(ro).getCell(co).getStringCellValue();
		System.out.println(value1);
	}
}

book.close();
file.close();

	}

}
