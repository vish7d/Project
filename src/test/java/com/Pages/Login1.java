package com.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BaseClass.WrapperClass;
import com.ExcelUtilities.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Login1 extends Home {
	
	ExtentHtmlReporter reporter = new ExtentHtmlReporter(WrapperClass.repPath+"Login.html");
	ExtentReports extent = new ExtentReports();
	ExtentTest logger;
	public void createReport() {
		//reporter.setAppendExisting(true);
		extent.attachReporter(reporter);
		logger = extent.createTest("StartProject");
	}
	public void flusher() {
		extent.flush();
	}
	public void navigate() {
		this.waiter(5);
		WrapperClass.driver.findElement(By.linkText("Log in")).click();
		this.waiter(5);
	}

	public void read() throws Exception {
		for(int i=1;i<2;i++)
	     {
	    	for(int j=0;j<2;j++) {
				ExcelReadWrite obj = new ExcelReadWrite();
				if(j==0)
				 {
					String val=obj.ExcelRead("Login", i, j);
					WebElement wb1 = WrapperClass.driver.findElement(By.id("user_session_email")); 
					wb1.clear();
					Thread.sleep(2000);
					wb1.sendKeys(val);
				 }
				else if(j==1)
				 {
					String temp = obj.ExcelRead("Login", i, j);
					WrapperClass.driver.findElement(By.id("user_session_password")).sendKeys(temp); 
					Thread.sleep(2000);
					WrapperClass.driver.findElement(By.xpath("//*[@id=\"new_user_session\"]/fieldset/ol/li[3]/input")).click();
					String title = WrapperClass.driver.getTitle();
					//System.out.println(title);
					if(title.equalsIgnoreCase("Kickstarter"))
					{
						
						obj.ExcelWrite("Login", i, 2, "PASS");
						logger.log(Status.PASS, "Login Successul");
						WrapperClass.driver.findElement(By.xpath("//img[@alt=\"user avatar\"]")).click();
						WrapperClass.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						WrapperClass.driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div/div[2]/div[1]/div/div/div[2]/div/a")).click();
						WrapperClass.driver.findElement(By.linkText("Log in")).click();
					}
					else 
					{
					obj.ExcelWrite("Login", i, 2, "FAIL");
					logger.log(Status.FAIL, "Login Fail");
					this.waiter(5);
					WrapperClass.driver.findElement(By.xpath("//button[@class=\"jGrowl-close-x\"]")).click();
					this.waiter(5);
					this.clickLogin();
					}
				 }
	    	}
	    
	}

}
}
