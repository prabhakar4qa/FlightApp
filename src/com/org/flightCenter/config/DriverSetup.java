package com.org.flightCenter.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverSetup {

	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static WebDriver setupDriver() {
		
/*		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		return driver;
*/		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--enable-popup-blocking");
		options.addArguments("--no-sandbox");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--disable-infobars");

		capabilities.setCapability("chrome.binary", "C:\\Users\\Prabhakar\\Softwares\\chromedriver_win32\\chromedriver.exe");
		capabilities.setCapability("ChromeOptions.CAPABILITY", options);
		driver = new ChromeDriver(capabilities);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
}
