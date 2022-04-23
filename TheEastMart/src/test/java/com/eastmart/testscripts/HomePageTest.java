package com.eastmart.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.eastmart.base.BaseClass;
import com.eastmart.pageobjects.HomePage;

public class HomePageTest extends BaseClass{
	public static HomePage homePage ;
	
	@Test
	public static void navigateToSamsunTvTest() {
		homePage = new HomePage();
		try {
			homePage.navigateToSamsungTv();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
