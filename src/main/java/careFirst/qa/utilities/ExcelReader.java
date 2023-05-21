package careFirst.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import careFirst.qa.reporting.Logger;

//public class ExcelReader {
//
//	Workbook wb;
//	Sheet sheet;
//
//	public ExcelReader(String path, String sheetName) {
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(path);
//		} catch (IOException e) {
//			e.printStackTrace();
//			Logger.log("File not found @" + path);
//		}
//		if (path.endsWith("xls")) {
//			try {
//				wb = new HSSFWorkbook(fis);
//			} catch (IOException e) {
//				e.printStackTrace();
//				Logger.log("File not found @" + path);
//			}
//		} else if (path.endsWith("xlsx")) {
//			try {
//				wb = new XSSFWorkbook(fis);
//			} catch (IOException e) {
//				e.printStackTrace();
//				Logger.log("File not found @" + path);
//			}
//		}
//		sheet = wb.getSheet(sheetName);
//	}
//
//	public Object[][] getData1() {
//		Object[][] data = {};
//		int rows = sheet.getLastRowNum();
//		int cells = sheet.getRow(0).getLastCellNum();
//		data = new Object[rows][cells];
//		DataFormatter df = new DataFormatter();
//
//		for (int i = 0; i < rows; i++) {
//			Row row = sheet.getRow(i + 1);
//
//			for (int j = 0; j < cells; j++) {
//				Cell cell = row.getCell(j);
//				Object value = df.formatCellValue(cell);
//				data[i][j] = value;
//
//			}
//
//		}
//		return data;
//	}
//
//}
