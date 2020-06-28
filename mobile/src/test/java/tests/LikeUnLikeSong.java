package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;

public class LikeUnLikeSong extends BaseClass {
	@Test
	public void LikeSong() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		ExtentTest Test = extent.createTest("Like Song");
		Test.log(Status.INFO, "Like Song Test Started");
		System.out.println("Please Login...");
		WebDriverWait wait = new WebDriverWait(driver, 200);	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
		
		MobileElement Search = driver.findElement(By.id("com.spotify.music:id/search_tab"));
		Search.click();
		
		MobileElement SearchTab = driver.findElement(By.id("com.spotify.music:id/find_search_field"));
		SearchTab.setValue("Mohamed Mounir Mahmoum");
		System.out.println("Wrote Song name");
	
		MobileElement SongIcon = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]\r\n"));
		SongIcon.click();
		
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
		
		MobileElement LikedSongsPlaylist = driver.findElement(By.xpath("//android.widget.TextView[@text='"+"Liked Songs"+"']"));
		LikedSongsPlaylist.click();
		
		Thread.sleep(1000);
		if(driver.findElements(By.xpath("//android.widget.TextView[@text='"+"Mahmoum"+"']")).isEmpty())
		{
			System.out.println("like song Failed");
			Test.log(Status.FAIL, "Unlike song Failed");
		}
		else
		{
			MobileElement LikedSong = driver.findElement(By.xpath("//android.widget.TextView[@text='"+"Mahmoum"+"']"));
			LikedSong.click();
			System.out.println("Like song Passed");
			System.out.println("Found the Liked Song");
			Test.log(Status.PASS, "Like song Passed");
			
		}
		
	}
	
	@Test
	public void UnLikeSong() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		ExtentTest Test = extent.createTest("Unlike Song");
		Test.log(Status.INFO, "Unlike Song Test Started");
		
		MobileElement YourLibrary = driver.findElement(By.id("com.spotify.music:id/your_library_tab"));
		YourLibrary.click();
		
		MobileElement LikedSongsPlaylist = driver.findElement(By.xpath("//android.widget.TextView[@text='"+"Liked Songs"+"']"));
		LikedSongsPlaylist.click();
		
		MobileElement HeartButton = driver.findElement(By.xpath("(//android.widget.ImageButton[@content-desc=\"Stop liking this song\"])[1]"));
		HeartButton.click();
		
		Thread.sleep(1000);
		
		if(driver.findElements(By.xpath("//android.widget.TextView[@text='"+"Mahmoum"+"']")).isEmpty())
		{
			System.out.println("UnLike song Passed");
			Test.log(Status.PASS, "UnLike song Passed");
		}
		else
		{
			System.out.println("Unlike song Failed");	
			Test.log(Status.FAIL, "UnLike song Failed");
		}
		
	}

}


