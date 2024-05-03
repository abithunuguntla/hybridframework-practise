package com.allianz.test;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginUITest {
	@Test
	public void titletes() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.open-emr.org/demo/");
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, "OpenEMR Demo");

	}

	@Test
	public void Application() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String Actualtext = driver.findElement(By.xpath("//*[text()='OrangeHRM OS 5.6.1']")).getText();

		Assert.assertEquals(Actualtext, "OrangeHRM OS 5.6.1");

	}

}
