/**
 * 
 */
package com.webautomation.testcases;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import com.webautomation.utilities.Readconfig;

/**
 * @author 102645
 *
 */
public class Base_Class {
	Readconfig readconfig = new Readconfig();
	
	public static WebDriver driver;
	public static org.apache.logging.log4j.Logger log;
	public String baseURL = readconfig.geturl();
	
	 
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite
	@Parameters({ "browser" })
	public void setup(@Optional("Edge") String Browser) {

		log= LogManager.getLogger(this.getClass());
		
		  //log = Logger.getLogger("webautoamtion");
		 // PropertyConfigurator.configure("Log4j.properties");
		
		
		
		if (Browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();      // Invalid Status code=403 text=Forbidden at org.asynchttpclient.netty.handler.WebSocketHandler.abort(WebSocketHandler.java:92)
			options.addArguments("--remote-allow-origins=*");
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			
			
			
		} else {
			if (Browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			} else {
				if (Browser.equalsIgnoreCase("Edge")) {
					driver = new EdgeDriver();
					driver.manage().window().maximize();
				}
			}
		}

	}

	@AfterSuite
	public void teardown() {

		driver.quit();

	}
}
