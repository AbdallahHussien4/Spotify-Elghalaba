package tests;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;


public class SearchMySongs extends BaseClass{
	@Test
	public void UItest() {
		
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/footer_test")));
		driver.findElement(By.id("com.spotify.music:id/footer_test")).click();
		
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Search Liked Songs", "Sample test case for demo");
        // log(Status, details)
        test1.log(Status.INFO, "Search_Liked_Songs Test Started");
        
        //Your Library
        MobileElement YourLibrary = driver.findElement((By.id("com.spotify.music:id/your_library_tab")));
        YourLibrary.click();
        MobileElement LikedSongs = driver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout")));
        LikedSongs.click();
        
        MobileElement more = driver.findElement((By.id("com.spotify.music:id/glue_overflow")));
        more.click();
        
        MobileElement find = driver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")));
        find.click();
        
        MobileElement text = driver.findElement((By.id("com.spotify.music:id/edit_text_filter")));
        text.sendKeys("beleiver");
        test1.log(Status.PASS, "Searched for a song in Liked Songs");
        driver.navigate().back();
        driver.navigate().back();
}
}