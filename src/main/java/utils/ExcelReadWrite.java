package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelReadWrite {

	HSSFWorkbook workbook;
	FileInputStream fis;
	
	public ExcelReadWrite(String filepath) throws IOException
	{
		fis = new FileInputStream(filepath);
		workbook = new HSSFWorkbook(fis);
	}
	
	public HSSFSheet setSheet(String sheetName)
	{
		HSSFSheet sheet = workbook.getSheet(sheetName);
		return sheet;
	}
	
	public int rowCount(HSSFSheet sheet)
	{
		int rowNum = sheet.getLastRowNum();
		return rowNum;
	}
	
	public int colCount(HSSFSheet sheet,int rowIndex)
	{
		int cellNum = sheet.getRow(rowIndex).getLastCellNum();
		return cellNum;
	}
	
	public String readValue(HSSFSheet sheet,int rowIndex,int colIndex)
	{
		HSSFCell cell = sheet.getRow(rowIndex).getCell(colIndex);
		
		String cellValue="";
		
		if(cell==null)
			cell = sheet.getRow(rowIndex).createCell(colIndex);
		
		else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			cellValue = "-";
		
		else if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			cellValue = cell.getStringCellValue();
		
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		 cellValue = String.valueOf(cell.getNumericCellValue());
		
		return cellValue;
	}
	
	public String readValue(HSSFSheet sheet,int rowIndex,String colName)
	{
		int colIndex=0;
		
		for(int i=0;i<sheet.getRow(0).getLastCellNum();i++)
		{
			if(sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
				colIndex=i;
		}
		
		return readValue(sheet,rowIndex,colIndex);
	}
	
	public void writeValue(HSSFSheet sheet,int rowIndex,int colIndex,String writeValue)
	{
		HSSFCell cell = sheet.getRow(rowIndex).getCell(colIndex);
		
		if(cell==null)
		{
			cell = sheet.getRow(rowIndex).createCell(colIndex);
		}
		
		cell.setCellValue(writeValue);
	}
	
	public void writeValue(HSSFSheet sheet,int rowIndex,String colName,String writeValue)
	{
        int colIndex=0;
		
		for(int i=0;i<sheet.getRow(0).getLastCellNum();i++)
		{
			if(sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
				colIndex=i;
		}
		
		writeValue(sheet,rowIndex,colIndex,writeValue);
		
	}
	
	public void saveExcel(String filepath) throws IOException
	{
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(filepath);
		workbook.write(fos);
		
		fos.close();
	}
	
	
}
