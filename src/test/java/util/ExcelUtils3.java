package util;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils3 {
	public static void main(String[] args) {
		getRowCount();
		getCellData();
	}

	public static void getCellData() {
		try {
			String excelPath = "./dataFolder/Raghav_Pal_Rest-Assured_data.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(1).getCell(0));

			System.out.println("**************");
			System.out.println(value);
		} catch (IOException exp) {

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	
	
	public static void getRowCount() {
		// Xlsx format excel file has XSSFWorkbook class
		try {
			String excelPath = "./dataFolder/Raghav_Pal_Rest-Assured_data.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
			XSSFSheet sheet = workbook.getSheet("Sheet1");


			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("number Of Rows: " + rowCount);
		} catch (IOException exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}


}
