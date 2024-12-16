package com.example.excelupload.controller;

import com.example.excelupload.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/excel")
public class ExcelUploadController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            // Check if the file is empty
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
            }

            // Process the Excel file and return data in JSON format
            List<Map<String, Object>> excelData = excelService.processExcelFile(file);

            // Return the parsed data in JSON format
            return ResponseEntity.ok(excelData);

        } catch (Exception e) {
            // Return error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the file: " + e.getMessage());
        }
    }
}
