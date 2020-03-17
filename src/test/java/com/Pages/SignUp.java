package com.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.BaseClass.WrapperClass;
import com.ExcelUtilities.ExcelReadWrite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SignUp extends Home{

	ExtentHtmlReporter reporter = new ExtentHtmlReporter(WrapperClass.repPath+"SignUp.html");
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
	
	ExcelReadWrite obj=new ExcelReadWrite();

	public void performSignup() throws IOException, InterruptedException {
		int len = obj.ExcelRowLength("Signup");
//		System.out.println(len);
		for(int i=1;i<=len;i++) 
		{
			try {
				WrapperClass.driver.findElement(By.linkText("Log in")).click();
				this.waiter(5);
				WrapperClass.driver.findElement(By.linkText("Sign up")).click();
				this.waiter(5);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			for(int j=0;j<5;j++) 
			{
				if(j==0) 
				{
					WebElement wb1=WrapperClass.driver.findElement(By.id("user_name"));
					wb1.clear();
					wb1.sendKeys(obj.ExcelRead("Signup",i,j));
					//this.waiter(8);
					//Thread.sleep(5000);
				}
				else if(j==1)
				{
					WebElement wb2=WrapperClass.driver.findElement(By.id("email-input"));
					wb2.clear();
					wb2.sendKeys(obj.ExcelRead("Signup",i,j));
					//this.waiter(8);
					//Thread.sleep(5000);
				}
				else if(j==2)
				{
					WebElement wb3=WrapperClass.driver.findElement(By.id("user_email_confirmation"));
					wb3.clear();
					wb3.sendKeys(obj.ExcelRead("Signup",i,j));
					//this.waiter(8);
					//Thread.sleep(5000);
				}
				else if(j==3)
				{
					WebElement wb4=WrapperClass.driver.findElement(By.id("password-input"));
					wb4.clear();
					wb4.sendKeys(obj.ExcelRead("Signup",i,j));
					//this.waiter(80);
					//Thread.sleep(5000);
				}
				else if(j==4)
				{
					WebElement wb5=driver.findElement(By.id("user_password_confirmation"));
					wb5.clear();
					wb5.sendKeys(obj.ExcelRead("Signup",i,j));
					//this.waiter(8);
					//Thread.sleep(5000);
				}
			}
			
			driver.findElement(By.xpath("//*[@id=\"new_user\"]/fieldset/ol/li[6]/span/label")).click();
			//Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"new_user\"]/fieldset/ol/li[7]/span/label")).click();
			
			//Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@value=\"Create account\"]")).click();
		//	Thread.sleep(5000);
			
			try {
				driver.findElement(By.xpath("//*[@id=\"global-header\"]/section/section[3]/button[2]/img")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id=\"global-header\"]/section/div[3]/div/div[2]/div[1]/div/div/div[2]/div/a")).click();
				obj.ExcelWrite("Signup", i, 5, "Pass");
				obj.ExcelWrite("Signup", i, 6, "N.A");
				logger.log(Status.PASS, "Signup passed");
			} 
			catch (Exception e) 
			{
				String err="";
				this.screensht("SignupError"+String.valueOf(i)+".png");
				List<WebElement> elems = WrapperClass.driver.findElements(By.xpath("//form[@id=\"new_user\"]/fieldset/div[1]/ul"));
				for (int k = 0; k < elems.size(); k++) {
					WebElement ele = elems.get(k);
					err+=ele.getText();
					logger.log(Status.INFO, ele.getText());
				}
//				System.out.println(err);
				// TODO: handle exception
				obj.ExcelWrite("Signup", i, 5, "Fail");
				logger.log(Status.FAIL, "Signup Failed");
				if(err=="") {
					logger.log(Status.INFO, "Please include an @ in the Email.");
					obj.ExcelWrite("Signup", i, 6, "Please include an @ in the Email.");
				}
				else{
					obj.ExcelWrite("Signup", i, 6, err);
				}
			}
		}
	}

}
