package util;

public class ExcelUtilsTest {
	
	public static void main(String[] args) {
		
		String excelPath = "./dataFolder/TestDataCopy.xls";
		String sheetName = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		excel.getRowCount();
		excel.getCellData(1, 0);
		excel.getCellData(1, 1);
		excel.getCellData(1, 2);
		
	}

}
