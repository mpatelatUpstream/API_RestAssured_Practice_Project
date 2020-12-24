package util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility2 {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtility2(String excelPath, String sheetName) {
		try {

			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

//	public static void main(String[] args) {
//		getRowCount();
//		getCellData();
//	}	
	public static void getRowCount() {
		// Xlsx format excel file has XSSFWorkbook class
		//String excelPath = "./dataFolder/Raghav_Pal_Rest-Assured_data.xlsx";
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows : " + rowCount);
	}

	public static void getCellData(int rowNum, int colNum) {

		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println(value);
	}

}
