package com.eastmart.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.eastmart.base.BaseClass;
import com.eastmart.actiondriver.Action;
public class HomePage extends BaseClass{
	
	@FindBy (xpath = "//*[@id='nav-hamburger-menu']")
	WebElement AMZ_HAM_BURGER_MENU ;
	
	
	@FindBy (xpath = "//*[@class='hmenu-item']//*[text()='TV, Appliances, Electronics']")
	WebElement AMZ_TV_AND_APPLIANCES ;
	
	@FindBy (xpath = "//*[@class='hmenu-item' and text()='Televisions']")
	WebElement AMZ_TELEVISION;
	
	@FindBy (xpath = "//input[@type='checkbox']//parent::label//parent::div//following-sibling::span[text()='Samsung']")
	WebElement SAMSUNG_CHECKBOX;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToSamsungTv() throws InterruptedException {
		
		Action.explicitWait(driver,AMZ_HAM_BURGER_MENU,Duration.ofMillis(10000));
		Action.click1(AMZ_HAM_BURGER_MENU ,"AMZ_HAM_BURGER_MENU");
		Action.explicitWait(driver,AMZ_TV_AND_APPLIANCES,Duration.ofMillis(10000));
		Action.scrollByVisibilityOfElement(driver, AMZ_TV_AND_APPLIANCES);
		Action.click1(AMZ_TV_AND_APPLIANCES ,"AMZ_TV_AND_APPLIANCES");
		Action.explicitWait(driver,AMZ_TELEVISION,Duration.ofMillis(10000));
		Action.scrollByVisibilityOfElement(driver, AMZ_TELEVISION);
		Action.click1(AMZ_TELEVISION ,"AMZ_TELEVISION");
		Action.explicitWait(driver,SAMSUNG_CHECKBOX,Duration.ofMillis(10000));
		Action.scrollByVisibilityOfElement(driver, SAMSUNG_CHECKBOX);
		Action.click1(SAMSUNG_CHECKBOX ,"SAMSUNG_CHECKBOX");
		Action.explicitWait(driver,AMZ_HAM_BURGER_MENU,Duration.ofMillis(10000));
	}
}
