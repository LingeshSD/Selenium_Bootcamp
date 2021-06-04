package week4;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.seleniumbootcamp.base.BaseClass;

public class S3_26_Administrator_Certifications extends BaseClass{
	
	
	
	
	//certifacte box
	
	//a[normalize-space()='Administrator']
	//ul[@class='bullets Fz(18px) Lh(1.5) Fw(l)']
	public void clickLearnMore() throws InterruptedException
	{
		System.out.println("inside");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		System.out.println("clicked");
		
	}
	
	public void hoverAndClick()
	{
		WebElement hover = driver.findElement(By.xpath("//button[@aria-expanded='false']//span[contains(text(),'Resources')]"));
		WebElement target = driver.findElement(By.xpath("//a[contains(@href,'https://trailhead.salesforce.com/credentials/administratoroverview/')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hover).click(target).build().perform();
	}
	
	public void verifyAdminstrator()
	{
	List<WebElement> certifications = driver.findElements(By.xpath("//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch']/div"));
	System.out.println(certifications.size());
	
	for (int i = 1; i <=certifications.size(); i++) {
		
		
		WebElement text = driver.findElement(By.xpath("//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch']/div["+i+"]//div[3]"));
		String name = text.getText();
		if(name.contains("Administrator"))
		{
			System.out.println("it is availble");
			driver.findElement(By.xpath("//div[@class='slds-grid slds-wrap slds-grid--align-center slds-grid--pull-padded slds-grid--vertical-stretch']/div["+i+"]//div[3]")).click();
		}
		
		
	}
	
	}
	public void switchToNewWindow()
	{
		String parentWinHandle = driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		for(String temp:winHandles) {
			if(!temp.equalsIgnoreCase(parentWinHandle)) {
				driver.switchTo().window(temp);
			
			}
		}
	}
	public void getTextForClasses()
	{
		String classes = driver.findElement(By.xpath("//ul[@class='bullets Fz(18px) Lh(1.5) Fw(l)']")).getText();
		System.out.println(classes);
	}
	
	public String getPageTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
		return title;
		
	}

}
