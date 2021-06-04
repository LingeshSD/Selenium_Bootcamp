package week3_TestNG;

import java.net.MalformedURLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumbootcamp.base.BaseClass;

public class TestClass extends BaseClass {
	@DataProvider(name="data-provider")
	public Object[][] data()
	{
		return new Object[][] {{"Email"}};
		
	}
	
	@Test
	public void appStore() throws MalformedURLException, InterruptedException
	{
	S3_107_VerifyAppStoreLink.appStore();
	}
	
	@Test
	public void cancelServiceAppoinments() throws InterruptedException
	{
		S3_18_Cancel_Service_Appoinments.cancelServiceAppoinments();
	}
	
	@Test(dataProvider = "data-provider")
	public void createTask(String value) throws Exception
	{
		S3_53_Create_Task.createTask(value);
	}
	
	@Test
	public void sortByDate() throws Exception
	{
		S3_6_Verify_Opportunities_sort_order_by_Close_date.sortOrderByCloseDate();
	}
	
	@Test
	public void filterTask() throws Exception 
	{
		S3_60_Filter_Task.filterTask();
	}
}
