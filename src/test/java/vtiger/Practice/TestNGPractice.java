package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(invocationCount = 3, priority = 1)

	public void createCustomer() {
	     Assert.fail();              //purposefully fail the script
		System.out.println("customer created");
	}
	@Test(priority = -2, dependsOnMethods = "createCustomer")
	
	public void modifyCustomer() {
		System.out.println("customer modified");
	}
	@Test(enabled = false,dependsOnMethods = {"createCustomer", "modifyCustomer"})
	public void deleteCustomer() {
		System.out.println("customer deleted");
	}

}
 