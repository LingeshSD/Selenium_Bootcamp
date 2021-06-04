package week3_TestNG;

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
import org.testng.annotations.Test;

import com.seleniumbootcamp.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S3_6_Verify_Opportunities_sort_order_by_Close_date extends BaseClass{

public static void sortOrderByCloseDate() throws InterruptedException {
		
		driver.findElementByClassName("slds-icon-waffle").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//p[text()='Sales']").click();
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[@class='slds-truncate'][normalize-space()='Opportunities']"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>des order<<<<<<<<<<<<<<<<<<<<<<<");

		driver.findElement(By.xpath("//th[@title='Close Date']//a[contains(@class,'toggle slds-th__action slds-text-link--reset')]")).click();
		Thread.sleep(3000);
	
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		
		ArrayList<String> actualList = new ArrayList(); 
		int count = rows.size();
		for(int i=1; i<=count;i++)
		{
			String date = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[6]")).getText();
			
			System.out.println(date);
		
			actualList.add(date);
		}
	Collections.reverse(actualList);
	
		System.out.println("After reversed the existing one" +actualList);
	


		driver.findElement(By.xpath("//th[@title='Close Date']//a[contains(@class,'toggle slds-th__action slds-text-link--reset')]")).click();
		Thread.sleep(4000);
	
		System.out.println(">>>>>>>>>>>>>>>>>ascending orer<<<<<<<<<<<<<<<<<<<<<<<");

		ArrayList<String> currentSortedList = new ArrayList(); 
		int count2 = rows.size();
		for(int i=1; i<=count2;i++)
		{
			String date = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[6]")).getText();
			
			System.out.println(date);
			
			currentSortedList.add(date);
		}
		
		
		Assert.assertEquals(actualList, currentSortedList);
	
		

	}

}
