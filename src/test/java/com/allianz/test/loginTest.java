package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.utilis.DataUtils;

public class loginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void validLogin(String user, String pass , String dashboard) {
		driver.findElement(By.name("username")).sendKeys(user);
		// password
		driver.findElement(By.name("password")).sendKeys(pass);
		// login
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		String actualheader = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(actualheader, dashboard);

	}

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
	public void invalidLogin(String username, String password, String expectederror) {
		driver.findElement(By.name("username")).sendKeys(username);
		// password
		driver.findElement(By.name("password")).sendKeys(password);
		// login
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		// invalid credentials
		String errormessage = driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
		Assert.assertEquals(errormessage, expectederror);

	}

}
