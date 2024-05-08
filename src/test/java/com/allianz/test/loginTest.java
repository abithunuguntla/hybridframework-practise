package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.utilis.DataUtils;

public class loginTest extends AutomationWrapper {

	@Test
	public void validLogin() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		// password
		driver.findElement(By.name("password")).sendKeys("admin123");
		// login
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		String actualheader = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(actualheader, "Dashboard");

	}

	@Test(dataProvider = "invaliddata", dataProviderClass = DataUtils.class)
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
