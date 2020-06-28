package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class userInfo extends BaseClass {
	@Test
	public void user_Info(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//for splash screen
		MobileElement login_s =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
		login_s.click();
		
		MobileElement email =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/email_edit_text"));
		email.sendKeys("mohamed.sayed8899@gmail.com");
		
		MobileElement password =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/password_edit_text"));
		password.sendKeys("zxc@MO123");
		
		MobileElement log_button =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
		log_button.click();
		
		//userInfo
		driver.findElementById("com.vnoders.spotify_el8alaba:id/settings_image_view").click();//setting
		String user_name = driver.findElementById("com.vnoders.spotify_el8alaba:id/user_name").getText();
		String user_name_toobar =driver.findElementById("com.vnoders.spotify_el8alaba:id/user_name_toobar").getText();;
		System.out.println(user_name);
		System.out.println(user_name_toobar);
		Assert.assertEquals(user_name, "mohamed");
		Assert.assertEquals(user_name_toobar, "mohamed");

		
}
	}
