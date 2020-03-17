package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BaseClass.WrapperClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Explore extends Home {

	ExtentHtmlReporter reporter = new ExtentHtmlReporter(WrapperClass.repPath+"Explore.html");
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
	public void explore() 
	{
		this.waiter(5);
		WrapperClass.driver.findElement(By.xpath("//*[@id=\"global-header\"]/section/section[2]/button")).click();
		
	}

	public void categories() 
	{
		this.waiter(5);
		WrapperClass.driver.findElement(By.linkText("Trending")).click();
	}

	public void filters() throws InterruptedException 
	{
		this.waiter(5);
		WrapperClass.driver.findElement(By.id("category_filter")).click();
		this.waiter(5);
    	Thread.sleep(500);
		WrapperClass.driver.findElement(By.xpath("//a[@data-id=\"26\"]")).click();
		this.waiter(5);
    	Thread.sleep(500);
		WrapperClass.driver.findElement(By.xpath("//li[@id=\"category_26\"]")).click();
		this.waiter(5);
    	Thread.sleep(500);
	}

	public void GoBackHome() throws InterruptedException {
		this.waiter(5);
		WrapperClass.driver.findElement(By.xpath("//a[@href=\"/?ref=nav\"]")).click();
		this.waiter(5);
    	Thread.sleep(500);
		WrapperClass.driver.findElement(By.xpath("//img[@alt=\"user avatar\"]")).click();
		this.waiter(5);
    	Thread.sleep(500);
		WrapperClass.driver.findElement(By.xpath("//div[@id=\"global-header\"]/section/div[3]/div/div[2]/div[1]/div/div/div[2]/div/a")).click();
		this.waiter(5);
    	Thread.sleep(500);
		
	}
	public void select() 
	{
		this.waiter(5);
		Actions act = new Actions(WrapperClass.driver);
		WebElement prod = WrapperClass.driver.findElement(By.xpath("//div[@data-project_pid=\"490485216\"]"));
		act.moveToElement(prod).build().perform();
		act.click().build().perform();
		this.waiter(5);
		WrapperClass.driver.findElement(By.id("back-project-button")).click();
		WrapperClass.driver.findElement(By.id("backing_backer_reward_id_")).click();
		WrapperClass.driver.findElement(By.id("backing_amount")).sendKeys("20");
		WrapperClass.driver.findElement(By.xpath("//*[@id=\"pledges_new\"]/main/div[2]/div/div[1]/ol/li[1]/form/div[2]/div[1]/button")).click();
		  
	}

	public void verify_amount() 
	{
		String amount = WrapperClass.driver.findElement(By.xpath("//*[@id=\"payments-app\"]/div/div[2]/div[3]/p[2]")).getText();
		if(amount.contentEquals("$20.00")) {
			//System.out.println("Amount is correct");
			logger.log(Status.PASS, "Amount entered is correct");
		}
		else {
			//System.out.println(amount+" Amount is incorrect");
			logger.log(Status.FAIL, "Amount entered is incorrect");
			
		}
	}
    
	
	}
