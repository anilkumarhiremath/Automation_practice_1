package com.webautomation.utilities;

import java.io.File;

import java.io.IOException;
import java.util.Base64;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.webautomation.testcases.Base_Class;

public class Utilities implements ITestListener {
	ExtentTest test;
	ExtentReports reports;
	ExtentSparkReporter htmlReporter;

	/*
	 * @Override public void onTestFailure(ITestResult result) { Object testClass =
	 * result.getInstance(); WebDriver driver = ((Base_Class)
	 * testClass).getDriver(); String screenshotPath = takeScreenshot(driver,
	 * result.getName()); System.out.println("Screenshot saved at: " +
	 * screenshotPath); }
	 */

	public String takeScreenshot(WebDriver driver, String screenshotName) {
		Random random = new Random();
		String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + random.nextInt(100)
				+ ".png";
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(screenshotPath);
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}

	public void scroll(WebDriver driver, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", e);

	}

	public void check_visibility1(WebDriver driver, WebElement e) {
		if (e.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	public void on_click(WebDriver driver, WebElement e) {
		e.click();
	}

	public String gettitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

	public void Wait(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);

	}

	public static String capturescreenshot(WebDriver driver) throws IOException {
		String screenshotPath = System.getProperty("user.dir") + "/Reports/" + ".png";
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(screenshotPath);
		String escreenshot = destination.getAbsolutePath();
		FileUtils.copyFile(source, destination);
		return escreenshot;

	}

	public void base64(WebDriver driver) {
		// Capture the screenshot as a byte array
		byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// Encode the byte array in Base64 format
		String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
		// Add the screenshot to the Extent Report
		test.addScreenCaptureFromBase64String(base64Screenshot);

	}
}