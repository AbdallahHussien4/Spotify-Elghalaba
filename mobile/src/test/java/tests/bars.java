package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class bars extends BaseClass {
	@Test
	public void log_in(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//for splash screen
		MobileElement login_s =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
		login_s.click();
		
		MobileElement email =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/email_edit_text"));
		email.sendKeys("mohamed.sayed8899@gmail.com");
		
		MobileElement password =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/password_edit_text"));
		password.sendKeys("zxc@MO123");
		
		MobileElement log_button =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
		log_button.click();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<MobileElement> icons=driver.findElementsById("com.vnoders.spotify_el8alaba:id/icon");
		
		icons.get(1).click();//search
		String search=driver.findElementById("com.vnoders.spotify_el8alaba:id/text").getText();
		if(search!="Search")
			Assert.assertEquals(search, "Search");
		
		icons.get(2).click();//your library

		String music=driver.findElementById("com.vnoders.spotify_el8alaba:id/title").getText();
		if(music!="Music")
			Assert.assertEquals(music, "Music");
		
		icons.get(0).click();//home
		
	}
}
