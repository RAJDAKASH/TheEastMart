package com.eastmart.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.Status;


public class TestListener implements ITestListener{

	public void onTestStart(ITestResult itr) {
		ExtentManager.test=ExtentManager.extent.createTest(itr.getName() );
		
	}
	public void onTestSuccess(ITestResult itr) {
		ExtentManager.test.log(Status.PASS,itr.getName() + ": Test Passed");
		Log.info("Test Case Passed" + itr.getName());
		
	}
	public void onTestFailure(ITestResult itr) {
		ExtentManager.test.log(Status.FAIL,itr.getName() + ": Test failed due to :" +itr.getThrowable().getMessage());
		Log.error(itr.getThrowable().getMessage());

	}
	public void onTestSkipped(ITestResult itr) {
		ExtentManager.test.log(Status.WARNING,itr.getName());
		Log.info("Test Skipped"+ itr.getName());
	}



}
