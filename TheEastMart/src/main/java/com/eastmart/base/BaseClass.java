package com.eastmart.base;

import java.io.FileInputStream;

import com.beust.jcommander.Parameter;
import com.eastmart.actiondriver.Action;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public static Properties prop;
	// Declare ThreadLocal Driver
	public static WebDriver driver;
	
	//loadConfig method is to load the configuration
	@BeforeSuite
	public void loadConfig() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Parameters({"platform","hubUrl"})
	@BeforeSuite
	public void launchApp(String platform, String hubUrl) {	
		boolean dockerSeleniumGrid=true;
		if(hubUrl.equalsIgnoreCase("na")) {
			dockerSeleniumGrid=false;
		}
		if(!dockerSeleniumGrid) {
		
		String currentUsrDir= System.getProperty("user.dir");
		System.out.println(currentUsrDir);
		if(platform.equalsIgnoreCase("windows")) {
			System.setProperty("webdriver.chrome.driver",currentUsrDir+"\\src\\test\\resources\\BrowserDrivers\\windows\\chromedriver.exe");
		}
		else if(platform.equalsIgnoreCase("mac")) {
			System.setProperty("webdriver.chrome.driver",currentUsrDir+"\\src\\test\\resources\\BrowserDrivers\\mac\\chromedriver.exe");
		}
		else if(platform.equalsIgnoreCase("linux")) {
			System.setProperty("webdriver.chrome.driver",currentUsrDir+"\\src\\test\\resources\\BrowserDrivers\\linux\\chromedriver.exe");
		}
		
		// String browserName = prop.getProperty("browser");	
		driver=new ChromeDriver();
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();		
		driver.get("https://www.amazon.in");
		}
		else {
			
		}
		
		
	}
	
	@AfterSuite
	public void tearDown() {
	//	driver.quit();
	}

}
