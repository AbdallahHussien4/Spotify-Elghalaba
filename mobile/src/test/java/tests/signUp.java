package tests;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tests.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;

public class signUp extends BaseClass{
	
	@Test 
	public void sign_Up(){
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//for splash screen
		MobileElement sign_up_button =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/sign_up_button"));
		sign_up_button.click();
		
		//email
		MobileElement email =driver.findElement(By.id("email_edit_text"));
		email.clear();
		email.setValue("mohamed.sayed13111@hotamil.com");
		MobileElement next =driver.findElement(By.id("com.vnoders.spotify_el8alaba:id/next_button"));
		next.click();
		
		//password
		MobileElement pass =driver.findElement(By.id("password_edit_text"));
		pass.setValue("zxc@MO123");
		driver.findElementById("com.vnoders.spotify_el8alaba:id/next_button").click();
		
		//date
		List<MobileElement> pickerEls=driver.findElementsById("android:id/numberpicker_input");
		System.out.println(pickerEls.get(2).getText());
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//for splash screen
		pickerEls.get(2).clear();
		pickerEls.get(2).click();
		pickerEls.get(2).sendKeys("1990");
		pickerEls.get(1).click();
		pickerEls.get(1).sendKeys("11");
		pickerEls.get(1).click();
		
     	driver.findElementById("com.vnoders.spotify_el8alaba:id/birthdate_signup_fragment");
		driver.findElementById("com.vnoders.spotify_el8alaba:id/next_button").click();
		
		//gender
		MobileElement  gender_e =driver.findElementById("com.vnoders.spotify_el8alaba:id/gender_male");
		String gender=gender_e.getText();
		System.out.println(gender);
		gender_e.click(); //choose female!!!

		//type
		MobileElement type_e=driver.findElementById("com.vnoders.spotify_el8alaba:id/user");
		String type=type_e.getText();
		System.out.println(type);
		type_e.click(); //choose artist
		
		//name
		driver.findElementById("com.vnoders.spotify_el8alaba:id/name_create_account").setValue("mohamed");
		driver.findElementById("com.vnoders.spotify_el8alaba:id/create_button").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//for response
		driver.findElementById("com.vnoders.spotify_el8alaba:id/settings_image_view").click();//setting
		
	} 

}
