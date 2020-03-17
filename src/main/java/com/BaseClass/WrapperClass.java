package com.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WrapperClass {

	protected static WebDriver driver;
	protected static String srcPath="C:\\Users\\Sreelakshmi\\eclipse-workspace\\PROJECT\\src";
	protected static String repPath="C:\\Users\\Sreelakshmi\\eclipse-workspace\\PROJECT\\src\\test\\resources\\com\\Reports\\";
	public static int count=0;
	public void launch(String url,String browser) {
		if(browser.equalsIgnoreCase("chrome"))
		{
			try {
				System.setProperty("webdriver.chrome.driver", WrapperClass.srcPath+"\\test\\resources\\com\\Drivers\\chromedriver.exe");
				WrapperClass.driver = new ChromeDriver();
			} catch (Exception e) {
				System.out.println("Chrome Driver File is missing....");
			}
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			try {
				System.setProperty("webdriver.gecko.driver", WrapperClass.srcPath+"\\test\\resources\\com\\Drivers\\geckodriver.exe");
				WrapperClass.driver = new FirefoxDriver();
			} catch (Exception e) {
				System.out.println("Firefox Driver File is missing....");
			}
		}
		WrapperClass.driver.manage().window().maximize();
		WrapperClass.driver.get(url);
		WrapperClass.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void quit() {
		WrapperClass.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WrapperClass.driver.quit();
	}

	public void waiter(int time) {
		WrapperClass.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public void screensht(String fileName) throws IOException {
		File destFile = new File(WrapperClass.srcPath+"\\test\\resources\\com\\ScreenShots\\"+fileName);
		TakesScreenshot scrsht = ((TakesScreenshot)WrapperClass.driver);
		File srcFile = scrsht.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, destFile);
	}

}
