package testcase;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import function.Utiltools;
import pages.HomePage;

public class Case_0001 {
	WebDriver driver = null;

	@Test(dataProvider = "dp")
	public void f(String s) {

		
		driver.get("https://www.baidu.com/");
	
		HomePage home = new HomePage(driver);
		boolean result = home.search(s);		
		Assert.assertTrue(result);
//		home.getIcon().click();
		home.getLogin().click();

	}

	@BeforeMethod
	public void beforeMethod() {
	
		driver = Utiltools.Initialize_Driver("chrome");
	}

	@AfterMethod
	public void afterMethod() {
//		driver.close();
	}

	@DataProvider
	public Object[][] dp() throws IOException {

		return Utiltools.getTestDataByExcel("D:/", "test1.xlsx", "Sheet1");
	}
}
