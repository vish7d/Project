package com.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BaseClass.WrapperClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class StartProject extends Home{

	ExtentHtmlReporter reporter = new ExtentHtmlReporter(WrapperClass.repPath+"StartProject.html");
	ExtentReports extent = new ExtentReports();
	ExtentTest logger;
	public void createReport() {
		extent.attachReporter(reporter);
		logger = extent.createTest("StartProject");
	}
	public void flusher() {
		extent.flush();
	}
	public void SelectCategory(String cat) {	
		Actions act = new Actions(WrapperClass.driver);
		WebElement element1 = WrapperClass.driver.findElement(By.xpath("//span[contains(.,\"Select your category\")]"));
		act.moveToElement(element1).build().perform();
		act.click(element1).build().perform();
		waiter(5);
		WebElement element2 = WrapperClass.driver.findElement(By.xpath("//span[contains(.,\""+cat+"\")]"));
		act.moveToElement(element2).build().perform();
		act.click(element2).build().perform();
		waiter(5);
		WrapperClass.driver.findElement(By.xpath("//button[contains(.,\"Next: Project idea\")]")).click();
		waiter(5);
		logger.log(Status.INFO, "Category Selected");
	}
	public void EnterDescription(String desc) {
		waiter(5);
		WrapperClass.driver.findElement(By.id("project-description")).sendKeys(desc);
		waiter(5);
		WrapperClass.driver.findElement(By.xpath("//button[contains(.,\"Next: Location\")]")).click();
		waiter(5);
		logger.log(Status.INFO, "Description Entered");
	}
	public void DeleteProject() {
		
		waiter(5);
		WrapperClass.driver.findElement(By.xpath("//button[@data-id=\"delete-project-button\"]")).click();
		waiter(5);
		WrapperClass.driver.findElement(By.id("password")).sendKeys("01230123");
		WrapperClass.driver.findElement(By.xpath("//button[@type=\"button\" and contains(.,\"Delete project\")]")).click();
		logger.log(Status.INFO, "Project delete.");
		logger.log(Status.PASS, "Project creation and deletion Successful!");
		
	}
	public void SelectCountry(String country) {
		Actions act = new Actions(WrapperClass.driver);
		WebElement element1 = WrapperClass.driver.findElement(By.xpath("//span[contains(.,\"Select your country\")]"));
		act.moveToElement(element1).build().perform();
		act.click(element1).build().perform();
		waiter(5);
		WebElement element2 = WrapperClass.driver.findElement(By.xpath("//span[contains(.,\""+country+"\")]"));
		act.moveToElement(element2).build().perform();
		act.click(element2).build().perform();
		waiter(5);
		WrapperClass.driver.findElement(By.xpath("//button[contains(.,\" I am at least 18 years old.\")]/span/div")).click();
		waiter(5);
		WrapperClass.driver.findElement(By.xpath("//button[contains(.,\" I can verify an address and bank account in "+country+".\")]/span/div")).click();
		waiter(5);
		WrapperClass.driver.findElement(By.xpath("//button[contains(.,\" I can verify a government issued ID.\")]/span/div")).click();
		waiter(5);
		WrapperClass.driver.findElement(By.xpath("//button[contains(.,\" I have a debit and/or credit card.\")]/span/div")).click();
		waiter(5);
		WrapperClass.driver.findElement(By.xpath("//button[contains(.,\"Continue\")]")).click();
		waiter(5);
		logger.log(Status.INFO, "Country Selected");
		try {
			WrapperClass.driver.findElement(By.xpath("//a[@href=\"/login?ref=nav\"]")).click();
			waiter(5);
			WrapperClass.driver.findElement(By.id("user_session_email")).sendKeys("alphabeta@gmail.com");
			WrapperClass.driver.findElement(By.id("user_session_password")).sendKeys("01230123");
			waiter(5);
			WrapperClass.driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
			waiter(5);
			this.SelectCategory("Technology");
			this.EnterDescription("Heloo tjjeereevdsvdfv ");
			this.SelectCountry(country);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
