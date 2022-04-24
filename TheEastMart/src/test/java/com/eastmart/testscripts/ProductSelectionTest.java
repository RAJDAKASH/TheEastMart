package com.eastmart.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eastmart.pageobjects.ProductSelection;
import com.eastmart.utility.Log;

public class ProductSelectionTest {
	public static ProductSelection productSelection;
	
	/**
	 * This class contains tests related to product selection page
	 */

	@Test
	public static void selectSecondHighestTvTest() {
		try {
			Log.startTestCase("selectSecondHighestTvTest");
			productSelection= new ProductSelection();
			productSelection.selectSecondHighestTv();
			Log.info("selectSecondHighestTv method completed");
			Log.endTestCase("selectSecondHighestTvTest");
		}
		catch (Exception e) {
			Log.error(e.getMessage());
			Assert.fail();
		}

	}

	@Test
	public static void verifyAboutUsSection() {
		try {

			Log.startTestCase("verifyAboutUsSection");
			String AboutItemActualText=productSelection.verifyAboutUsSection();
			Assert.assertEquals(AboutItemActualText, "About this item");	
			Log.info("About this Item info verified");
			Log.endTestCase("verifyAboutUsSection");
		}
		catch (Exception e) {
			Log.error(e.getMessage());
		}
	}
}
