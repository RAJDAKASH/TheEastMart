package com.eastmart.testscripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eastmart.base.BaseClass;
import com.eastmart.pageobjects.HomePage;
import com.eastmart.utility.Log;

public class HomePageTest extends BaseClass{
	public static HomePage homePage ;
	
	/**
	 * Home Page Test class contains tests related to home page
	 * 
	 */

	@Test
	public static void navigateToSamsunTvTest() {
		homePage = new HomePage();
		try {
			Log.startTestCase("navigateToSamsunTvTest");
			homePage.navigateToSamsungTv();
			Log.endTestCase("navigateToSamsunTvTest ended");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			Log.error("navigateToSamsunTvTest failed with error" +e.getMessage());
			Assert.fail();
		}
	}
}
