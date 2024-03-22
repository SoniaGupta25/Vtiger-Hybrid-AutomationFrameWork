package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step1: Open the doc in java readable format
		FileInputStream fisw = new FileInputStream(".\\src\\test\\resources\\VtigerTestData.xlsx");
		
		//Step 2: Create workbook
		Workbook wb = WorkbookFactory.create(fisw);
		
        //Step 3: Create to required sheet
		Sheet sh = wb.createSheet("IndustryName");  //String sheetName
		
		//Step 4: Create to required row
		Row rw =  sh.createRow(1);          // int rowNo 
		
		//Step 5: Create to required cell
		Cell cl =  rw.createCell(2);     //int celNo
		
		//Step 6: Set the value and print
		 cl.setCellValue("data");   //String data
		
     FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\VtigerTestData.xlsx");
       wb.write(fos);
        wb.close();
	}


}
