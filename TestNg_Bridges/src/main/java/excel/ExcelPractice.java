package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPractice {

	static String filePath = "C:\\Users\\neil.bridges\\Desktop\\misc\\practiceScripts\\ReadWritePractice.xlsx";
	
	static String data = "This is a test"; 
	int sheet;
	int row; 
	int column;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExcelPractice.excelWrite(filePath, data, 0, 0, 0);
		ExcelPractice.excelRead(filePath, 0, 0, 0);;
		
	}

	public static void excelWrite(String filePath, String data, int sheet, int row, int column) throws Exception{
        
        try {
               FileInputStream inputStream = new FileInputStream(new File(filePath));
               XSSFWorkbook WB1 = new XSSFWorkbook(inputStream);                
               XSSFSheet S1 = WB1.getSheetAt(sheet);
               Cell C1 = null;
               Row R1 = S1.getRow(row);
               if(R1 == null) {
                      R1 = S1.createRow(row);
               }
               C1 = R1.getCell(column);
               if(C1 == null) {
                      C1 = R1.createCell(column);                          
               }
               C1.setCellValue(data);
               inputStream.close();
               FileOutputStream output = new FileOutputStream(filePath);
               WB1.write(output);
      //         WB1.close();
               output.close();
               System.out.println("All done");
        } catch (IOException| EncryptedDocumentException ex){
               ((Throwable) ex).printStackTrace();
        }
        
        
  }


	public static void excelRead(String filePath, int sheet, int row, int column) throws Exception {
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			XSSFWorkbook WB1 = new XSSFWorkbook(inputStream);
			XSSFSheet S1 = WB1.getSheetAt(sheet);
			
			int rowCount = S1.getLastRowNum() - S1.getFirstRowNum();
			

			for (int i = 0; i < rowCount + 1; i++) {

				Row R1 = S1.getRow(i);

				// Create a loop to print cell values in a row

				for (int j = 0; j < R1.getLastCellNum(); j++) {

					// Print Excel data in console

					System.out.print(R1.getCell(j).getStringCellValue() + " | ");

				}

				System.out.println();
			}
			
			
			inputStream.close();

		} catch (IOException | EncryptedDocumentException ex) {
			((Throwable) ex).printStackTrace();
		}
		
	}
	
	
	

	

}
