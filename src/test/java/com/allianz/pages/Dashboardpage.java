package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.allianz.base.webDriverkeywords;

public class Dashboardpage extends webDriverkeywords{
private By dashboardHeaderLocator=By.xpath("//h6[contains(normalize-space(),'Dash')]");
	
	private WebDriver driver;
	
	public Dashboardpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public String getDashboardHeader()
	{
		//return driver.findElement(By.xpath("//h6[contains(normalize-space(),'Dash')]")).getText();
		return getText(dashboardHeaderLocator);
	}

	//clickOnAssignLeave()
	//clickOnLeaveList()
	//clickOnTimeSheet()
}


