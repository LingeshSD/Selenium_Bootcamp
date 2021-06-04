package week3_TestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumbootcamp.base.BaseClass;


public class S3_107_VerifyAppStoreLink extends BaseClass {

	

public static void appStore() throws InterruptedException, MalformedURLException
{
	Thread.sleep(3000);
	
	List<WebElement> articles = driver.findElementsByXPath("//div[@class='carouselPage active onesetupSetupCarouselPage']//article");
	int articlesCount = articles.size();
	List<WebElement> tabs = driver.findElements(By.xpath("//ul[@role='tablist']/li"));
	int tabsCount = tabs.size();
	
	
	
	
	for (int i = 1; i <tabsCount; i++) {
		
		for (int j = 1; j <=articlesCount; j++) {
			Thread.sleep(1000);
			WebElement articleTitle = driver.findElement(By.xpath("//div[@class='carousel']//div["+i+"]//article["+j+"]//div[@class='tileTitle']"));
			String title = articleTitle.getText();
			System.out.println(title);
			if(title.equals("Download SalesforceA"))
			{
				
				System.out.println("inside");
				driver.findElement(By.xpath("//button[@title='App Store']//span[normalize-space()='App Store']")).click();
				break;
			}
			
		}
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")).click();
	}
	String parentWinHandle = driver.getWindowHandle();
	Set<String> winHandles = driver.getWindowHandles();
	for(String temp:winHandles) {
		if(!temp.equalsIgnoreCase(parentWinHandle)) {
			driver.switchTo().window(temp);
		
		}
	}
	
	String url = 	driver.findElement(By.xpath("//p[contains(text(),'https://itunes.apple.com/us/app/salesforcea/id7311')]")).getText();

	URL path = new URL(url);
	String actualPath = path.getPath();
		
		driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
		
		String currentURL = driver.getCurrentUrl();
		URL path2 = new URL(currentURL);
		String currentPath = path2.getPath();
		
		Assert.assertEquals(actualPath, currentPath);
		
		
		
	}

}
