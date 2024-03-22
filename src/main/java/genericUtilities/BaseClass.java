package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all the basic configuration annotations for 
 * all the common actions
 * @author Sonia 
 *
 */

public class BaseClass {
    
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;
	
	//only used for Listeners to take screenshot
	public static WebDriver sdriver; 
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("---- DB Connection Successful ----");
	}

	//@Parameters("browser") //hold a value
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable {
		
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
		
			driver = new EdgeDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else {
			System.out.println("Invalid Browser Name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		
		//used in Listeners
		sdriver=driver;

		driver.get(URL);
	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable {
		
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("---- Login Successful ----");
	}

	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("---- Logout Successful ----");

	}

	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		
		driver.quit();
		System.out.println("---- Browser Closed ----");

	}

	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("---- DB Connection Closed ----");
	}
}   
         


