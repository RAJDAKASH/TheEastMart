/**
 * 
 */
package com.eastmart.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.eastmart.actiondriver.Action;
import com.eastmart.base.BaseClass;
import com.eastmart.utility.Log;

/**
 * This framework follows Page Factory Design pattern.
 * Page factory design pattern improves the readability and maintainability of code.
 * 
 * All the objects and methods related to Product selection Page are present here.
 * 
 */
public class ProductSelection extends BaseClass{
	
	@FindBy (xpath = "//*[@class='a-button-text a-declarative']//*[text()='Sort by:']")
	WebElement AMZ_SORT_BY ;
	
	@FindBy (xpath = "//*[@class=\"a-popover-wrapper\"]//*[text()='Price: High to Low']")
	WebElement AMZ_PRICE_HIGH_TO_LOW ;
	
	
	
	@FindBy (xpath = "(//*[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//img)[1]")
	WebElement AMZ_SECOND_HIGHEST_ITEM ;
	
	@FindBy (xpath = "//h1[text()=' About this item ']")
	WebElement AMZ_ABOUT_THIS_ITEM ;
	
	@FindBy (xpath = "//h1[text()=' About this item ']//parent::div//ul//li//*[@class='a-list-item']")
	List<WebElement> PRODUCT_DESCRIPTION_TEXT;
	
	public ProductSelection() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Method is used to select the second highest TV
	 */
	
	public void selectSecondHighestTv()  {
		Action.explicitWait(driver,AMZ_SORT_BY,Duration.ofMillis(10000));
		Action.click1(AMZ_SORT_BY ,"AMZ_SORT_BY");
		Action.explicitWait(driver,AMZ_PRICE_HIGH_TO_LOW,Duration.ofMillis(10000));
		Action.click1(AMZ_PRICE_HIGH_TO_LOW ,"AMZ_PRICE_HIGH_TO_LOW");	
		Action.explicitWait(driver,AMZ_SECOND_HIGHEST_ITEM,Duration.ofMillis(10000));
		Action.click1(AMZ_SECOND_HIGHEST_ITEM ,"AMZ_SECOND_HIGHEST_ITEM");
	
	}
	
	/*
	 * multiple windows are handeled in the below method through the action class 
	 * utility method.
	 * 
	 * 
	 * About the item section is printed on console and logged on the Log4j file
	 */
	public String verifyAboutUsSection()  {
		Action.switchToNewWindow(driver);
		Action.explicitWait(driver,AMZ_ABOUT_THIS_ITEM,Duration.ofMillis(10000));
		Action.scrollByVisibilityOfElement(driver, AMZ_ABOUT_THIS_ITEM);
		
		String aboutThisItemText=AMZ_ABOUT_THIS_ITEM.getText();
		System.out.println(aboutThisItemText);
		Log.info(aboutThisItemText);
		for(WebElement aboutItemTextElement: PRODUCT_DESCRIPTION_TEXT) {
			Log.info(aboutItemTextElement.getText());
			System.out.println(aboutItemTextElement.getText());
		}
		return aboutThisItemText;
		
	}
	
}
