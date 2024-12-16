package com.example.excelupload.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ExcelService {

    // Method to process the uploaded Excel file
    public List<Map<String, Object>> processExcelFile(MultipartFile file) {
        List<Map<String, Object>> excelData = new ArrayList<>(); // To store rows of data

        try {
            // Create a Workbook from the uploaded file
            Workbook workbook = new XSSFWorkbook(file.getInputStream());

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                Map<String, Object> rowData = new HashMap<>(); // To store each row data

                // Iterate through each cell in the current row
                for (Cell cell : row) {
                    String key = "Column-" + cell.getColumnIndex(); // Column index as key
                    Object value = getCellValue(cell); // Get cell value

                    // Print the value to the console
                    System.out.println("Cell Value at [" + row.getRowNum() + "," + cell.getColumnIndex() + "]: " + value);

                    rowData.put(key, value); // Add cell data to the row map
                }

                excelData.add(rowData); // Add row data to the list
            }

            // Close the workbook
            workbook.close();

        } catch (IOException e) {
            // Handle any I/O exceptions
            throw new RuntimeException("Failed to process Excel file: " + e.getMessage(), e);
        }
        return excelData; // Return parsed Excel data
    }

    // Helper method to extract cell value
    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING -> {
                return cell.getStringCellValue();
            }
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue(); // Date value
                } else {
                    return cell.getNumericCellValue(); // Numeric value
                }
            }
            case BOOLEAN -> {
                return cell.getBooleanCellValue();
            }
            default -> {
                return cell.toString(); // For other cell types
            }
        }
    }
}
