package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class forgetPassword  extends BaseClass{
	@Test
	public void forget_Password(){
		String e_email="mohamed.sayed8899@gmail.com";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//for splash screen
		MobileElement login_s =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
		login_s.click();
		
		//forget_password
		driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/forget_password")).click();
		
		//email_edit_text
		driver.findElementById("com.vnoders.spotify_el8alaba:id/email_edit_text").setValue(e_email);
		
		//com.vnoders.spotify_el8alaba:id/get_link
		driver.findElementById("com.vnoders.spotify_el8alaba:id/get_link").click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//for splash screen
		String a_email=driver.findElementById("com.vnoders.spotify_el8alaba:id/email_address_holder").getText();
		
		//open_email
		driver.findElementById("com.vnoders.spotify_el8alaba:id/open_email").click();
		Assert.assertEquals(a_email, e_email);

		
}
	
}
