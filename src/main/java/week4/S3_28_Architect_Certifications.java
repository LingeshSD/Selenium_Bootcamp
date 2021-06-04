package week4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.seleniumbootcamp.base.BaseClass;

public class S3_28_Architect_Certifications extends BaseClass {

	public void clickLearnMore() throws InterruptedException {
		System.out.println("inside");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		System.out.println("clicked");

	}

	public void hoverAndClick() {
		WebElement hover = driver
				.findElement(By.xpath("//button[@aria-expanded='false']//span[contains(text(),'Resources')]"));
		WebElement target = driver.findElement(
				By.xpath("//a[contains(@href,'https://trailhead.salesforce.com/credentials/administratoroverview/')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hover).click(target).build().perform();
	}
	
	public void clickArchitect()
	{
		driver.findElement(By.xpath("//a[@href='/credentials/architectoverview']//div[contains(text(),'Salesforce Architect')]")).click();
	}
	public void getSummary()
	{
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Salesforce Architects are the most trusted digital')]")).getText());
	}
	
	public void downloadImage(String xpath) throws Exception
	{
		WebElement logo = driver.findElement(By.xpath(xpath));
	     String logoSRC = logo.getAttribute("src");
	     
	     URL imageURL = new URL(logoSRC);
	     BufferedImage saveImage = ImageIO.read(imageURL);
	     
	     ImageIO.write(saveImage, "png", new File("certificate.png"));
	     
	}
	public void downloadTechnicalArchitectImage() throws Exception
	{
		downloadImage("//div[@class='slds-container--center slds-container--medium slds-p-vertical--large']//div[5]//img[1]");
	}
	
	public void downloadSolutionArchitectImage() throws Exception
	{
		downloadImage("//div[@class='slds-container--center slds-container--medium slds-p-vertical--large']//div[8]//img[1]");
	}
	
	public void SalesforceArchitectCertificates()
	{
		List<WebElement> certifications = driver.findElements(By.xpath("(//div[contains(@class, 'slds-grid slds-wrap slds-grid--align-center ')])[1]/div"));
		System.out.println(certifications.size());
		
		for (int i = 1; i <=certifications.size(); i++) {
			
			
			WebElement text = driver.findElement(By.xpath("(//div[contains(@class, 'slds-grid slds-wrap slds-grid--align-center ')])[1]/div["+i+"]//a"));
			String name = text.getText();
			if(name.contains("Application Architect"))
			{
				System.out.println("it is availble");
			
				driver.findElement(By.xpath("(//div[contains(@class, 'slds-grid slds-wrap slds-grid--align-center ')])[1]/div["+i+"]//a")).click();
			break;
			}
			
			
			
		}
		
	}
	
	public void imageDownloadUsingRobotFun() throws AWTException, InterruptedException
	{
		 //Locate Image
		  WebElement Image =driver.findElement(By.xpath("//div[@class='slds-container--center slds-container--medium slds-p-vertical--large']//div[5]//img[1]"));
		  //Rihgt click on Image using contextClick() method.
		  Actions action= new Actions(driver);
		  action.contextClick(Image).build().perform();
		  
		  //To perform press Ctrl + v keyboard button action.
		  action.sendKeys(Keys.CONTROL, "v").build().perform();

		  Thread.sleep(3000);
		  Robot robot = new Robot();
		 
		  robot.keyPress(KeyEvent.VK_DOWN);
	         Thread.sleep(2000);
	         robot.keyPress(KeyEvent.VK_DOWN);
	         Thread.sleep(2000);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         Thread.sleep(2000);
	         robot.keyPress(KeyEvent.VK_ENTER);
	}
		public int applicationArchitectCertifications()
		{
			List<WebElement> certifications = driver.findElements(By.xpath("(//div[contains(@class, 'slds-grid slds-wrap slds-grid--align-center ')])[1]/div"));
			System.out.println(certifications.size());
			return certifications.size();
			
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
		
	
}
