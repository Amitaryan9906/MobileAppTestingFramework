package Demo.AppiumFramework;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Capability {

	public static String devicename;
	public static String platformname;
	public static String apppackage;
	public static String appactivity;
	public static String chromedriver;
	public  AppiumDriverLocalService service;
	
	
	public  AppiumDriverLocalService startAppium() {
		
		service= AppiumDriverLocalService.buildDefaultService();
		service.start();
		return service;
		
	}
	 public  void stopAppium() {
	        if (service != null) {
	            service.stop();
	        }
	    }
	
	public static void startEmulator() throws IOException, InterruptedException {
    Runtime.getRuntime().exec("C:\\Users\\dell\\Desktop\\emulator.bat");
    Thread.sleep(30000);
	}
	
	
	
	
	public static AndroidDriver<AndroidElement> capability(String devicename,String platformname,String apppackage,String appactivity,String chromedriver) throws IOException, InterruptedException {
		
		
//		 This will fetch the data frome globle properties
		
		FileReader  reader=new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		
		Properties ps = new Properties();
		ps.load(reader);
		
		devicename=ps.getProperty("deviceName");
		platformname=ps.getProperty("platformName");
		apppackage=ps.getProperty("apppakage");
		appactivity=ps.getProperty("appactivity");
		chromedriver=ps.getProperty("chromeexecutable");
		
		
		
		DesiredCapabilities dc= new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apppackage);
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appactivity);
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
	    dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromedriver);
	    
	    if(devicename.contains("Aryan")) {
	    	startEmulator();
	    }
	    
	    AndroidDriver<AndroidElement> driver =new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		return driver;
	}
}
