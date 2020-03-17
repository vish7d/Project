package com.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BaseClass.WrapperClass;
import com.ExcelUtilities.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

	public class Search extends Home{

	ExtentHtmlReporter reporter = new ExtentHtmlReporter(WrapperClass.repPath+"Search.html");
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
	
    public void keyword1(String keyWord) 
    {
    	WrapperClass.driver.findElement(By.xpath("//*[@id=\"global-header\"]/section/section[3]/button/span")).click();
    	this.waiter(5);
    	WebElement wb1= WrapperClass.driver.findElement(By.xpath("//*[@id=\"global-header\"]/section/div[1]/div/div/div[1]/input"));
    	this.waiter(5);
    	wb1.sendKeys(keyWord);
    	wb1.sendKeys(Keys.ENTER);
    }
    public void filters() throws InterruptedException, IOException 
    {
    	Thread.sleep(500);
    	WrapperClass.driver.findElement(By.xpath("//*[@id=\"category_filter\"]/span")).click();    	
    	this.waiter(5);
    	Thread.sleep(500);
    	WrapperClass.driver.findElement(By.xpath("//a[@data-id=\"12\"]")).click();
    	this.waiter(5);
    	Thread.sleep(500);
    	WrapperClass.driver.findElement(By.xpath("//a[contains(.,\"All of Games\")]")).click();	
    	this.waiter(5);
    	Thread.sleep(500);
    	WrapperClass.driver.findElement(By.id("sorts")).click();
    	this.waiter(5);
    	Thread.sleep(500);
    	WrapperClass.driver.findElement(By.partialLinkText("Popularity")).click();
    	this.waiter(5);
    	Thread.sleep(500);
    	click_project();
    	Thread.sleep(500);
    	String tmp = String.valueOf(WrapperClass.count++);
		this.screensht("Search"+tmp+".png");
    }
    public void click_project() throws InterruptedException, IOException
	{
    	this.waiter(5);
    	Thread.sleep(1000);
    	Actions act = new Actions(WrapperClass.driver);
//    	System.out.println(WrapperClass.driver.getTitle());
    	try {
        	WebElement elem = WrapperClass.driver.findElement(By.xpath("//*[@id=\"projects\"]/div[3]/div/div/div[1]/div/div/div/div[3]/div[1]/div[1]"));
        	elem.click();
        	//act.moveToElement(elem).build().perform();
			
		} catch (Exception e) {
	    	for (int i = 0; i < 11; i++) {
	        	act.sendKeys(Keys.TAB).build().perform();
			}
	    	act.sendKeys(Keys.ENTER).build().perform();
		}
    	this.waiter(5);
		
	}

    public void store_in_excel() throws IOException 
    {
    	int i = 0;
    	String title = WrapperClass.driver.findElement(By.xpath("/html/body/main/div/div/section/div[3]/div[1]/h2/span/a")).getText();
//    	System.out.println(title);
		logger.log(Status.INFO, "Title collected= "+title);
    	String author = WrapperClass.driver.findElement(By.xpath("//div[@class=\"creator-name\"]/div[1]/a")).getText();
//    	System.out.println(author);
		logger.log(Status.INFO, "Author collected= "+author);
    	String money = WrapperClass.driver.findElement(By.xpath("//div[@class=\"NS_campaigns__spotlight_stats\"]/span")).getText();
//    	System.out.println(money);          
		logger.log(Status.INFO, "Money collected= "+money);        
    	String backers = WrapperClass.driver.findElement(By.xpath("//div[@class=\"mb0\"]/h3")).getText();
//    	System.out.println(backers); 
		logger.log(Status.INFO, "Backers collected= "+backers);
		for(int j=0;j<4;j++)
		{
			ExcelReadWrite obj = new ExcelReadWrite();
			if(j==0) {
				i = obj.ExcelRowLength("Search")+1;
				obj.ExcelWrite("Search", i, j, title);
			}
			else if(j==1) {
				obj.ExcelWrite("Search", i, j, author);
			}
			else if(j==2) {
				obj.ExcelWrite("Search", i, j, money);
			}
			else if(j==3) {
				obj.ExcelWrite("Search", i, j, backers);
			}
		}
		logger.log(Status.PASS, "Data collected and entered to excel");
    }
   
	}
