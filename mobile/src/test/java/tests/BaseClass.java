package tests;
import java.net.URL;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseClass extends ExtentReportsDemo {
	
	static AppiumDriver<MobileElement> driver;
	@BeforeTest
		public void setup() {	
			try {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", "Xperia™ Z3 Dual");
				cap.setCapability("udid", "CB5A27TYAC");
				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "6");
				//cap.setCapability("appPackage", "com.vnoders.spotify_el8alaba");
				//cap.setCapability("appActivity","com.vnoders.spotify_el8alaba.SplashActivity");
				cap.setCapability("appPackage", "com.spotify.music");
				cap.setCapability("appActivity", "com.spotify.music.MainActivity");
				//cap.setCapability("automationName", "UiAutomator2");
				URL url =new URL ("http://127.0.0.1:4723/wd/hub");
				driver = new AppiumDriver<MobileElement>(url,cap);
				System.out.println("Apllication is starting ............");
			}
			catch(Exception ex) 
			{
				System.out.println("Cause is: "+ex.getCause());
				System.out.println("Message is "+ex.getMessage());
				ex.printStackTrace();	
			}
		}
	    
	
	
}
