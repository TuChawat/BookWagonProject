/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {
    XSSFWorkbook work_book;
    XSSFSheet sheet;

    public ReadExcelFile(String excelfilePath) {
        try {
            File s = new File(excelfilePath);
            FileInputStream stream = new FileInputStream(s);
            work_book = new XSSFWorkbook(stream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int i, int row, int column) {
        sheet = work_book.getSheetAt(0);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex) {
        int row = work_book.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }
}
