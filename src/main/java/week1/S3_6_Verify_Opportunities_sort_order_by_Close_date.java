package week1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S3_6_Verify_Opportunities_sort_order_by_Close_date {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
		Thread.sleep(2000);
		List<WebElement> lightningSwitch = driver.findElementsByXPath("//a[@class='switch-to-lightning']"); 
		if(lightningSwitch.size() !=0) { driver.findElementByXPath("//a[@class='switch-to-lightning']").click(); }
		driver.findElementByClassName("slds-icon-waffle").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//p[text()='Sales']").click();
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[@class='slds-truncate'][normalize-space()='Opportunities']"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>des order<<<<<<<<<<<<<<<<<<<<<<<");

		driver.findElement(By.xpath("//th[@title='Close Date']//a[contains(@class,'toggle slds-th__action slds-text-link--reset')]")).click();
		Thread.sleep(3000);
	
		
		ArrayList<String> actualList = new ArrayList(); 
		int count = 9;
		for(int i=1; i<=count;i++)
		{
			String date = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[6]")).getText();
			
			System.out.println(date);
		
			actualList.add(date);
		}
	Collections.reverse(actualList);
	
		System.out.println("After reversed the existing one" +actualList);
	


		driver.findElement(By.xpath("//th[@title='Close Date']//a[contains(@class,'toggle slds-th__action slds-text-link--reset')]")).click();
		Thread.sleep(3000);
	
		System.out.println(">>>>>>>>>>>>>>>>>ascending orer<<<<<<<<<<<<<<<<<<<<<<<");

		ArrayList<String> currentSortedList = new ArrayList(); 
		int count2 = 9;
		for(int i=1; i<=count2;i++)
		{
			String date = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[6]")).getText();
			
			System.out.println(date);
			
			currentSortedList.add(date);
		}
	
		if(actualList.equals(currentSortedList))
		{
			System.out.println("sorted");
		}
		else
		{
			System.out.println("not sorted");
		}

	}

}
