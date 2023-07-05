package com.webautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Download_Page {

	WebDriver driver;
	
	public Download_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Selenium Server (Grid)']")
	public WebElement icon1;
	
	@FindBy(xpath = "//h2[text()='Selenium IDE']")
	public WebElement icon2;
	
	@FindBy(xpath = "//div[@class=\"row justify-content-center p-5\"]//a[text()='documentation']")
	public WebElement documentationlink;
	
	
	 public Documentation_Page clickon_documentation() {
		 documentationlink.click();
		 return new Documentation_Page();
		 
	 }
	
}
