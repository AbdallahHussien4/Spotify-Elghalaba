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

public class AudioPlayerPlayPause extends BaseClass {
	
	@Test
	public void PlayPause() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS); 
		ExtentTest Test = extent.createTest("Audio Player");
		Test.log(Status.INFO, "Play and pause Buttons Test Started");
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
		
		Thread.sleep(3000);
		if(driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Pause\"]")).isEmpty())
		{
			System.out.println("The Song is pausing");
			Test.log(Status.FAIL, "Firslty Song is Pausing");
		}
		else
		{
			System.out.println("The Song is playing");
			Test.log(Status.PASS, "Firslty Song is playing");
		}
		
		MobileElement PlayPauseButton = driver.findElement(By.id("com.spotify.music:id/play_pause_button"));
		PlayPauseButton.click();
		System.out.println("Pressing on the play/pause button");
		
		Thread.sleep(3000);
		if(driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Play\"]")).isEmpty())
		{
			System.out.println("The Song is Playing");
			Test.log(Status.FAIL, "After click on the button the Song is playing");
		}
		else
		{
			System.out.println("The Song is Pausing");
			Test.log(Status.PASS, "After click on the button the Song is pausing");
		}
		
		PlayPauseButton.click();
		System.out.println("Pressing on the play/pause button Again");
		
		Thread.sleep(3000);
		if(driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Pause\"]")).isEmpty())
		{
			System.out.println("The Song is Pausing");
			Test.log(Status.FAIL, "After clicking again on the button the Song is pausing");
		}
		else
		{
			System.out.println("The Song is Playing");
			Test.log(Status.PASS, "After click on the button the Song is playing");
		}
		
		System.out.println("Play/Pause Button Works Correctly");
		Test.log(Status.PASS, "Play/Pause Button works correctly");

	}
	
}
