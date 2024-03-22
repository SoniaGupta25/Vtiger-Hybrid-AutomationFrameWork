package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


   //Rule1: create a seperate pom class for every web page
	
	// Rule2: Identifying the web element using @FindBy @FindAll and @FindBys
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passWordEdt;
	
	@FindBy(id = "submitbutton")
	private WebElement loginBtn;
	
	// Rule3: Create a constructor to initialize the web elements
	 public LoginPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }

	 //Rule4: provide getters to access these web element
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passWordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	 
	// Business Library - project specific generic method
	/*
	 * this method will perform login operation
	 * @paramUSERNAME
	 * @paramPASSWORD
	 */
	
	public void loginToApp(String USERNAME, String PASSWORD) {
		userNameEdt.sendKeys(USERNAME);
		passWordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
 }


