
package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel File
    public static void setExcelFile(String filePath, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read Data from Excel
    public static String getCellData(int row, int col) {
        Cell cell = sheet.getRow(row).getCell(col);
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        }
        return "";
    }

    // Get Row Count
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }
}
