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

public class renamePlaylist extends BaseClass {

	@Test
	public void Rename(){
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
		
		ExtentTest test = extent.createTest("Rename PlayList", "test");
		test.log(Status.INFO, "Test Rename Playlist Started");
		
		test.log(Status.PASS, "Check if there is previous Playlist or Not");
		// check if there is no playlist
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Settings\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.ImageView[2]").click();
		MobileElement count_playlist = driver.findElementById("com.spotify.music:id/playlists_count");
		test.log(Status.PASS, "Count is done");
		int count=Integer.parseInt(count_playlist.getText()); 
		if(count ==0)
		{
			test.log(Status.PASS, "There is no playlist existed ");
			driver.findElementById("com.spotify.music:id/your_library_tab").click();
			driver.findElementById("com.spotify.music:id/empty_view_button").click();
			MobileElement create_button=driver.findElementById("com.spotify.music:id/edit_text");
			create_button.sendKeys("test3");
			test.log(Status.PASS, "Create Playlist is done");
			driver.findElementById("com.spotify.music:id/continue_button").click();	
		}
		
		test.log(Status.PASS, "Navigate to your Playlists");
		driver.findElementById("com.spotify.music:id/your_library_tab").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.spotify.music:id/labels").click();
		test.log(Status.PASS, "Detect Playlist");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElementById("com.spotify.music:id/glue_overflow").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		test.log(Status.PASS, "Open Playlist options");
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[3]").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
		MobileElement text = driver.findElementById("com.spotify.music:id/edit_text");
		text.clear();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		text.sendKeys("Rename_playlist");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElementById("com.spotify.music:id/continue_button").click();
		test.log(Status.PASS, "Rename Playlist is done");
		
		test.log(Status.INFO, "Test Rename Playlist ended");
	
	}
	
	
}
