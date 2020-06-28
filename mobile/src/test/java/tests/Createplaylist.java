package tests;
import java.util.concurrent.TimeUnit;
import tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
public class Createplaylist extends BaseClass{
	@Test
	public void Create_playlist(){
		ExtentTest test = extent.createTest("Add Song in PlayList", "test");
		test.log(Status.INFO, "Test Create PlayList Started");
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Settings\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.ImageView[2]").click();
		MobileElement count_playlist = driver.findElementById("com.spotify.music:id/playlists_count");
		int count=Integer.parseInt(count_playlist.getText()); 
		test.log(Status.PASS, "Count playlist done");
		if(count >0)
		{
			test.log(Status.PASS, "There is already playlists");
			driver.findElementById("com.spotify.music:id/your_library_tab").click();
			test.log(Status.PASS, "Navigate to your Library");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout").click();
			driver.findElementById("com.spotify.music:id/edit_text").sendKeys("testspotify");
			 test.log(Status.PASS, "Create Playlist from Regular Button");
			driver.findElementById("com.spotify.music:id/continue_button").click();
		}
		else
		{
			test.log(Status.PASS, "Create playlist from Primary Button");
			driver.findElementById("com.spotify.music:id/your_library_tab").click();
			driver.findElementById("com.spotify.music:id/empty_view_button").click();
			MobileElement create_button=driver.findElementById("com.spotify.music:id/edit_text");
			create_button.sendKeys("test3");
			 test.log(Status.PASS, "Create Playlist is Done");
			driver.findElementById("com.spotify.music:id/continue_button").click();	
			
		}
		test.log(Status.INFO, "Test Create PlayList Ended");

	}



}
