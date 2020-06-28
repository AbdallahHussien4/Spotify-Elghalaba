package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;

public class ChangeUserName extends BaseClass {
	
	@Test
	public void ChangeUserName() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		ExtentTest Test = extent.createTest("Change User Name");
		Test.log(Status.INFO, "Change User Name Test Started");
		System.out.println("Please Login...");
		WebDriverWait wait = new WebDriverWait(driver, 200);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
		
		MobileElement Settings = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]"));
		Settings.click();
		
		MobileElement ProfileTab = driver.findElement(By.id("com.spotify.music:id/username"));
		ProfileTab.click();
	
		MobileElement EditProfileButton = driver.findElement(By.id("com.spotify.music:id/edit_button"));
		EditProfileButton.click();
		
		MobileElement EditUserName = driver.findElement(By.id("com.spotify.music:id/edit_displayname"));
		EditUserName.setValue("Test");
		
		MobileElement SaveButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button"));
		SaveButton.click();
		
		MobileElement UserName = driver.findElement(By.id("com.spotify.music:id/profile_title"));
		String Name = UserName.getText();
		
		
		//Check if the name was changed
		if(Name!="Test")
		{
			System.out.println(Name);
			System.out.println("the name Changed Correctly");
			System.out.println("Test Passed");
			Test.log(Status.PASS, "The Name Changed Correctly");
		}
		else
		{
			System.out.println("the name doesn't change");
			System.out.println("Test Failed");
			Test.log(Status.FAIL, "The Name Changed Correctly");
		}
		
	}
	
	
	
	@Test
	public void ChangeUserNameWithEmptyString() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		ExtentTest Test = extent.createTest("Change User Name with empty string");
		Test.log(Status.INFO, "Change User Name With Empty String Test Started");
		
		MobileElement Home = driver.findElement(By.id("com.spotify.music:id/home_tab"));
		Home.click();
		
		MobileElement Settings = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]"));
		Settings.click();
		
		MobileElement ProfileTab = driver.findElement(By.id("com.spotify.music:id/username"));
		ProfileTab.click();
	
		MobileElement EditProfileButton = driver.findElement(By.id("com.spotify.music:id/edit_button"));
		EditProfileButton.click();
		
		MobileElement EditUserName = driver.findElement(By.id("com.spotify.music:id/edit_displayname"));
		EditUserName.setValue(" ");
		
		MobileElement SaveButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button"));
		
		if(SaveButton.isEnabled())
		{
			System.out.println("Test Failed");
			Test.log(Status.FAIL, "The Name Changed");
		}
		else
		{
			System.out.println("Test Passed");
			Test.log(Status.PASS, "The Name Doesn't Change ");
		}
		
	}


}
