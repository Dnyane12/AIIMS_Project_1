
package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static List<String> readColumnData(String filePath, String columnName) {
        List<String> columnData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // assuming first sheet
            Row headerRow = sheet.getRow(0);
            int columnIndex = -1;

            // Find column index by name
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName)) {
                    columnIndex = cell.getColumnIndex();
                    break;
                }
            }

            if (columnIndex == -1) {
                throw new RuntimeException("Column '" + columnName + "' not found.");
            }

            // Read all rows in that column (excluding header)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(columnIndex);
                    if (cell != null) {
                        columnData.add(getCellValueAsString(cell));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return columnData;
    }

    private static String getCellValueAsString(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }
}
