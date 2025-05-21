

package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {
    static Workbook workbook;
    static Sheet sheet;

    public static void setExcelFile(String path, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).getNumericCellValue();
    }
}

//public static String getCellData(String path, String sheetName, int row, int col) {
//    try {
//        FileInputStream fis = new FileInputStream(path);
//        workbook = new XSSFWorkbook(fis);
//        sheet = workbook.getSheet(sheetName);
//        return sheet.getRow(row).getCell(col).getStringCellValue();
//    } catch (Exception e) {
//        e.printStackTrace();
//        return "";
//    }
//}
