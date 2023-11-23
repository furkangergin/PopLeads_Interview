package com.popLeads.utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelHelper {

    public static String getUsername() {

        String result = null;

        String path = "src/test/resources/PopLeads.xlsx";
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(path);
            XSSFSheet sheet = workbook.getSheet("User");
            XSSFCell cell = sheet.getRow(1).getCell(0);
            result = "" + cell;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getPassword() {

        String result = null;

        String path = "src/test/resources/PopLeads.xlsx";
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(path);
            XSSFSheet sheet = workbook.getSheet("User");
            XSSFCell cell = sheet.getRow(1).getCell(1);
            result = "" + cell;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void writeExcel(String testResult) {
        try {

            String path = "src/test/resources/Result.xlsx";
            OutputStream fileOut = new FileOutputStream(path);
            Workbook workbook = new XSSFWorkbook();
            workbook.write(fileOut);
            Sheet sheet = workbook.createSheet("TestResult");
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue(testResult);

            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
