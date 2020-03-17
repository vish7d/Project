package com.Pages;

import org.openqa.selenium.By;

public class Logout extends Home{
	
	public void performLogout() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"global-header\"]/section/section[3]/button[2]/img")).click();
		this.waiter(5);
		driver.findElement(By.xpath("//*[@id=\"global-header\"]/section/div[3]/div/div[2]/div[1]/div/div/div[2]/div/a")).click();
		this.waiter(5);
	}
}
