package tests;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;


public class HidePlaylist extends BaseClass{
	@Test
	public void UItest() {
		
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/footer_test")));
		driver.findElement(By.id("com.spotify.music:id/footer_test")).click();
		
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Hide Playlist Test", "Sample test case for demo");
        // log(Status, details)
        test1.log(Status.INFO, "Hide Playlist Test Started");
        
        //Your Library
        MobileElement YourLibrary = driver.findElement((By.id("com.spotify.music:id/your_library_tab")));
        YourLibrary.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout")));
        
        //Hide Playlist1
        MobileElement Playlist1 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout"));
        Playlist1.click();
        
        MobileElement More = driver.findElement(By.id("com.spotify.music:id/glue_overflow"));
        More.click();
        MobileElement Hide = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[6]"));
        Hide.click();
        test1.log(Status.PASS, "Hide Playlist1");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/glue_overflow")));
        More.click();
        
        test1.log(Status.PASS, "Check for Hide Playlist1");
        driver.navigate().back();
        driver.navigate().back();
       
        
        //Hide Playlist2
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.LinearLayout")));
        MobileElement Playlist2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.LinearLayout"));
        Playlist2.click();
        More.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[6]")));
        Hide.click();
        test1.log(Status.PASS, "Hide Playlist2");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/glue_overflow")));
        More.click();
        test1.log(Status.PASS, "Check for Hide Playlist2");
        driver.navigate().back();
        driver.navigate().back();
        
                
		test1.log(Status.PASS, "Hide Playlists checked");
		System.out.println("Hide Playlists test Completed...");       
}
}