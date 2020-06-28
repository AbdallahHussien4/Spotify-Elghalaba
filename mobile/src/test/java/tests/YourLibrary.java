package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;

public class YourLibrary extends BaseClass{
	@Test
	public void testOne() {
	WebDriverWait wait = new WebDriverWait(driver, 200);
	wait.until(ExpectedConditions.elementToBeClickable(By.id("com.vnoders.spotify_el8alaba:id/Login_button")));
	
	// creates a toggle for the given test, adds all log events under it    
    ExtentTest test1 = extent.createTest("YourLibrary Test", "Sample test case for demo");
    // log(Status, details)
    test1.log(Status.INFO, "YourLibrary Test Started");
    
    //login
    MobileElement login_s =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
	login_s.click();
	
	MobileElement email =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/email_edit_text"));
	email.sendKeys("smsm@smsm.com");
	MobileElement password =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/password_edit_text"));
	password.sendKeys("Ww12@jjj");
	
	MobileElement log_button =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
	log_button.click();
	
    //Your Library
	wait.until(ExpectedConditions.elementToBeClickable(By.id("com.vnoders.spotify_el8alaba:id/navigation_your_library")));
	MobileElement libraryToolBar = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/navigation_your_library"));
	libraryToolBar.click();
	MobileElement Playlists = driver.findElement(By.xpath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Playlists\"]"));
	Playlists.click();
	test1.log(Status.PASS, "playlist UI Done");
	test1.log(Status.INFO, "YourLibrary Test completed");
	System.out.println("YourLibrary_Test Completed...");
}
}