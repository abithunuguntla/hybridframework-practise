package com.allianz.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class loginUITest extends AutomationWrapper {
	
	


	@Test
	public void Application() {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String Actualtext = driver.findElement(By.xpath("//*[text()='OrangeHRM OS 5.6.1']")).getText();

		Assert.assertEquals(Actualtext, "OrangeHRM OS 5.6.1");

	}

}
