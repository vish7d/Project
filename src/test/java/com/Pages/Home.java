package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.BaseClass.WrapperClass;

public class Home extends WrapperClass{
	
	public void LaunchBrowser() {
		this.launch("https://www.kickstarter.com", "chrome");
	}
	public void clickSignup() {
		WrapperClass.driver.findElement(By.linkText("Log in")).click();
		this.waiter(5);
		WrapperClass.driver.findElement(By.linkText("Sign up")).click();
		this.waiter(5);
	}

	public void clickLogin() {
		WrapperClass.driver.findElement(By.linkText("Log in")).click();
		this.waiter(5);
	}
	
	public void PerformLogin() {
		WrapperClass.driver.findElement(By.id("user_session_email")).sendKeys("alphabeta@gmail.com");
		WrapperClass.driver.findElement(By.id("user_session_password")).sendKeys("01230123");
		waiter(5);
		WrapperClass.driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		waiter(5);

	}
	
	public void clickSearch(String searchValString) {
		WrapperClass.driver.findElement(By.xpath("//span[contains(.,\"Search\")]")).click();
		this.waiter(5);
		WebElement search = WrapperClass.driver.findElement(By.xpath("//input[@type=\"search\"]"));
		search.sendKeys(searchValString);
		search.sendKeys(Keys.ENTER);
		this.waiter(5);
	}
	
	public void clickStartProject() {
		WrapperClass.driver.findElement(By.linkText("Start a project")).click();
		this.waiter(5);
		WrapperClass.driver.findElement(By.xpath("//a[@href=\"/start?ref=learn_top\"]")).click();
		this.waiter(5);
		
	}
	
}
