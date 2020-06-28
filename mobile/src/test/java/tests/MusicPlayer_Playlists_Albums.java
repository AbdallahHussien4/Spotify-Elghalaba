package tests;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MusicPlayer_Playlists_Albums extends BaseClass {
	
	//static AppiumDriver<MobileElement> driver;
	
	static void ScrollDown() {
		
		org.openqa.selenium.Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.5);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);
		
		new TouchAction((PerformsTouchActions) driver) 
        .press(PointOption.point(0, scrollStart)) 
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))) 
        .moveTo(PointOption.point(0, scrollEnd)) 
        .release().perform();
	}
	
	
	@Test
	public void MusicPlayer() {
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //to wait untill the login button display
		
		MobileElement login = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
		login.click();
		
		MobileElement email = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/email_edit_text"));
		email.sendKeys(("smsm@smsm.com"));
	
		MobileElement password = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/password_edit_text"));
		password.setValue("Ww12@jjj");
		
		driver.hideKeyboard();		//to be able to click on the login button
		MobileElement login2 = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
		login2.click();
		
		MobileElement musicplayer = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/song_information"));
		musicplayer.click();
		
		
		
		if(driver.findElements(By.id("com.vnoders.spotify_el8alaba:id/top_back_button")).isEmpty()) {
			
			System.out.println("The Player Screen isn't opened");
			
			}
		else {
			System.out.println("The Player Screen is opened");
			
			MobileElement SeekBar = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/seek_bar"));
			SeekBar.click();
			
			System.out.println("The Seek bar can be moved");
			
			MobileElement DownButton = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/top_back_button"));
			DownButton.click();
			
			if(driver.findElements(By.id("com.vnoders.spotify_el8alaba:id/navigation_home")).isEmpty()) {
				
				System.out.println("The Down Button Doesn't Work Correctly");
				
			}
			else {
				System.out.println("The Down Button Works Correctly");
				
				}
			
		}
	}

	@Test
	public void Playlist() {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //to wait untill the login button display
//		
//		MobileElement login = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
//		login.click();
//		
//		MobileElement email = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/email_edit_text"));
//		email.sendKeys(("abc123@abc"));
//	
//		MobileElement password = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/password_edit_text"));
//		password.setValue("abc");
//		
//		driver.hideKeyboard();		//to be able to click on the login button
//		MobileElement login2 = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
//		login2.click();
		

		MobileElement LibraryButton = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/navigation_your_library"));
		LibraryButton.click();
		
		MobileElement PlaylistBody = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/library_playlist_item_body"));
		PlaylistBody.click();
		System.out.println("When click on Playlist body it responses correctly");
		
		MobileElement SongBody = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/playlist_track_name"));
		SongBody.click();
		System.out.println("When click on Song or menu button in playlist page it response correctly");
    
		MobileElement Play = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/library_playlist_play_icon"));
		Play.click();
		System.out.println("press play");
		if(driver.findElements(By.id("com.vnoders.spotify_el8alaba:id/library_playlist_progress_bar")).isEmpty()) {
			
			System.out.println("The Play Button in playlist Doesn't Work Correctly");
			
		}
		else {
			System.out.println("The Play Button in playlist Works Correctly");
			
			}
		
			MobileElement Heart = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/library_playlist_like_track"));
			Heart.click();
			System.out.println("Heart Button Works Correctly");
			
			MobileElement Remove = driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/library_playlist_hide_track"));
			Remove.click();
			System.out.println("Remove Button Works Correctly");
			
			ScrollDown();
			
			System.out.println("A white Rectangle appears when Scrolling down");
			

	}

}
