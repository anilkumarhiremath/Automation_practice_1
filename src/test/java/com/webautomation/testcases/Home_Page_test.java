package com.webautomation.testcases;

import org.testng.annotations.Test;

import com.webautomation.pageobjects.Download_Page;
import com.webautomation.pageobjects.Home_Page;
import com.webautomation.utilities.Utilities;

// @Listeners({ Extent_Reports.class })

public class Home_Page_test extends Base_Class {
//	public WebDriver driver;
	Home_Page hP;
	Download_Page dPage;

	@Test(groups = "Smoke")
	public void home_page() throws Exception {

		driver.get(baseURL);
		log.info("Url Opened");
		
		hP = new Home_Page(driver);
		Utilities ut = new Utilities();

		ut.check_visibility1(driver, hP.icon1);
		log.info("Selenium Webdriver is present");

		ut.Wait(driver);
		ut.check_visibility1(driver, hP.icon2);
		log.info("Selenium IDE is present");
		ut.Wait(driver);
		ut.check_visibility1(driver, hP.icon3);
		log.info("Selenium Grid is present");
		
		ut.scroll(driver, hP.icon5);
		
		hP.clickon_download();
		
		
}

}
