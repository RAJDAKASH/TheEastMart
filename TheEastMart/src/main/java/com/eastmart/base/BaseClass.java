package com.eastmart.base;

import java.io.FileInputStream;

import com.beust.jcommander.Parameter;
import com.eastmart.actiondriver.Action;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	
	
	@BeforeSuite
	public void launchApp() throws Exception {	
		
		String currentUsrDir= System.getProperty("user.dir");
		
		Properties prop = new Properties();
		String fileName = currentUsrDir+"\\Configuration\\config.properties";
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
			  driver=new ChromeDriver();
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
	
	@AfterSuite
	public void tearDown() {
	//	driver.quit();
	}

}
