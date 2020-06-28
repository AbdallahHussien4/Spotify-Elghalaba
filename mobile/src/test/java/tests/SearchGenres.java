package tests;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;

public class SearchGenres extends BaseClass{
	@Test
	public void UItest() {
		
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/footer_test")));
		driver.findElement(By.id("com.spotify.music:id/footer_test")).click();
		
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Search Test", "Sample test case for demo");
        // log(Status, details)
        test1.log(Status.INFO, "Search by Genres Test Started");
        
        //Search
        MobileElement Search = driver.findElement((By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")));
        Search.click();
        
        //NewReleases genre
        MobileElement NewRelease = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.widget.TextView"));
        NewRelease.click();
        driver.navigate().back();
        test1.log(Status.PASS, "Search by NewReleases genre");
        
        //Charts genre
        MobileElement Charts = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.FrameLayout"));
        Charts.click();
        driver.navigate().back();
        test1.log(Status.PASS, "Search by Charts genre");
        
        //Pop genre
        MobileElement Pop = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout"));
        Pop.click();
        driver.navigate().back();
        test1.log(Status.PASS, "Search by Pop genre");
        
		test1.log(Status.PASS, "Search by Genres");
		System.out.println("Search_Genres Completed...");
}
}
