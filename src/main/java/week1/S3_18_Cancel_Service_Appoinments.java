package week1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S3_18_Cancel_Service_Appoinments {

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
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[text()='Service Appointments']")));

		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']//span[1]")));
Thread.sleep(2000);
	
		driver.findElement(By.xpath("//a[@data-aura-rendered-by='2723:0']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Confirm Cancellation']")).click();
		String status = driver.findElement(By.xpath("//a[text()[normalize-space()='SA-0001']]/following::span[text()='Canceled']")).getText();
		if(status.equals("Canceled"))
			System.out.println("passed");

	}

}
