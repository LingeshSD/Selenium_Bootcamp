package week2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S3_60_Filter_Task {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
		Thread.sleep(2000);
		List<WebElement> lightningSwitch = driver.findElementsByXPath("//a[@class='switch-to-lightning']"); 
		if(lightningSwitch.size() !=0) { driver.findElementByXPath("//a[@class='switch-to-lightning']").click(); }
		driver.findElementByClassName("slds-icon-waffle").click();
		driver.findElementByXPath("//p[normalize-space()='Content']").click();
		driver.findElementByXPath("//a[@aria-label='View All Tasks']//span[@class='viewAllLabel'][normalize-space()='View All']").click();
		driver.findElement(By.xpath("//a[@title='Select List View']//lightning-primitive-icon//*[local-name()='svg']")).click();
		driver.findElement(By.xpath("//div[@role='dialog']//li[2]")).click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[@title='Display as Split View']").click();
		driver.findElementByXPath("//li[@title='Table']//a[@role='menuitemcheckbox']").click();
		driver.findElementByXPath("//button[@title='Show filters']").click();
		driver.findElementByXPath("//div[normalize-space()='Filter by Owner']").click();
		driver.findElement(By.xpath("//span[contains(text(),'All tasks')]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Done']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Add Filter']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select an Option']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Select an Option']")).sendKeys("sta");
		driver.findElement(By.xpath("//span[@class='slds-media__body']//span[@title='Status']")).click();
	
		driver.findElement(By.xpath("//a[normalize-space()='0 options selected']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='In Progress']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Done']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		driver.findElementByXPath("//button[@title='Hide filters']").click();
		
		List<WebElement> rowSize = driver.findElements(By.xpath("//tbody/tr"));
		System.out.println(rowSize.size());
		int filterCount =0;
		for (int i = 1; i <=rowSize.size(); i++) {
			WebElement status = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[6]//div[@class='slds-truncate']"));
			String statusValues = status.getText();
			
			if(statusValues.equals("In Progress"))
			{
				filterCount++;
			}
			
		}
		System.out.println(filterCount);
		if(rowSize.size()== filterCount)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		
		
		
		
		
		
		
		
	//	
		
		
		
		
		
		
		
		
	}

}
