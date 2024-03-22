package objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	//Declaration 
	@FindBy(name="accountname")
    private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
    private WebElement IndustryDropDwn;
	
	//@FindBy(name="button")
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement SaveBtn;
	
	//initializations
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropdwn() {
		return IndustryDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//	Business Libraries
	/*
	 *This method will create organization with mandatory fields 
	 * @paramORGNAME
	 */
	public void createOrganization(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
		}
	
	/*
	 * This method will create organization with mandatory fields 
	 * @paramORGNAME
	 * @paramINDUSTRY
	 */
	public void createOrganization(String ORGNAME, String INDUSTRY) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDwn, INDUSTRY);
		SaveBtn.click();
	}
}
     