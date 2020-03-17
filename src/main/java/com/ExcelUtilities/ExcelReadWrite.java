package com.ExcelUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.BaseClass.WrapperClass;


public class ExcelReadWrite extends WrapperClass {
	FileInputStream in;
	FileOutputStream out;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFFont font;
	Row row;
	Cell cell;
	String path=WrapperClass.srcPath+"\\test\\resources\\com\\ExcelData\\ExcelData.xlsx";

	public XSSFCellStyle fontSetterred(){// create font
        font= wb.createFont();
        font.setFontHeightInPoints((short)10);
        font.setFontName("Calibri");
        font.setColor(IndexedColors.RED.getIndex());
        font.setBold(true);
        font.setItalic(false);
                                    
         // Create cell style 
        XSSFCellStyle style=wb.createCellStyle();
        style.setFont(font);
        return style;
	}
	public XSSFCellStyle fontSettergreen(){// create font
        font= wb.createFont();
        font.setFontHeightInPoints((short)10);
        font.setFontName("Calibri");
        font.setColor(IndexedColors.GREEN.getIndex());
        font.setBold(true);
        font.setItalic(false);
                                    
         // Create cell style 
        XSSFCellStyle style=wb.createCellStyle();
        style.setFont(font);
        return style;
	}
	public String ExcelRead(String sheetName,int rowNum, int cellNum) throws IOException {
		in = new FileInputStream(new File(path));
		wb = new XSSFWorkbook(in);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String val = cell.getStringCellValue();
		wb.close();
		in.close();
		return val;
	}
	
	public int ExcelRowLength(String sheetName) throws IOException {
		in = new FileInputStream(new File(path));
		wb = new XSSFWorkbook(in);
		sheet = wb.getSheet(sheetName);
		int val = sheet.getLastRowNum();
		wb.close();
		in.close();
		return val;
	}

	public void ExcelWrite(String sheetName,int rowNum,int cellNum, String value) throws IOException{
        File file = new File(path);
        //System.out.println("Writing to excel file...");
		try {
			in = new FileInputStream(file);
			wb = new XSSFWorkbook(in);
			try {
				sheet = wb.getSheet(sheetName);
			} catch (Exception e) {
		         sheet = wb.createSheet(sheetName);
			}
			try {
				if(sheet.getLastRowNum()<rowNum) {
					row = sheet.createRow(rowNum);
				}
				else {
					row = sheet.getRow(rowNum);
				}
			} catch (Exception e) {
//				row = sheet.getRow(rowNum);
			}
			try {
				row.getCell(cellNum).setCellValue(value);
			} catch (Exception e) {
				row.createCell(cellNum);
				row.getCell(cellNum).setCellValue(value);
			}
			if(value.equalsIgnoreCase("pass")) {
				XSSFCellStyle style = fontSettergreen();
				row.getCell(cellNum).setCellStyle(style);
			}
			if(value.equalsIgnoreCase("fail")) {
				XSSFCellStyle style = fontSetterred();
				row.getCell(cellNum).setCellStyle(style);
			}
	        try {
	        	out = new FileOutputStream(file);
	        	wb.write(out);
	    		wb.close();
	    		out.close();
	    		System.out.println("File saved");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		} catch (Exception e) {
		}

    }
	
}
