package vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;

public class CreateOrgWithIndustryUsingDDT_GU {

	public static void main(String[] args) throws Throwable {
		
		//Create object of required Utilities
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
			WebDriver driver = null;
			
	  // Step1: read all the necessary data
			//read data from property file - Common Data
			
		String BROWSER	= pUtil.getDataFromPropertyFile("browser");
		String URL	= pUtil.getDataFromPropertyFile("url");
		String USERNAME	= pUtil.getDataFromPropertyFile("username");
		String PASSWORD	= pUtil.getDataFromPropertyFile("password");
		
			
			//Read Data from Excel sheet - Test data
			String ORGNAME = eUtil.readDataFromExcel("organization", 4, 2)+jutil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcel("organization", 4, 3);
		
		      //step2: Launch the browser - driver is acting based runtime data - RunTimepolymorphism
		      
		      if(BROWSER.equalsIgnoreCase("chrome")) {
		    	
		    	  driver = new ChromeDriver();
		    	  System.out.println(BROWSER+".....Browser launched");
		      }
		      else if (BROWSER.equalsIgnoreCase("firefox")) {
		    	  driver = new FirefoxDriver();
		    	  System.out.println(BROWSER+".....Browser launched");
		      }
		      else if (BROWSER.equalsIgnoreCase("edge")) {
		    	  driver = new EdgeDriver();
		    	  System.out.println(BROWSER+".....Browser launched");
		      }
		      else {
		    	  System.out.println("Invalid Browser name"); 
		      }
		      wUtil.maximizeWindow(driver);
		      wUtil.waitForElementsToLoad(driver);
		      
		      //step3: Load the URL
		      driver.get(URL);
		      
		      //step4: Login to the Application
		      driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click(); 
				
				// Step 5: Click on Organizations Link
				driver.findElement(By.linkText("Organizations")).click();

				// Step 6: click on Create Organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

				// Step 6: create Organization
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
				 // step6: choose 'Chemicals' in industry drop down
				WebElement industryDropDown = driver.findElement(By.name("industry"));
				wUtil.handleDropDown(industryDropDown, INDUSTRY);
				
			   //step7: save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			 // Step 8: Validate for Organization
			String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 if (OrgHeader.contains(ORGNAME)) {
					System.out.println("PASS");
					System.out.println(OrgHeader);
				} else {
				System.out.println("Fail");
					}  
		// step9: Logout of Application
						
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, AdminImg);
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("Logout successfull"); 
		}


}
