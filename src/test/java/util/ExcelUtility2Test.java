package util;

public class ExcelUtility2Test {
	
	public static void main(String[] args) {
		
		String excelPath = "./dataFolder/TestData.xlsx";
		String sheetName = "Sheet1";
		
		ExcelUtility2 excel = new ExcelUtility2(excelPath, sheetName);
		excel.getRowCount();
		excel.getCellData(1, 1);
	}

}
