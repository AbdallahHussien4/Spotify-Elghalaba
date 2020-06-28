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
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class LikeUnlikeAlbum extends BaseClass {
	
	
	@Test
	public void LikeAlbum() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		ExtentTest Test = extent.createTest("Like Album");
		Test.log(Status.INFO, "Like Album Test Started");
		System.out.println("Please Login...");
		WebDriverWait wait = new WebDriverWait(driver, 200);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
		
		MobileElement Search = driver.findElement(By.id("com.spotify.music:id/search_tab"));
		Search.click();
		
		MobileElement SearchTab = driver.findElement(By.id("com.spotify.music:id/find_search_field"));
		SearchTab.setValue("ya ahl elarab we");
		System.out.println("Wrote Album name");
	
		MobileElement AlbumIcon = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]\r\n"));
		AlbumIcon.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Like\"]\r\n")));
		
		//Check the color of the heart button
		if(driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Unlike\"]\r\n")).isEmpty())
		{
			System.out.println("Before pressing on the heart :the Heart is Black");
			Test.log(Status.PASS, "Before pressing on the heart :the Heart is Black ");
		}
		else
		{
			System.out.println("Before pressing on the heart :the Heart is Green");
			Test.log(Status.FAIL, "Before pressing on the heart :the Heart is Green ");
		}
		
		MobileElement LikeButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Like\"]\r\n"));
		LikeButton.click();
		System.out.println("Pressed Like");
		
		if(driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Like\"]\r\n")).isEmpty())
		{
			System.out.println("after pressing on the heart :the Heart is Black");
			Test.log(Status.FAIL, "Before pressing on the heart :the Heart is Black ");
		}
		else
		{
			System.out.println("after pressing on the heart :the Heart is Green");
			Test.log(Status.PASS, "Before pressing on the heart :the Heart is Green ");
		}
		
		MobileElement YourLibrary = driver.findElement(By.id("com.spotify.music:id/your_library_tab"));
		YourLibrary.click();
		
		MobileElement Albums = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[3]\r\n" ));
		Albums.click();
		
		Thread.sleep(1000);
		if(driver.findElements(By.xpath("//android.widget.TextView[@text='"+"Ya Ahl El Arab Wel Tarab"+"']")).isEmpty())
		{
			
			System.out.println("Like Album Failed");
			Test.log(Status.FAIL, "Like albums failed");
			
		}
		else
		{
			MobileElement FollowedArtist = driver.findElement(By.xpath("//android.widget.TextView[@text='"+"Ya Ahl El Arab Wel Tarab"+"']"));
			FollowedArtist.click();
			System.out.println("Like Album Passed");
			System.out.println("Found the Liked album");
			Test.log(Status.PASS, "Like Album Passed");
		}
		
	}
	
	@Test
	public void UnLikeAlbum() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		ExtentTest Test = extent.createTest("UnLike Album");
		Test.log(Status.INFO, "UnLike Album Test Started");
		
		MobileElement YourLibrary = driver.findElement(By.id("com.spotify.music:id/your_library_tab"));
		YourLibrary.click();
		
		MobileElement Albums = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[3]\r\n" ));
		Albums.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/row_view")));
		
		MobileElement LikedAlbum = driver.findElement(By.xpath("//android.widget.TextView[@text='"+"Ya Ahl El Arab Wel Tarab"+"']"));
		
		//to make long press on the element.
		new TouchAction(driver)
		.longPress(new LongPressOptions()
		.withElement(ElementOption.element(LikedAlbum))
		.withDuration(Duration.ofSeconds(2)))
		.release()
		.perform();
		System.out.println("Pressed Album");
	
		MobileElement UnlikeButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]"));
		UnlikeButton.click();
		
		Thread.sleep(1000);
		if(driver.findElements(By.xpath("//android.widget.TextView[@text='"+"Ya Ahl El Arab Wel Tarab"+"']")).isEmpty())
		{
			System.out.println("Unlike Album Passed");
			Test.log(Status.PASS, "UnLike Album Passed");
		}
		else
		{
			System.out.println("Unlike Album Failed");
			System.out.println("Found the Liked Album");
			Test.log(Status.FAIL, "UnLike Album Failed");
		}

	}

}
