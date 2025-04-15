package generic_utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {

	/**
	 * 
	 */
	public String getExcelData(String SheetName,int rowNum,int cellNum)throws Throwable{

	

	// step1:- path connection
			FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

			// step2:-keeps the workbook/excelfile in read mode
			Workbook book = WorkbookFactory.create(fis1);

			// step3:- Navigating expected sheet
			Sheet sheet = book.getSheet(SheetName);

			// step4:- Navigating expected row--->row value starts from 0
			Row row = sheet.getRow(rowNum);

			// step5:- Navigating expected cell--->cell value starts from 0
			Cell cell = row.getCell(cellNum);

			String ExcelData = cell.getStringCellValue();
			System.out.println(ExcelData);
			return ExcelData;
		}

		public String getExcelDataUsingFormatter(String SheetName, int rowNum, int cellNum) throws Throwable {
			// step1:- path connection
			FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

			// step2:-keeps the workbook/excelfile in read mode
			Workbook book = WorkbookFactory.create(fis1);

			// step3:- Navigating expected sheet
			Sheet sheet = book.getSheet(SheetName);

			// step4:- Navigating expected row--->row value starts from 0
			Row row = sheet.getRow(rowNum);

			// step5:- Navigating expected cell--->cell value starts from 0
			Cell cell = row.getCell(cellNum);

			DataFormatter format = new DataFormatter();
			String ExcelData = format.formatCellValue(cell);

			return ExcelData;}}