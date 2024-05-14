package com.allianz.utilis;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Object[][] getsheetintotwodimarray(String path, String sheetname) throws IOException {

		FileInputStream file = new FileInputStream(path);
		// selectingxcel
		XSSFWorkbook book = new XSSFWorkbook(file);
		// extracting sheet from excel
		XSSFSheet sheet = book.getSheet(sheetname);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object data[][] = new Object[rowcount - 1][cellcount];
		
		DataFormatter format = new DataFormatter();
//writing a logic to print all values
		for (int ro = 1; ro < rowcount; ro++) {
			for (int co = 0; co < cellcount; co++) {
				String value1 = format.formatCellValue(sheet.getRow(ro).getCell(co));
				System.out.println(value1);
				data[ro - 1][co] = value1;
			}
		}
		book.close();
		file.close();
		return data;
	}

}
