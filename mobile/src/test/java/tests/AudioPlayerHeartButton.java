package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AudioPlayerHeartButton extends BaseClass {

	@Test
	public void HeartButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		ExtentTest Test = extent.createTest("Audio Player");
		Test.log(Status.INFO, "Heart Button Test Started");
		System.out.println("Please Login...");
		WebDriverWait wait = new WebDriverWait(driver, 200);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
	
		MobileElement Search = driver.findElement(By.id("com.spotify.music:id/search_tab"));
		Search.click();
		
		MobileElement SearchTab = driver.findElement(By.id("com.spotify.music:id/find_search_field"));
		SearchTab.setValue("This Is Mohamed Mounir");
	
		Thread.sleep(1000);
		MobileElement PlaylistIcon = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]\r\n"));
		PlaylistIcon.click();
		
		MobileElement ShufflePlay = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button\r\n"));
		ShufflePlay.click();
		
		MobileElement PlayerBar = driver.findElement(By.id("com.spotify.music:id/now_playing_bar_layout"));
		PlayerBar.click();
		
		MobileElement HeartButton = driver.findElement(By.id("com.spotify.music:id/heart_button"));
		HeartButton.click();
		
		MobileElement SongName = driver.findElement(By.id("com.spotify.music:id/marquee_track_info_view_title"));
		String Song=SongName.getText();
		
		MobileElement DropDown = driver.findElement(By.id("com.spotify.music:id/close_button"));
		DropDown.click();
		
		MobileElement YourLibrary = driver.findElement(By.id("com.spotify.music:id/your_library_tab"));
		YourLibrary.click();
		
		MobileElement LikedSongsPlaylist = driver.findElement(By.xpath("//android.widget.TextView[@text='"+"Liked Songs"+"']"));
		LikedSongsPlaylist.click();
		
		System.out.println(Song);
		
		Thread.sleep(1000);
		if(driver.findElements(By.xpath("//android.widget.TextView[@text='"+Song+"']")).isEmpty())
		{
			System.out.println("like song Failed");
			Test.log(Status.FAIL, "Like Song Failed");
		}
		else
		{
			MobileElement LikedSong = driver.findElement(By.xpath("//android.widget.TextView[@text='"+Song+"']"));
			LikedSong.click();
			System.out.println("Like song Passed");
			System.out.println("Found the Liked Song");
			Test.log(Status.PASS, "Like Song Passed");
		}

	//Unlike the song
		PlayerBar.click();
		HeartButton.click();
		DropDown.click();
		
		Thread.sleep(1000);
		if(driver.findElements(By.xpath("//android.widget.TextView[@text='"+Song+"']")).isEmpty())
		{
			System.out.println("Unlike song Passed");
			Test.log(Status.PASS, "Unlike Song Passed ");
		}
		else
		{
			System.out.println("Unlike song Failed");
			Test.log(Status.PASS, "Unlike Song Failed");
		}
	}
}
