package vtiger.Practice;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

public static void main(String[] args) throws Throwable {
		
		JavaUtility jutil = new JavaUtility();
		
	int r =	jutil.getRandomNumber();
	System.out.println(r);
	
	String date = jutil.getSystemDate();
	System.out.println(date);
	//System.out.println(jutil.getSystemDate());
	

	
	PropertyFileUtility pUtil = new PropertyFileUtility();
	
     String value1 = pUtil.getDataFromPropertyFile("password");
	    System.out.println(value1);
	    
	    
		String value11 = pUtil.getDataFromPropertyFile("username");
		System.out.println(value11);
		
		String Browser = pUtil.getDataFromPropertyFile("browser");
		System.out.println(Browser);
	    
	    ExcelFileUtility eUtil = new ExcelFileUtility();
	    
	   String data = eUtil.readDataFromExcel("organization", 2, 3);
	   System.out.println(data);
}
}
	   
	//   eUtil.writeDataIntoExcel("sample", 3, 4, "BatMan");
	//   System.out.println("data added");
	   //run as Java application
	   


