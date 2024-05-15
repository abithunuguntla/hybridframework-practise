package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.pages.Loginpage;
import com.allianz.utilis.DataUtils;

public class loginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void validLogin(String user, String pass , String dashboard) {
		Loginpage.enterusername(driver, user);
		// password
		Loginpage.enterpassword(driver, pass);
		// login
		Loginpage.clickonlogin(driver);
		String actualheader = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(actualheader, dashboard);

	}

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void invalidLogin(String username, String password, String expectederror) {
		Loginpage.enterusername(driver, username);
		// password
		Loginpage.enterpassword(driver, password);
		// login
		Loginpage.clickonlogin(driver);
		// invalid credentials
		String errormessage = driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
		Assert.assertEquals(errormessage, expectederror);

	}

}
