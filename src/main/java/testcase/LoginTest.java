package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		// Precondition - setup the driver
		WebDriverManager.chromedriver().setup();
		//to open the chrome browser
		ChromeDriver driver = new ChromeDriver();
       
		//For launching the website in browser
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//For finding that username webelement and enter values in it
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		//For finding that login button and to click 
		driver.findElement(By.id("btnLogin")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		//For getting the current url and storing in string
		String actual = driver.getCurrentUrl();
		
		String expected = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		
		//For checking that current test cases is passed or not by checking that both actual and expected value
		Assert.assertEquals(actual, expected);
		
		
	}

}
