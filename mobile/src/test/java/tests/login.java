package tests;
import java.util.concurrent.TimeUnit;
import tests.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;

public class login extends BaseClass {

	@Test
	public void log_in(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//for splash screen
		
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Login Test", "Sample test case for demo");
        // log(Status, details)
        test1.log(Status.INFO, "Login Test Started");
		
		MobileElement login_s =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
		login_s.click();
		
		MobileElement email =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/email_edit_text"));
		email.sendKeys("mohamed.sayed8899@gmail.com");
		
		MobileElement password =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/password_edit_text"));
		password.sendKeys("zxc@MO123");
		
		
		MobileElement log_button =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/Login_button"));
		log_button.click();	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//wait for response
		driver.findElementById("com.vnoders.spotify_el8alaba:id/settings_image_view").click();//to get check I accesss home 
		test1.log(Status.PASS, "Login tmam");
		
	}
}
