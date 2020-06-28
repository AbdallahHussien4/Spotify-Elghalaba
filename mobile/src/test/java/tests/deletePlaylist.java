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

public class deletePlaylist extends BaseClass {
	@Test
	public void Delete(){
		ExtentTest test = extent.createTest("Delete Song in PlayList", "test");
		test.log(Status.INFO, "Test Delete PlayList Started");
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
	
		test.log(Status.PASS, "Check if playlist is empty");
		// check if there is no playlist
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Settings\"]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.ImageView[2]").click();
		MobileElement count_playlist = driver.findElementById("com.spotify.music:id/playlists_count");
		int count=Integer.parseInt(count_playlist.getText()); 
		test.log(Status.PASS, "Count is done");
		if(count ==0)
		{
			test.log(Status.PASS, "no previous playlist");
			driver.findElementById("com.spotify.music:id/your_library_tab").click();
			driver.findElementById("com.spotify.music:id/empty_view_button").click();
			MobileElement create_button=driver.findElementById("com.spotify.music:id/edit_text");
			create_button.sendKeys("test3");
			test.log(Status.PASS, "create playlist");
			driver.findElementById("com.spotify.music:id/continue_button").click();	
		}
		
		test.log(Status.PASS, "navigate to your libray");
		driver.findElementById("com.spotify.music:id/your_library_tab").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.spotify.music:id/labels").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		test.log(Status.PASS, "Detect a playist");
		
		driver.findElementById("com.spotify.music:id/glue_overflow").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		test.log(Status.PASS, "open playlist options");
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[4]").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElementById("com.spotify.music:id/button_positive").click();
		test.log(Status.PASS, "Delete playlist is done");
		
	}

}
