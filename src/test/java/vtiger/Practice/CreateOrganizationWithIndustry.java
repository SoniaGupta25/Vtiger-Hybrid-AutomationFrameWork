package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CreateOrganizationWithIndustry {
   
public static void main(String[] args) {
		
		Random r = new Random();
		int random = r.nextInt();
		
		//step 1: Launch the browser
		//WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2: Load the URL
		driver.get("http://localhost:8888");
		
		//step 3: Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step 4: Click on Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		
		// step 5: click on create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 6: create Organization
		String OrgName = "L&T"+random;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		 // step7: choose 'Chemicals' in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropDown);
		s.selectByValue("Chemicals");
		
	   //step7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	   // Step 8: Validate for Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (OrgHeader.contains(OrgName)) {
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
   