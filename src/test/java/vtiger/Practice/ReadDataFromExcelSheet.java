package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {


	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step1: Open the doc in java readable format
		FileInputStream fiss = new FileInputStream(".\\src\\test\\resources\\VtigerTestData.xlsx");
		
		//Step 2: Create workbook
		Workbook wb = WorkbookFactory.create(fiss);
		
        //Step 3: Navigate to required sheet
		Sheet sh = wb.getSheet("contact");
		
		//Step 4: navigate to required row
		Row rw =  sh.getRow(1);
		
		//Step 5: navigate to required cell
		Cell cl = (Cell) rw.getCell(2);
		
		//Step 6: Capture the value and print
		String value =   cl.getStringCellValue();
		System.out.println(value);


}

}
