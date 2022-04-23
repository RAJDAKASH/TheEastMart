package com.eastmart.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eastmart.pageobjects.ProductSelection;

public class ProductSelectionTest {
	public static ProductSelection productSelection;
	
	@Test
	public static void selectSecondHighestTvTest() {
		productSelection= new ProductSelection();
		productSelection.selectSecondHighestTv();
		
	}
	
	@Test
	public static void verifyAboutUsSection() {
		
		  String AboutItemActualText=productSelection.verifyAboutUsSection();
		  Assert.assertEquals(AboutItemActualText, "About this item");
		 
		
		
	}
}
