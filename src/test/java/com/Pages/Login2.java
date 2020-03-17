package com.Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BaseClass.WrapperClass;
import com.ExcelUtilities.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Login2 extends Home
{

	ExtentHtmlReporter reporter = new ExtentHtmlReporter(WrapperClass.repPath+"Login.html");
	ExtentReports extent = new ExtentReports();
	ExtentTest logger;
	public void createReport() {
		reporter.setAppendExisting(true);
		extent.attachReporter(reporter);
		logger = extent.createTest("StartProject");
	}
	public void flusher() {
		extent.flush();
	}
	
	public void navigate() 
	{
		WrapperClass.driver.findElement(By.linkText("Log in")).click();
		
	}

	public void forgetPassword() throws IOException {
		WrapperClass.driver.findElement(By.xpath("//a[@data-modal-title=\"Forgot your password?\"]")).click();
		this.waiter(5);
		WrapperClass.driver.findElement(By.id("email")).sendKeys("alphabeta@gmail.com");
		this.waiter(5);
		this.screensht("ForgetPassword.png");
		WrapperClass.driver.findElement(By.xpath("//input[@data-disable-with=\"Continue\"]")).click();
		this.waiter(5);
		WrapperClass.driver.findElement(By.xpath("//span[@class=\"ss-icon ss-delete\"]")).click();
		this.waiter(5);
		
	}
	public void read() throws  Exception {
		for(int i=2;i<4;i++)
	     {
	    	for(int j=0;j<2;j++) 
	    	{
	    		ExcelReadWrite obj = new ExcelReadWrite();
				if(j==0)
				 {
					String val=obj.ExcelRead("Login", i, j);
//					System.out.println(val+" = First Value");
					WebElement wb1=null;
					Actions act = new Actions(WrapperClass.driver);
					wb1 = WrapperClass.driver.findElement(By.id("user_session_email")); 
					act.moveToElement(wb1).build().perform();
					try {
						wb1.clear();
					} catch (Exception e) {
						// TODO: handle exception
//						System.out.println("Ayyooo");
					}
					this.waiter(5);
					act.sendKeys(wb1,val).build().perform();
				 }
				else if(j==1)
				 {
						this.waiter(5);
						String temp = obj.ExcelRead("Login", i, j);
						WrapperClass.driver.findElement(By.id("user_session_password")).sendKeys(temp); 
						Thread.sleep(2000);
						WrapperClass.driver.findElement(By.xpath("//*[@id=\"new_user_session\"]/fieldset/ol/li[3]/input")).click();
						String title = WrapperClass.driver.getTitle();
						if(title.equalsIgnoreCase("Kickstarter"))
						{
							
							obj.ExcelWrite("Login", i, 2, "PASS");
							logger.log(Status.PASS, "Login Successful");
							WrapperClass.driver.findElement(By.xpath("//a[@href=\"/?ref=404-ksr10\"]")).click();
							this.waiter(5);
							WrapperClass.driver.findElement(By.xpath("//img[@alt=\"user avatar\"]")).click();
							this.waiter(5);
							WrapperClass.driver.findElement(By.xpath("/html/body/div[3]/section/div[3]/div/div[2]/div[1]/div/div/div[2]/div/a")).click();
							WrapperClass.driver.findElement(By.linkText("Log in")).click();
						}
						else 
						{
							obj.ExcelWrite("Login", i, 2, "FAIL");
							logger.log(Status.FAIL, "Login Fail");
							this.waiter(5);
							String tmp = String.valueOf(i);
							this.screensht("LoginFailiure"+tmp+".png");
							WrapperClass.driver.findElement(By.xpath("//button[@class=\"jGrowl-close-x\"]")).click();
							this.waiter(5);
							this.clickLogin();
						}
						this.waiter(5);
				 }
	    	}
	     }
	}
}
