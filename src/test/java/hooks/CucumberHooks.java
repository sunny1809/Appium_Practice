package hooks;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import stepDefinitions.Base;

public class CucumberHooks extends Base {
	
	@BeforeAll
	public static void StartTest() throws MalformedURLException, InterruptedException {
		
		System.out.println("Starting Test...");
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//000S2L744//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		// setting up UiAutomator2Options
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("soumyajit14");
		options.setUdid("emulator-5554");
		options.setAutomationName("UiAutomator2");
		options.setPlatformName("Android");
		options.setPlatformVersion("14");
		options.setAppPackage("com.google.android.calculator");
		options.setAppActivity("com.android.calculator2.Calculator");
				
		//Setting Url
        URL url = new URL("http://127.0.0.1:4723");

        //setting driver
        driver = new AndroidDriver(url,options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("application started");

	}
	
	@AfterAll
	public static void TearDown() {
		driver.quit();
		service.stop();
	}

}
