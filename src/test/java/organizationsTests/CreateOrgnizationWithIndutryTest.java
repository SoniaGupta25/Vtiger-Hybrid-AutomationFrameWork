package organizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

public class CreateOrgnizationWithIndutryTest extends BaseClass {

	@Test
	public void createOrgWithIndutryTest() throws EncryptedDocumentException, IOException {
     
	
				//Read Data from Excel sheet - Test data
				String ORGNAME = eUtil.readDataFromExcel("organization", 7, 2)+jUtil.getRandomNumber();
			String INDUSTRY = eUtil.readDataFromExcel("organization", 7, 3);
			
			    
			      // click on Organization
				HomePage hp = new HomePage(driver);
				hp.clickonOrgLink();

				//  Click on Create Organization look Up Image
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrgLookUpImg();
				

				// Create new Organization with Mandatory fields
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createOrganization(ORGNAME, INDUSTRY);
				

				// Validate for Organization
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String orgHeader = oip.getHeaderText();
				
				Assert.assertTrue(orgHeader.contains(ORGNAME));
				System.out.println(orgHeader);	
				System.out.println("Organization Created");
				
			}

}
