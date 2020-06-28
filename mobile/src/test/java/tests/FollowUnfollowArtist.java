package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class FollowUnfollowArtist extends BaseClass {
	
	@Test
	public void FollowArtist() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		ExtentTest Test = extent.createTest("Follow Artist");
		Test.log(Status.INFO, "Following Artist Test Started");
		System.out.println("Please Login...");
		WebDriverWait wait = new WebDriverWait(driver, 200);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
		
		MobileElement Search = driver.findElement(By.id("com.spotify.music:id/search_tab"));
		Search.click();
		
		MobileElement SearchTab = driver.findElement(By.id("com.spotify.music:id/find_search_field"));
		SearchTab.setValue("mohamed mounir");
		System.out.println("Wrote Mohamed Mounir");
	
		MobileElement ArtistIcon = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]\r\n"));
		ArtistIcon.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/txt_title")));
		
		//To click on the follow button.
		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(594,100))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))) 
		.release().perform();
		System.out.println("Pressed Follow");
		
		MobileElement YourLibrary = driver.findElement(By.id("com.spotify.music:id/your_library_tab"));
		YourLibrary.click();
		
		MobileElement Artists = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]"));
		Artists.click();
		
		Thread.sleep(1000);
		if(driver.findElements(By.xpath("//android.widget.TextView[@text='"+"Mohamed Mounir"+"']")).isEmpty())
		{
			
			System.out.println("Following Failed");
			Test.log(Status.FAIL, "Following Failed");
			
		}
		else
		{
			MobileElement FollowedArtist = driver.findElement(By.xpath("//android.widget.TextView[@text='"+"Mohamed Mounir"+"']"));
			FollowedArtist.click();
			System.out.println("Following Passed");
			System.out.println("Found the folloowing artist");
			Test.log(Status.PASS, "Following Passed");
		}
		
	}
	
	@Test
	public void UnFollowArtist() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		ExtentTest Test = extent.createTest("Unfollowing artist");
		Test.log(Status.INFO, "Unfollowing artist Test Started");
		
		MobileElement YourLibrary = driver.findElement(By.id("com.spotify.music:id/your_library_tab"));
		YourLibrary.click();
		
		MobileElement Artists = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]"));
		Artists.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/row_view")));
		
		MobileElement FollowedArtist = driver.findElement(By.xpath("//android.widget.TextView[@text='"+"Mohamed Mounir"+"']"));
		System.out.println("Found artist");
		
		//to make long press on the element.
		new TouchAction(driver)
		.longPress(new LongPressOptions()
		.withElement(ElementOption.element(FollowedArtist))
		.withDuration(Duration.ofSeconds(2)))
		.release()
		.perform();
		System.out.println("Pressed artist");
		
		MobileElement FollowButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]"));
		FollowButton.click();

		Thread.sleep(1000);
		if(driver.findElements(By.xpath("//android.widget.TextView[@text='"+"Mohamed Mounir"+"']")).isEmpty())
		{
			System.out.println("UnFollowing Passed");
			Test.log(Status.PASS, "Unfollowing passed");
		}
		else
		{
			System.out.println("UnFollowing Failed");
			System.out.println("Found the folloowing artist");
			Test.log(Status.FAIL, "Unfollowing failed");
		}

	}


}
