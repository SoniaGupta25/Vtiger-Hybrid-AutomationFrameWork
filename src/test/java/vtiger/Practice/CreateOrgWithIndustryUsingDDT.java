package vtiger.Practice;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustryUsingDDT {


	public static void main(String[] args) throws Throwable {
		
		Random r = new Random();
		int random = r.nextInt(10000);
		      
  // Step1: read all the necessary data
		//read data from property file - common Data
		FileInputStream fisp= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fisp);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		//Read Data from Excel sheet - Test data
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\VtigerTestData.xlsx");
	      Workbook wb	= WorkbookFactory.create(fise);
	     Sheet sh = wb.getSheet("organization");
	       String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue() + random;
	      String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
	      
	      WebDriver driver=null;
	      //step2: Launch the browser - driver is acting based runtime data - RunTimepolymorphism
	     
	      if(BROWSER.equalsIgnoreCase("edge")) {
	    	 // WebDriverManager.chromedriver().setup();
	    	  driver = new EdgeDriver();
	    	  System.out.println(BROWSER+".....Browser launched");
	      }
	      else if (BROWSER.equalsIgnoreCase("firefox")) {
	    	 // WebDriverManager.firefoxdriver().setup();
	    	  driver = new FirefoxDriver();
	    	  System.out.println(BROWSER+".....Browser launched");
	      }
	      else if (BROWSER.equalsIgnoreCase("chrome")) {
	    	  driver = new ChromeDriver();
	    	  System.out.println(BROWSER+".....Browser launched");
	      }
	      else {
	    	  System.out.println("Invalid Browser name"); 
	      }     
	      driver.manage().window().maximize();   
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      
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
		Select s = new Select(industryDropDown);
		s.selectByValue(INDUSTRY);
		
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
	Actions act	= new Actions(driver); 
			act.moveToElement(AdminImg).perform();
			
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout successfull");
		
		}

}
