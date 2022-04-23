/**
 * 
 */
package com.eastmart.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eastmart.actiondriver.Action;
import com.eastmart.base.BaseClass;

/**
 * @author akash raj
 *
 */
public class ProductSelection extends BaseClass{
	
	@FindBy (xpath = "//*[@class='a-button-text a-declarative']//*[text()='Sort by:']")
	WebElement AMZ_SORT_BY ;
	
	@FindBy (xpath = "//*[@class=\"a-popover-wrapper\"]//*[text()='Price: High to Low']")
	WebElement AMZ_PRICE_HIGH_TO_LOW ;
	
	
	
	@FindBy (xpath = "//*[@data-cel-widget='search_result_2']//h2")
	WebElement AMZ_SECOND_HIGHEST_ITEM ;
	
	@FindBy (xpath = "//h1[text()=' About this item ']")
	WebElement AMZ_ABOUT_THIS_ITEM ;
	
	@FindBy (xpath = "//h1[text()=' About this item ']//parent::div//ul//li//*[@class='a-list-item']")
	List<WebElement> PRODUCT_DESCRIPTION_TEXT;
	
	public ProductSelection() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectSecondHighestTv()  {
		Action.explicitWait(driver,AMZ_SORT_BY,Duration.ofMillis(10000));
		Action.click1(AMZ_SORT_BY ,"AMZ_SORT_BY");
		Action.explicitWait(driver,AMZ_PRICE_HIGH_TO_LOW,Duration.ofMillis(10000));
		Action.click1(AMZ_PRICE_HIGH_TO_LOW ,"AMZ_PRICE_HIGH_TO_LOW");	
		Action.explicitWait(driver,AMZ_SECOND_HIGHEST_ITEM,Duration.ofMillis(10000));
		Action.click1(AMZ_SECOND_HIGHEST_ITEM ,"AMZ_SECOND_HIGHEST_ITEM");	
	
	}
	public String verifyAboutUsSection()  {
		Action.switchToNewWindow(driver);
		Action.explicitWait(driver,AMZ_ABOUT_THIS_ITEM,Duration.ofMillis(10000));
		Action.scrollByVisibilityOfElement(driver, AMZ_ABOUT_THIS_ITEM);
		
		String aboutThisItemText=AMZ_ABOUT_THIS_ITEM.getText();
		System.out.println(aboutThisItemText);
		for(WebElement aboutItemTextElement: PRODUCT_DESCRIPTION_TEXT) {
			System.out.println(aboutItemTextElement.getText());
		}
		return aboutThisItemText;
		
	}
	
}
