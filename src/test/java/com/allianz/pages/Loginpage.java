package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	
	public static void enterusername(WebDriver driver , String username) {
		driver.findElement(By.name("username")).sendKeys(username);
	}
	
	public static void enterpassword(WebDriver driver , String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	public static void clickonlogin(WebDriver driver) {
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	
}
