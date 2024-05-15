package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.pages.Dashboardpage;
import com.allianz.pages.Loginpage;
import com.allianz.utilis.DataUtils;

public class loginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void validLogin(String user, String pass , String dashboard) {
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUsername(user);
		loginpage.enterPassword(pass);
		loginpage.clickOnLogin();
		Dashboardpage dashboardd = new Dashboardpage(driver);
		String Actualhedear = dashboardd.getDashboardHeader();
		Assert.assertEquals(Actualhedear, dashboard);

	}

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void invalidLogin(String username, String password, String expectederror) {
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnLogin();
		// invalid credentials
		String Expectederror = loginpage.getInvalidErrorMessage();
		Assert.assertEquals(Expectederror,expectederror);

	}

}
