package week3_TestNG;

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

public class S3_18_Cancel_Service_Appoinments extends BaseClass {
	


	public static void cancelServiceAppoinments() throws InterruptedException {
		driver.findElementByClassName("slds-icon-waffle").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//p[text()='Service Appointments']")));

		
		List<WebElement> rows = driver.findElementsByXPath("//tbody/tr");
		int rowsCount = rows.size();

		for (int i = 1; i <= rowsCount; i++) {
			WebElement appoinmentNo = driver.findElement(By.xpath("//tbody/tr[" + i + "]/th[1]/span/a"));
			String no = appoinmentNo.getText();
			if (no.equals("SA-0001")) {

				driver.executeScript("arguments[0].click();", driver.findElement(By
						.xpath("//tr[" + i + "]//span[@class='slds-icon_container slds-icon-utility-down']//span[1]")));
			}
		}

		Thread.sleep(2000);
		driver.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//div[@title='Cancel Service Appointment']")));

		driver.findElement(By.xpath("//button[normalize-space()='Confirm Cancellation']")).click();
		String actual = driver
				.findElement(By.xpath("//a[text()[normalize-space()='SA-0001']]/following::span[text()='Canceled']"))
				.getText();

		Assert.assertEquals(actual, "Canceled");

	}
}
