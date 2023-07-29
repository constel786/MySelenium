package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day10_WriteExcel {
//    Create a new class: WriteExcel
//    Create a new method: writeExcel()
//    Store the path of the file as string and open the file
//    Open the workbook
//    Open the first worksheet
//    Go to the first row
//    Create a cell on the 3rd column (2nd index) on the first row
//    Write “POPULATION” on that cell
//    Create a cell on the 2nd row 3rd cell(index2), and write 150000
//    Create a cell on the 3rd row 3rd cell(index2), and write 250000
//    Create a cell on the 4th row 3rd cell(index2), and write 54000


    @Test
    public void writeExcel() throws IOException {
        String path = "resources/Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sheet1");

        //CellStyle cellStyle=null;
        //cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());

        Row row1 = sheet1.getRow(0);
        Cell r1c3 = row1.createCell(2);
        r1c3.setCellValue("POPULATION");

        Row row2 = sheet1.getRow(1);
        Cell r2c3 = row2.createCell(2);
        r2c3.setCellValue(150000);

        Row row3 = sheet1.getRow(2);
        Cell r3c3 = row3.createCell(2);
        r3c3.setCellValue(250000);

        Row row4 = sheet1.getRow(3);
        Cell r4c3 = row4.createCell(2);
        r4c3.setCellValue(54000);

//    Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
//    Close the files
        fileInputStream.close();
        fileOutputStream.close();
//    Close the workbook
        workbook.close();



    }

}
