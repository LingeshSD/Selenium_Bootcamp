package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S3_53_Create_Task {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		driver.findElementByXPath("//p[normalize-space()='Content']").click();
		driver.findElementByXPath("//a[@aria-label='View All Tasks']//span[@class='viewAllLabel'][normalize-space()='View All']").click();
		driver.findElementByXPath("//button[@title='Display as Split View']").click();
		driver.findElementByXPath("//li[@title='Table']//a[@role='menuitemcheckbox']").click();
		
		
		driver.findElementByXPath("//div[@title='New Task']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[normalize-space()='Not Started']").click();
		driver.findElementByXPath("//a[@title='In Progress']").click();
		driver.findElementByXPath("//label[text()='Subject']/following::input").sendKeys("Email"+Keys.ENTER);
		driver.findElementByXPath("//input[@title='Search Contacts']").click();
		driver.findElementByXPath("//div[@title='mtuh']").click();
		driver.findElementByXPath("//input[@title='Search Accounts']").click();
		driver.findElementByXPath("//div[@title='Fortune']").click();
		driver.findElementByXPath("//input[@class='inputDate input']").click();
		driver.findElementByXPath("//span[normalize-space()='15']").click();
		driver.findElementByXPath("//a[normalize-space()='Normal']").click();
		driver.findElementByXPath("//a[normalize-space()='High']").click();
		driver.findElementByXPath("//button[@title='Save']").click();
		
		List<String> beforeCreate = new ArrayList<>();
		beforeCreate.add("mtuh");
		beforeCreate.add("Fortune");
		beforeCreate.add("5/15/2021");
		beforeCreate.add("DDsou");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Refresh']")).click();
		Thread.sleep(2000);
		
	List<WebElement> row =	driver.findElements(By.xpath("//tbody/tr[1]/td"));
	List<String> afterCreate = new ArrayList<>();
	System.out.println(row.size());
		for(int i = 3; i <row.size();i++)
		{
			//System.out.println("inside");
			System.out.println(driver.findElement(By.xpath("//tbody/tr[1]/td["+i+"]")).getText());
			String value = driver.findElement(By.xpath("//tbody/tr[1]/td["+i+"]")).getText();
			afterCreate.add(value);
			
		}
		
		
		
		
	if(beforeCreate.equals(afterCreate))	
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
		
		    
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
