#!/usr/bin/java --source 12 --class-path /Users/dhval/project/jar/poi-3.16/lib/*

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

/**
 * CLASSPATH=/Users/dhval/project/jar/poi-3.16/lib/* jshell
 * https://www.dev2qa.com/convert-excel-to-json-in-java-example/

1. commons-beanutils-1.8.3.jar => https://repo1.maven.org/maven2/commons-beanutils/commons-beanutils/1.8.3/commons-beanutils-1.8.3.jar
2. ezmorph-1.0.6.jar => https://repo1.maven.org/maven2/net/sf/ezmorph/ezmorph/1.0.6/ezmorph-1.0.6.jar
3. commons-collections-3.2.1.jar => https://repo1.maven.org/maven2/commons-collections/commons-collections/3.2.1/commons-collections-3.2.1.jar
4. commons-lang-2.6.jar => https://repo1.maven.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.jar
5. json-lib-2.4-jdk15.jar =>https://repo1.maven.org/maven2/net/sf/json-lib/json-lib/2.4/json-lib-2.4-jdk15.jar
6. poi-bin-3.16-20170419.zip  => https://archive.apache.org/dist/poi/release/bin/poi-bin-3.16-20170419.zip

 */

public class ReadExcelToJson {
    // Column list, ignore all other columns.
    static String[] columns = new String[] {"BusinessName", "BusinessDescription", "BusinessAddress1", "BusinessAddress2", "BusinessCity", "BusinessZip", "BusinessCounty", "ContactFirstName", "ContactLastName", "ContactPhone", "Response"};
    static Set<String> colSet = new HashSet<>(Arrays.asList(columns));
    // Map column names, better & shorter name means less space as well  
    static Map<String, String> map = Stream.of(
            new AbstractMap.SimpleEntry<>("BusinessName", "business"),
            new AbstractMap.SimpleEntry<>("BusinessDescription", "description"),
            new AbstractMap.SimpleEntry<>("ContactLastName", "last"),
            new AbstractMap.SimpleEntry<>("ContactFirstName", "first"),
            new AbstractMap.SimpleEntry<>("BusinessZip", "zip"),
            new AbstractMap.SimpleEntry<>("BusinessCounty", "county"),
            new AbstractMap.SimpleEntry<>("BusinessCity", "city"),
            new AbstractMap.SimpleEntry<>("Response", "response"),
            new AbstractMap.SimpleEntry<>("ContactPhone", "phone"),
            new AbstractMap.SimpleEntry<>("BusinessAddress2", "address2"),
            new AbstractMap.SimpleEntry<>("BusinessAddress1", "address1")
    ).collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue()));


    public static void main(String[] args)
    {
        // You can specify your excel file path.
        String excelFilePath = "/Users/dhval/project/xml-modules/jshell/tmp/20200325.xls";

        // This method will read each sheet data from above excel file and create a JSON and a text file to save the sheet data.
        creteJSONAndTextFileFromExcel(excelFilePath);
    }


    /* Read data from an excel file and output each sheet data to a json file and a text file.
     * filePath :  The excel file store path.
     * */
    private static void creteJSONAndTextFileFromExcel(String filePath)
    {
        try{
            /* First need to open the file. */
            FileInputStream fInputStream = new FileInputStream(filePath.trim());

            /* Create the workbook object to access excel file. */
            //Workbook excelWookBook = new XSSFWorkbook(fInputStream)
            /* Because this example use .xls excel file format, so it should use HSSFWorkbook class. For .xlsx format excel file use XSSFWorkbook class.*/;
            Workbook excelWorkBook = new HSSFWorkbook(fInputStream);

            // Get all excel sheet count.
            int totalSheetNumber = excelWorkBook.getNumberOfSheets();

            // Loop in all excel sheet.
            for(int i=0;i<totalSheetNumber;i++)
            {
                // Get current sheet.
                Sheet sheet = excelWorkBook.getSheetAt(i);

                // Get sheet name.
                String sheetName = sheet.getSheetName();

                if(sheetName != null && sheetName.length() > 0)
                {
                    // Get current sheet data in a list table.
                    List<List<String>> sheetDataTable = getSheetDataList(sheet);

                    // Generate JSON format of above sheet data and write to a JSON file.
                    String jsonString = getJSONStringFromList(sheetDataTable);
                    String jsonFileName = sheet.getSheetName() + ".json";
                    writeStringToFile(jsonString, jsonFileName);

                    // Generate text table format of above sheet data and write to a text file.
                    String textTableString = getTextTableStringFromList(sheetDataTable);
                    String textTableFileName = sheet.getSheetName() + ".txt";
                    writeStringToFile(textTableString, textTableFileName);

                }
            }
            // Close excel work book object.
            excelWorkBook.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }


    /* Return sheet data in a two dimensional list.
     * Each element in the outer list is represent a row,
     * each element in the inner list represent a column.
     * The first row is the column name row.*/
    private static List<List<String>> getSheetDataList(Sheet sheet)
    {
        List<List<String>> ret = new ArrayList<List<String>>();

        // Get the first and last sheet row number.
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();

        if(lastRowNum > 0)
        {
            // Loop in sheet rows.
            for(int i=firstRowNum; i<lastRowNum + 1; i++)
            {
                // Get current row object.
                Row row = sheet.getRow(i);

                // Get first and last cell number.
                int firstCellNum = row.getFirstCellNum();
                int lastCellNum = row.getLastCellNum();

                // Create a String list to save column data in a row.
                List<String> rowDataList = new ArrayList<String>();

                // Loop in the row cells.
                for(int j = firstCellNum; j < lastCellNum; j++)
                {
                    // Get current cell.
                    Cell cell = row.getCell(j);

                    // Get cell type.
                    int cellType = cell.getCellType();

                    if(cellType == CellType.NUMERIC.getCode())
                    {
                        double numberValue = cell.getNumericCellValue();

                        // BigDecimal is used to avoid double value is counted use Scientific counting method.
                        // For example the original double variable value is 12345678, but jdk translated the value to 1.2345678E7.
                        String stringCellValue = BigDecimal.valueOf(numberValue).toPlainString();

                        rowDataList.add(stringCellValue);

                    }else if(cellType == CellType.STRING.getCode())
                    {
                        String cellValue = cell.getStringCellValue();
                        rowDataList.add(cellValue);
                    }else if(cellType == CellType.BOOLEAN.getCode())
                    {
                        boolean numberValue = cell.getBooleanCellValue();

                        String stringCellValue = String.valueOf(numberValue);

                        rowDataList.add(stringCellValue);

                    }else if(cellType == CellType.BLANK.getCode())
                    {
                        rowDataList.add("");
                    }
                }

                // Add current row data list in the return list.
                ret.add(rowDataList);
            }
        }
        return ret;
    }

    /* Return a JSON string from the string list. */
    private static String getJSONStringFromList(List<List<String>> dataTable)
    {
        String ret = "";

        if(dataTable != null)
        {
            int rowCount = dataTable.size();

            if(rowCount > 1)
            {
                // Create a JSONArray or JSONObject to store table data.
                JSONArray tableJSONArray = new JSONArray();
            //    JSONObject tableJsonObject = new JSONObject();

                // The first row is the header row, store each column name.
                List<String> headerRow = dataTable.get(0);

                int columnCount = headerRow.size();

                // Loop in the row data list.
                for(int i=1; i<rowCount; i++)
                {
                    // Get current row data.
                    List<String> dataRow = dataTable.get(i);

                    // Create a JSONObject object to store row data.
                    JSONObject rowJsonObject = new JSONObject();

                    for(int j=0;j<columnCount;j++)
                    {
                        String columnName = headerRow.get(j);
                        String columnValue = dataRow.get(j);

                        if (colSet.contains(columnName)) {
                            String s =  columnValue.replaceAll("\\W+", " ");
                            rowJsonObject.put(map.get(columnName),s.substring(0, Math.min(s.length(), 100)));
                        }
                    }

                    //tableJsonObject.put("Row " + i, rowJsonObject);
                    rowJsonObject.put("id", ""+i);
                    tableJSONArray.add(rowJsonObject);
                }

                // Return string format data of JSONObject object.
               // ret = tableJsonObject.toString();
                ret = tableJSONArray.toString();

            }
        }
        return ret;
    }


    /* Return a text table string from the string list. */
    private static String getTextTableStringFromList(List<List<String>> dataTable)
    {
        StringBuffer strBuf = new StringBuffer();

        if(dataTable != null)
        {
            // Get all row count.
            int rowCount = dataTable.size();

            // Loop in the all rows.
            for(int i=0;i<rowCount;i++)
            {
                // Get each row.
                List<String> row = dataTable.get(i);

                // Get one row column count.
                int columnCount = row.size();

                // Loop in the row columns.
                for(int j=0;j<columnCount;j++)
                {
                    // Get column value.
                    String column = row.get(j);

                    // Append column value and a white space to separate value.
                    strBuf.append(column);
                    strBuf.append("    ");
                }

                // Add a return character at the end of the row.
                strBuf.append("\r\n");
            }

        }
        return strBuf.toString();
    }

    /* Write string data to a file.*/
    private static void writeStringToFile(String data, String fileName)
    {
        try
        {
            // Get current executing class working directory.
            String currentWorkingFolder = System.getProperty("user.dir");

            // Get file path separator.
            String filePathSeperator = System.getProperty("file.separator");

            // Get the output file absolute path.
            String filePath = currentWorkingFolder + filePathSeperator + fileName;

            // Create File, FileWriter and BufferedWriter object.
            File file = new File(filePath);

            FileWriter fw = new FileWriter(file);

            BufferedWriter buffWriter = new BufferedWriter(fw);

            // Write string data to the output file, flush and close the buffered writer object.
            buffWriter.write(data);

            buffWriter.flush();

            buffWriter.close();

            System.out.println(filePath + " has been created.");

        }catch(IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}