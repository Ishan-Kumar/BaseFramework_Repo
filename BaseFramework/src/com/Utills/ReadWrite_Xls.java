package com.Utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadWrite_Xls 
{


	public String path;
	public FileInputStream inputStream;
	public FileOutputStream outputStream;
	public Workbook workbook = null ;
	public File file ;
	public Cell cell;
	public Row row;

	/* ReadWrite_Xls(String path) Constructor specification :-
 	1) Specify the path of the xls file and set a file input stream with the file.
 	2) path -> Path of the xls file 
	3) FileInputStream -> To take input from specified xls file.
	 */

	public ReadWrite_Xls(String excelFilePath)
	{
		path=excelFilePath;
		try 
		{
			if (excelFilePath.endsWith("xlsx")) {
				inputStream = new FileInputStream(path);
				workbook = new XSSFWorkbook(inputStream);
			} else if (excelFilePath.endsWith("xls")) {
				inputStream = new FileInputStream(path);
				workbook = new HSSFWorkbook(inputStream);
			} else {
				throw new IllegalArgumentException("The specified file is not Excel file");
			}

			//#######
			//inputStream = new FileInputStream(path);
			//workbook = new HSSFWorkbook(inputStream);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	/*   
	 * isSheetExist(String sheetName) method specification :-
	 * Returns boolean value if the sheet is present in current workbook or not
	 */
	public boolean isSheetExist(String sheetName)
	{

		if(workbook.getSheet(sheetName) == null)
		{
			return false ;
		}else
			return true;

	}

	/*   
	 * getRowCount(String sheetName) method specification :-
	 * Return total number of rows in specified excel sheet.
	 * sheetName -> name of the excel sheet. 
	 * Workbook -> Refer to the whole xls file.
	 * objSheet -> Refer to an individual sheet within that workbook.
	 */

	public int getRowCount(String sheetName)
	{
		workbook.getSheet(sheetName);
		Sheet objSheet = workbook.getSheet(sheetName);
		int rowCount = objSheet.getLastRowNum() - objSheet.getFirstRowNum();		
		return rowCount+1;
	}

	/*   
	 * getCellData(String sheetName, int rowNum, int colNum) method specification :-
	 *  Return Data inside a particular cell
	 *  sheetName -> name of the excel sheet. 
	 *  rowNum -> Refer to the Row Number in xls file
	 *  colNum -> Refer to the Col Number in xls file
	 */

	public String getCellData(String sheetName, int rowNum, int colNum)
	{
		Sheet objSheet = workbook.getSheet(sheetName);
		row = objSheet.getRow(rowNum);
		return row.getCell(colNum).getStringCellValue();
	}	


	/*   
	 * getColumnData(String sheetName, String colName) method specification :-
	 * This function will return Data of a particular column, this function assumes that
	 * column heading is at row0, col0. Function requires
	 * sheetName -> name of the excel sheet. 
	 * colName -> Refer to the Name of the column for which data is required
	 */

	public ArrayList<String> getColumnData(String sheetName, String colName)
	{
		Sheet objSheet = workbook.getSheet(sheetName);
		int rowCount = objSheet.getLastRowNum() - objSheet.getFirstRowNum();
		int colIndex = 0;
		ArrayList<String> columnData = new ArrayList<String>();
		row = objSheet.getRow(0);

		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().equalsIgnoreCase(colName))
			{
				colIndex= row.getCell(i).getColumnIndex();
			}
		}		
		for(int i=1;i<rowCount+1;i++)
		{
			row = objSheet.getRow(i);
			columnData.add(row.getCell(colIndex).getStringCellValue());		
		}
		return columnData;
	}


	/*   
	 * Public int readSheet(String sheetName) method specification :-
	 * Print Sheet data in console
	 * sheetName -> name of the excel sheet. 
	 */

	public void printSheet(String sheetName)
	{

		Sheet objSheet = workbook.getSheet(sheetName);

		int rowCount = objSheet.getLastRowNum() - objSheet.getFirstRowNum();

		// Create a loop over all the rows of excel file
		for(int i = 0; i< rowCount+1; i++)
		{
			row = objSheet.getRow(i);			
			for(int j=0; j < row.getLastCellNum();j++)
			{
				System.out.print(row.getCell(j).getStringCellValue() + " | "); 
			}
			System.out.println();
		}	
	}

	
	/*   
	 * setCellData(String sheetName, String colName, int rowNum, String status) method specification :-
	 * @sheetName -> name of the excel sheet. 
	 * #colName -> Refer to the ColumnHeader in xls file
	 * @rowNUM -> Refer to the rowNumber Number in xls file
	 * @inputValue -> Input Value for the cell
	 * */

public void setCellData(String sheetName, String colName, int rowNum, String inputValue) 
{
	Sheet objSheet = workbook.getSheet(sheetName);
	row = objSheet.getRow(0);
	int colIndex =0;

	for(int i=0;i<row.getLastCellNum();i++)
	{
		if(row.getCell(i).getStringCellValue().equalsIgnoreCase(colName))
		{
			colIndex= row.getCell(i).getColumnIndex();
		}
	}

	objSheet.getRow(rowNum).createCell(colIndex).setCellValue(inputValue);
	try 
	{
		outputStream = new FileOutputStream(path);
		workbook.write(outputStream);			
		outputStream.close();
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
}



}
