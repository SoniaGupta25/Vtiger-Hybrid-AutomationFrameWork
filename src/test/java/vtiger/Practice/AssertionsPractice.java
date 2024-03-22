package vtiger.Practice;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {

public void sampleTest() {
		
		int a = 1; //exp
		int b = 2; //actual
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals(b, a);//pass//failure
		System.out.println("Step 3");
		System.out.println("Step 4");
		System.out.println("Execution and validation complete");
		
	}
      
	public void sampleTest1() {
		SoftAssert sa = new SoftAssert();
		
		int a = 1; //exp
		int b = 2; //actual
		
		System.out.println("Step 1");
		sa.assertEquals(false, true);  //pass//failure
		System.out.println("Step 2");
		Assert.assertEquals(b, a);     //failed
		
		System.out.println("Step 3");
		
		System.out.println("Step 4");
		
		sa.assertTrue(false);  //fail
		System.out.println("Execution and validation complete");
		
		sa.assertAll(); //logging all the failure
		
		
	}

}
