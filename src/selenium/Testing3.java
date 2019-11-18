package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {

	SoftAssert softassert = new SoftAssert();

	@Test(priority = 1)
	public void homeTest() {
		System.out.println("I am in home test");
		System.out.println("Before Assertion");

		Assert.assertTrue(4 > 3, "Verification Element");
		System.out.println("After Assertion");
		Assert.assertEquals("abc", "abc");
	}

	@Test(priority = 2, dependsOnMethods = "homeTest", groups = {"smoke", "sanity"})
	public void mainTest() {
		System.out.println("I am in main test");
		System.out.println("Before Assertion");

		Assert.assertTrue(2 > 3, "Verification Element");
		System.out.println("After Assertion");

		softassert.assertAll(); // similar to error collector
	}

	@Test(priority = 3, dependsOnMethods = "mainTest", groups = "krina")
	public void endTest() {
		System.out.println("I am in end test");
		System.out.println("Before Assertion");

		Assert.assertTrue(2 > 3, "Verification Element");
		System.out.println("After Assertion");
		Assert.assertEquals("abc", "abc1");
		System.out.println("After second assertion");
		softassert.assertAll(); // similar to error collector
	}
}
