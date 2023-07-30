package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Day10_ReadExcel {
//    Import the apache POI dependency in your pom file
//    Create resources directory under project
//    Add the Excel file on the resources folder
//    Create a new class: ReadExcel
//    Create a new test method: readExcel()
    @Test
    public void readExcel() throws IOException {
        //workbook > worksheet > row > cell
//    Store the path of the  file in a string
        String path = "resources/Capitals.xlsx";
//    Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
//    Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//    Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");
    //OR alternatively
    //  workbook.getSheetAt(0);
//    Go to first row
        Row row1 = sheet1.getRow(0);
//    Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);
        System.out.println("row1 cell1 = " + cell1);
        String cell1String = cell1.toString();
        System.out.println("row1 cell1 as String = " + cell1String);
//    Go to second cell on that first row and print
        String row1Cell2 = sheet1.getRow(0).getCell(1).toString(); //Chaining the methods
        System.out.println("row1 Cell2 = " + row1Cell2);
        Assert.assertTrue(row1Cell2.equals("CAPITAL"));
//    Go to 2nd row first cell and assert if the data equal to USA
        String row2Cell1 = sheet1.getRow(1).getCell(0).toString();
        System.out.println("row2 Cell1 = " + row2Cell1);
        Assert.assertEquals("Expected is not equal to USA", "USA", row2Cell1);
//    Go to 3rd row 2nd cell-chain the row and cell
        String row3Cell2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println("row3 Cell2 = " + row3Cell2);
        Assert.assertEquals("Paris", row3Cell2);
//    Find the number of rows
        int totalRowCount = sheet1.getLastRowNum()+1; //index starts at 0
        System.out.println("totalRowCount = " + totalRowCount);
//    Find the number of used rows
        int usedRowCount = sheet1.getPhysicalNumberOfRows(); //returns number of used rows
        System.out.println("usedRowCount = " + usedRowCount);

//    HOMEWORK: Print country, capital key value pairs as map object()
    //Use a loop to add key value pairs in the Map using the pattern of indexes

        //List<WebElement>
        //for (rowNumber
        //String countries = sheet1.getRow(rowNumber).getCell(0).toString();
        //String capitals = sheet1.getRow(rowNumber).getCell(1).toString();

    //add this to Map and print
        //Map pairs = countries+capitals;
        //System.out.println("pairs = " + pairs);
}
}