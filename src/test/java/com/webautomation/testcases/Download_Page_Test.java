package com.webautomation.testcases;

import org.testng.annotations.Test;

import com.webautomation.pageobjects.Download_Page;
import com.webautomation.utilities.Utilities;

//@Listeners({Extent_Reports.class , Utilities.class})
public class Download_Page_Test extends Base_Class{
	Download_Page dp;
	
	
	@Test
	public void download_page() throws InterruptedException {
		
		dp = new Download_Page(driver);
        Utilities ut = new Utilities();
		
		ut.check_visibility1(driver, dp.icon1);
		log.info("Selenium Grid is displayed");
		log.info("Selenium Grid is displayed");
		ut.check_visibility1(driver, dp.icon2);
		log.info("Selenium IDE is present");
		ut.Wait(driver);
		
		dp.clickon_documentation();
		 log.info("Clicked on documentation"); ut.Wait(driver);
		
		 driver.quit();
		
	}
	
}
