package com.eastmart.unittests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eastmart.actiondriver.Action;

/*
 * This class comtains unit cases written on different utility methods
 */

public class UtilityUnitTests {
	
	@Test
	public static void Stringcompare() {
		Assert.assertEquals(true, Action.compareText("akash","akash"));
		Assert.assertEquals(false,  Action.compareText("akash","xyz"));
	}

}
