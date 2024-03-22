package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

@Listeners(genericUtilities.ListenerImplementationClass.class)
public class CreateContactTest extends BaseClass{


	@Test(groups = "SmokeSuite")
	public void createContact() throws EncryptedDocumentException, IOException {
		
		String LASTNAME = eUtil.readDataFromExcel("contact", 1, 2);
		
		// Step 10: Click On Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickonContactsLink();
		Reporter.log("Clicked on Contacts Link");

		// Step 11: Click on Create contact Look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("clicked create contact look up image");

		
		// Step 12: Create Contact with last name
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("Contact created successfully");

		// Step 13: Validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getHeaderText();
		Reporter.log("Header captured");
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		Reporter.log("Header valiadated");
		
		System.out.println(contactHeader);
	}
	
	@Test
	public void demotest()
	{
		Assert.fail();
		System.out.println("demo");
	}
}             
                           	         
