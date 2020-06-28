package tests;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;

public class Search extends BaseClass{
	@Test
	public void UItest() {
		
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/footer_test")));
		driver.findElement(By.id("com.spotify.music:id/footer_test")).click();
		
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Search Test", "Sample test case for demo");
        // log(Status, details)
        test1.log(Status.INFO, "Search Test Started");
        
        //Search
        MobileElement Search = driver.findElement((By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]")));
        Search.click();
        
        MobileElement SearchBar = driver.findElement(By.id("com.spotify.music:id/find_search_field_text"));
		SearchBar.click();
		
		//Search for artist
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.spotify.music:id/query")));
		MobileElement SearchText = driver.findElement(By.id("com.spotify.music:id/query"));
		SearchText.sendKeys("amr diab");
		MobileElement result = driver.findElement(By.id("com.spotify.music:id/row_view"));
		result.click();
		driver.navigate().back();
		SearchText.clear();
		test1.log(Status.PASS, "Search for artist");
		
		
		//Search for artist playlists
		SearchText.sendKeys("amr diab playlist");
		SearchText.clear();
		driver.navigate().back();
		test1.log(Status.PASS, "Search for playlist");
		
		test1.log(Status.PASS, "Search artist-Search playlist");
		System.out.println("Search_Test Completed...");
}
}
