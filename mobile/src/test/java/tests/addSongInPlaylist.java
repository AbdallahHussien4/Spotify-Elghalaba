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
public class addSongInPlaylist extends BaseClass {
	@Test
	public void Addsong(){
	ExtentTest test = extent.createTest("Add Song in PlayList", "test");
	
	WebDriverWait wait = new WebDriverWait(driver, 200);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc=\"Settings\"]")));
	
	test.log(Status.INFO, "Test Add Song in PlayList Started");
	
	// check if there is no playlist
	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Settings\"]").click();
	test.log(Status.PASS, "Check if playlist is empty");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.ImageView[2]").click();
	MobileElement count_playlist = driver.findElementById("com.spotify.music:id/playlists_count");
	test.log(Status.PASS, "Count playlist done");
	
	int count=Integer.parseInt(count_playlist.getText()); 
	test.log(Status.PASS, "Count playlist done");
	if(count ==0)
	{
		test.log(Status.PASS, "There is no playlist to delete");
		driver.findElementById("com.spotify.music:id/your_library_tab").click();
		driver.findElementById("com.spotify.music:id/empty_view_button").click();
		MobileElement create_button=driver.findElementById("com.spotify.music:id/edit_text");
		test.log(Status.PASS, "Creat playlist is done");
		create_button.sendKeys("test3");
		test.log(Status.PASS, "Create playlist successfully");
		driver.findElementById("com.spotify.music:id/continue_button").click();	
	}
	test.log(Status.PASS, "navigate to playlist");
	driver.findElementById("com.spotify.music:id/your_library_tab").click();
	test.log(Status.PASS, "navigate to your library");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("com.spotify.music:id/labels").click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElementById("com.spotify.music:id/glue_overflow").click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	test.log(Status.PASS, "Go To playlist options ");
	
	driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]").click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElementByXPath("(//android.widget.ImageButton[@content-desc=\"Add song to playlist.\"])[1]").click();		
	test.log(Status.PASS, "Add Song to playlist successfully");
	
	}
	
}
