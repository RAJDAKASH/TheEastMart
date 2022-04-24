package com.eastmart.base;

import java.io.FileInputStream;
import com.eastmart.aipackage.TrainData;


import com.eastmart.utility.ExtentManager;
import com.eastmart.utility.Log;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.net.URL;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * 
 * @author akashraj
 * 
 * Base class runs before running of all classes.
 * It sets the browser and its related capabilities.
 * It sets path for log4j file and loads its configuration.
 * 
 * It loads the config properties file into the memory to fetch properties from key value 
 * pair mentioned in properties file.
 * 
 * It initializes and trains the AI model on the data set given which further can be used
 * to predict valid or Invalid defects
 * 
 * It sets the properties of extent reports.
 * 
 * Tear down method is also defined in this class.
 *
 */

public class BaseClass {
	public static Properties prop;
	// Declare ThreadLocal Driver
	public static WebDriver driver;
	
	//loadConfig method is to load the configuration
	@BeforeSuite
	public void loadConfig() {

		try {	
			
			DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration\\log4j.xml");
			TrainData.trainDataCreateModel();
		} 
		catch (Exception e) {
			e.printStackTrace();
			Log.info(e.getMessage());
		}
	}
	
	/*
	 * before suite methods runs as a first priority in testNg suite
	 * below methodloads the configuration file in memory
	 * 
	 * Launching on URL through WebDriverManager is done here
	 * Different capabilities of browser can be set in desired capabilities
	 * 
	 * The suite is only configured to run for chrome browser
	 * 
	 */
	@BeforeSuite
	public void launchApp() throws Exception {	
		ExtentManager.setExtent();
		
		String currentUsrDir= System.getProperty("user.dir");
		
		Properties prop = new Properties();
		String fileName = currentUsrDir+"\\src\\test\\resources\\Configuration\\config.properties";
		try (FileInputStream fis = new FileInputStream(fileName)) {
		    prop.load(fis);
		} catch (FileNotFoundException ex) {
		    // FileNotFoundException catch is optional and can be collapsed
		} catch (IOException ex) {
		   
		}
		
		String urlToLaunch=prop.getProperty("url");
		String dockerHubUrl=System.getProperty("hubUrl");
		
		
		if(dockerHubUrl.equalsIgnoreCase("NA")) {
			
			  ChromeOptions co= new ChromeOptions();
			  WebDriverManager.chromedriver().setup(); 
			  driver=new ChromeDriver(co);
			  driver.manage().window().maximize(); 
			  driver.manage().deleteAllCookies();
			 
		}
		else {
			
			  DesiredCapabilities dc= new DesiredCapabilities();
			  dc.setBrowserName("chrome"); driver= new RemoteWebDriver(new
			  URL(dockerHubUrl),dc);
		}
		
		driver.manage().window().maximize(); 
		driver.get(urlToLaunch);
		
	}
	/*
	 * After suite methods runs as the last method in the base class
	 * Here objects are removed from reference so that they become eligible for garbage collection
	 */
	@AfterSuite(alwaysRun=true)
	public void tearDown() {
		System.out.println("tear down method ");
		ExtentManager.endReport();
		driver.quit();
	}

}
