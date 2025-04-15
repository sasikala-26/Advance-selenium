package product;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	// Assertion
		// Types of Assertion ---->*HardAssert *SoftAssert
		// SoftAssert
		// *SoftAssert is non-Static in Nature
		// *In SoftAssert when ever @Test/Assert is failed,it not stops the execution in
		// same Line
		// *When ever SoftAssert Fails Throws AssertError Exception
		// *SoftAssert is used only for non Mandatory Fields.\
		// *AssertAll() is mandatory
		 @Test
		 public void m1() {
			 System.out.println("step1");
			 System.out.println("step2");
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(true, false);
			 System.out.println("step3");
			 System.out.println("step4");
			 soft.assertAll();
			 
		 }
	
}
