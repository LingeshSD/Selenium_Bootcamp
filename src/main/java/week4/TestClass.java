package week4;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumbootcamp.base.BaseClass;

public class TestClass extends BaseClass {
	S3_26_Administrator_Certifications admin = new S3_26_Administrator_Certifications();
	S3_28_Architect_Certifications architect = new S3_28_Architect_Certifications();
	
//	@Test
//	public void administratorCertification() throws InterruptedException
//	{
//		admin.clickLearnMore();
//		admin.switchToNewWindow();
//		admin.hoverAndClick();
//		admin.switchToNewWindow();
//		admin.verifyAdminstrator();
//		admin.getTextForClasses();
//	
//		Assert.assertEquals(admin.getPageTitle(), "Certification - Advanced Administrator");
//	}
	
	@Test
	public void architectCertification() throws Exception
	{
		architect.clickLearnMore();
		architect.switchToNewWindow();
		architect.hoverAndClick();
		architect.switchToNewWindow();
		architect.clickArchitect();
		architect.getSummary();
		architect.imageDownloadUsingRobotFun();
		//architect.downloadSolutionArchitectImage();
		architect.downloadTechnicalArchitectImage();
		architect.SalesforceArchitectCertificates();
		architect.applicationArchitectCertifications();
		//admin.verifyAdminstrator();
		//admin.getTextForClasses();
	
		//Assert.assertEquals(admin.getPageTitle(), "Certification - Advanced Administrator");
		Assert.assertEquals(architect.applicationArchitectCertifications(), 4);
	}
}
