package objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
    

	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportuntiesLink;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization 

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportuntiesLink() {
		return OpportuntiesLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	// Business Library
	//This method will click on Organizations link
	public void clickonOrgLink() {
		OrganizationsLink.click();
	}
	
	// This method will click on contacts link
	public void clickonContactsLink() {
		ContactsLink.click();
	}
	
	/*
	 * This method will logout of application
	 *@param driver 
	 * @throws Throwable
	 */
	public void logoutOfApp(WebDriver driver) throws Throwable {
		mouseHoverAction(driver, AdministratorImg);
		Thread.sleep(2000);
		SignOutLink.click();
		
	}
 }
	      
//whenever you want any WebDriver related action extends web driver utility for eg mouse hover actions

  

