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
public class removeSongFromPlaylist extends  BaseClass {
	@Test
	public void remove(){
		ExtentTest test = extent.createTest("Remove Song from PlayList", "test");
		test.log(Status.INFO, "Test Remove Song from PlayList Started");
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
		// check if there is no playlist
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Settings\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.ImageView[2]").click();
		MobileElement count_playlist = driver.findElementById("com.spotify.music:id/playlists_count");
		test.log(Status.PASS, "Check if there is playlist existed or not");
		
		int count=Integer.parseInt(count_playlist.getText()); 
		test.log(Status.PASS, "Count Playlist is Done!");
		if(count ==0)
		{
			test.log(Status.PASS, "There is no previuos playlist");
			driver.findElementById("com.spotify.music:id/your_library_tab").click();
			driver.findElementById("com.spotify.music:id/empty_view_button").click();
			MobileElement create_button=driver.findElementById("com.spotify.music:id/edit_text");
			create_button.sendKeys("addPlaylist");
			test.log(Status.PASS, "Creat Playlist is Done!");
			driver.findElementById("com.spotify.music:id/continue_button").click();
		}
		test.log(Status.PASS, "Navigate to yourlibraries");
		driver.findElementById("com.spotify.music:id/your_library_tab").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElementById("com.spotify.music:id/labels").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		test.log(Status.PASS, "Add song first");
		
		driver.findElementById("com.spotify.music:id/glue_overflow").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		test.log(Status.PASS, "Choose the created Song");
		driver.findElementByXPath("(//android.widget.ImageButton[@content-desc=\"Add song to playlist.\"])[1]").click();		
		
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Close\"]").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		test.log(Status.PASS, "Go to Song options");
		driver.findElementById("com.spotify.music:id/title").click();
		driver.findElementByXPath("(//android.widget.ImageButton[@content-desc=\"Show context menu\"])[1]").click();
		
	
		driver.findElementByXPath("	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[2]").click();
		test.log(Status.PASS, "Delete song is done!");
	
		test.log(Status.INFO, "Test Remove Song from PlayList ended");
		
	}
	
	
}
