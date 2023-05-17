package Demo.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestHybridApp extends Capability{

	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest(enabled = false)
	public void bt() throws IOException, InterruptedException {
		driver = capability(devicename,platformname,apppackage,appactivity,chromedriver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled = false)
	public void tc1() {
    driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")).click();
    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
    driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}
	
	@Test
	public void test3() throws IOException, InterruptedException {
		service=startAppium();
	
		driver = capability(devicename,platformname,apppackage,appactivity,chromedriver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	    driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))")).click();
	    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
	    driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    

int elements = driver.findElements(By.id("com.androidsample.generalstore:id/productImage")).size();
 System.out.println(elements);
 
 driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
 
 driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
 
 driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

//  This line for stop the appium server
//service.stop();
// stopAppium();
driver.closeApp();
driver.quit();
	}
}
