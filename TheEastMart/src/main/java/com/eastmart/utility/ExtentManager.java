package com.eastmart.utility;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/**
 * @author akash: ExtentManager class is used for Extent Report
 * Extent reports are initialized here and flushed here
 *  
 */
public class ExtentManager {
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws Exception {	
		extent= new ExtentReports();
		ExtentHtmlReporter spark = new ExtentHtmlReporter("TheEastMart.html");
		spark.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration\\extent-config.xml");
		extent.attachReporter(spark);
		
		
		
	}
	public static void endReport() {
		extent.flush();
	}
}
