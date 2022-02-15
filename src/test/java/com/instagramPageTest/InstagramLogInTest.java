package com.instagramPageTest;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.instagramLogInData.LogInData;

public class InstagramLogInTest extends BaseClass{
	
	@DataProvider(name = "LogInData")
	public Iterator<LogInData> gatLogInData(){
		ArrayList<LogInData> aList = new ArrayList<LogInData>();
		aList.add(new LogInData("_____anik_____", "1100"));
		return aList.iterator();
	}
	
	
	@Test(enabled = false)
	public void instagramLogInTest() {
		instaPage.instaPageSteps("_____anik_____", "1100", driver);
	}

	@Test(dataProvider = "LogInData")
	public void instagramLogInTest1(LogInData data) {
		instaPage.instaPageStepData( driver, data);
	}

}
