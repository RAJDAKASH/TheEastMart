package com.eastmart.utility;

import org.testng.ITestListener;
import com.eastmart.aipackage.TrainData;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.Status;


public class TestListener implements ITestListener{
	/**
	 * Test listener class implementation
	 * steps defined on what would happen on various scenarios of a test 
	 * Custom conditions on passing and failing or skipping of a test case.
	 * 
	 * Defect prediction utility is used here to predict defects on trained AI model.
	 */

	public void onTestStart(ITestResult itr) {
		ExtentManager.test=ExtentManager.extent.createTest(itr.getName() );
		
	}
	public void onTestSuccess(ITestResult itr) {
		ExtentManager.test.log(Status.PASS,itr.getName() + ": Test Passed");
		Log.info("Test Case Passed" + itr.getName());
		
	}
	
	/*
	 * Defect prediction utility is used here to predict defects on trained AI model.
	 */
	public void onTestFailure(ITestResult itr) {
		TrainData.predictDefect(itr.getThrowable().getMessage());
		ExtentManager.test.log(Status.FAIL,itr.getName() + ": Test failed due to :" +itr.getThrowable().getMessage());
		Log.error(itr.getThrowable().getMessage());

	}
	public void onTestSkipped(ITestResult itr) {
		ExtentManager.test.log(Status.WARNING,itr.getName());
		Log.info("Test Skipped"+ itr.getName());
	}



}
