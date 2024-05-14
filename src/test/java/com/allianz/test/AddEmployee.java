package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class AddEmployee extends AutomationWrapper {
	@Test
	public void uploadinvalidpicture() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		// password
		driver.findElement(By.name("password")).sendKeys("admin123");
		// login
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		driver.findElement(By.xpath("//*[text()='PIM']")).click();
		// click on add add employee
		driver.findElement(By.linkText("Add Employee")).click();

//uploding file

		driver.findElement(By.xpath("//input[@type='file']"))
				.sendKeys("C:\\Users\\Administrator\\eclipse-workspace\\HealthManagementAutomation\\.classpath");
//assert the error 
		String errr = driver.findElement(By.xpath("//*[text()='File type not allowed']")).getText();
		Assert.assertTrue(errr.contains("not allowed"));
	}

}
