package utils;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtils;

public class TestDataProvider {
    @DataProvider(name = "LoginData")
    public static Object[][] getLoginData() {
        String filePath = "D:/TestNG/TestNG/src/test/resources/TestData.xlsx";  // Path to your Excel file
        String sheetName = "Login sheet";  // Sheet name in Excel
        

        ExcelUtils.setExcelFile(filePath, sheetName);
        int rowCount = ExcelUtils.getRowCount();

        Object[][] data = new Object[rowCount - 1][2]; // Assuming 2 columns: Phone, Password

        for (int i = 1; i < rowCount; i++) { // Start from 1 (skip header)
            data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Phone number
            data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
        }
        return data;
    }
}
