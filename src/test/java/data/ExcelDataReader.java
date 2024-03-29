package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	static FileInputStream fis = null;
	
	public FileInputStream fileReader() {
	String filePath = System.getProperty("user.dir")+"/src/test/java/data/document.xlsx";
	File srcfile = new File(filePath);
	try {
		fis = new FileInputStream(srcfile);
	} catch (FileNotFoundException e) {
		System.out.println("Error Occured : "+ e.getMessage());
	}
	return fis;
	}
	
	public Object [][] GetExcelUserData() throws IOException{
		try {
		fis = fileReader();
		}
		catch(NullPointerException e){
			System.out.println("file is Empty !"+e.getMessage());
		}
		XSSFWorkbook workB = new XSSFWorkbook(fis);
		XSSFSheet workSheet = workB.getSheetAt(0);
		int totalNumOfRows = workSheet.getLastRowNum()+1;
		int totalNumOfCols = 4;
		String [][] data = new String [totalNumOfRows][totalNumOfCols];
		for (int i = 0; i < totalNumOfRows; i++) {
			for (int j = 0; j < totalNumOfCols; j++) {
				XSSFRow row = workSheet.getRow(i);
				data[i][j] = row.getCell(j).toString();
			}
		}
		workB.close();
		return data;
	}
}
