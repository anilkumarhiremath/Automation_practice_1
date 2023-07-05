/**
 * 
 */
package com.webautomation.pageobjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.testcases.Base_Class;

/**
 * @author 102645
 *
 */
public class Home_Page extends Base_Class {

//	public  WebDriver driver;
	
	 public Home_Page(WebDriver driver)
	 {
		 
		 PageFactory.initElements(driver, this);
	 }
	 	
	 @FindBy(xpath = "//div[@class='card-body']//h4[text()='Selenium WebDriver']")
	 public WebElement icon1;
	 
	 @FindBy(xpath = "//div[@class='card-body']//h4[text()='Selenium IDE']")
	 public WebElement icon2;
	 
	 @FindBy(xpath = "//div[@class='card-body']//h4[text()='Selenium Grid']")
	 public WebElement icon3;
	 
	 @FindBy(xpath = "//span[@class='navbar-logo']")
	 public WebElement icon4;
	 
	 @FindBy(xpath = "//p[@class=\"mt-2\"]//a")
	 public WebElement icon5;
	 
	 @FindBy(xpath = "//a[@class='nav-link']//span[text()='Downloads']")
	 public WebElement downloadlink;
	 
		
	 public Download_Page clickon_download() {
		 downloadlink.click();
		 return new Download_Page(driver);
		 
	 }
	 
	 public boolean validate_logo() {
		 return icon4.isDisplayed();
	 }
	 
	}
