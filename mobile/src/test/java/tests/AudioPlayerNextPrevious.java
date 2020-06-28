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

public class AudioPlayerNextPrevious extends BaseClass {
	
	@Test
	public void NextButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		ExtentTest Test = extent.createTest("Audio Player");
		Test.log(Status.INFO, "Next Button Test Started");
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
		
		MobileElement FirstSongName = driver.findElement(By.id("com.spotify.music:id/marquee_track_info_view_title"));
		String FirstSong=FirstSongName.getText();
		
		Thread.sleep(3000);
		
		MobileElement NextButton = driver.findElement(By.id("com.spotify.music:id/next_button"));
		NextButton.click();
		System.out.println("Pressing on the next button");
		
		MobileElement SecondSongName = driver.findElement(By.id("com.spotify.music:id/marquee_track_info_view_title"));
		String SecondSong=SecondSongName.getText();
		
		System.out.println(FirstSong);
		System.out.println(SecondSong);
		if(FirstSong==SecondSong)
		{
			System.out.println("Next Button doesn't Work Correctly");
			Test.log(Status.FAIL, "Next Button Doesn't work correctly");
		}
		else
		{
			System.out.println("Next Button Works Correctly");
			Test.log(Status.PASS, "Next Button works correctly");
		}
		
	}
	
	
}
