package com.allianz.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demoTest {
	@DataProvider
	
	public Object[][] Validata(){
		Object[][] data = new Object [3][2];
		
	data[0][0] = "saul";
	data[0][1] = "saul123";
	
	data[1][0] = "peter";
	data[1][1] = "peter123";
	
	data[2][0] = "kiran";
	data[2][1]= "kiran123";
	
	return data;
	}
	
	
	@Test(dataProvider = "Validata")
	public void validtest(String username , String password) {
		System.out.println(":valid test " + username + " "+ password);
		
	}

}
