package com.org.flightCenter.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.org.flightCenter.config.Config;
import com.org.flightCenter.stepDefinitions.Hooks;
import com.org.flightCenter.util.GenericClass;

public class SearchFlight {

	static WebDriver driver;
	WebDriverWait wait;

	private static final String APP_URL = Config.getProperty("appURL");

	public SearchFlight() throws IOException {
		driver = Hooks.driver;
	}

	public void openApplication() {
		driver.get(APP_URL);
	}

	public void tripType() {
		driver.findElement(GenericClass.getbjectLocator("rdoTripType")).click();
	}

	public void enterFlyingFromLocation(String location) {
		try {
			driver.findElement(GenericClass.getbjectLocator("txtFlyingFrom")).sendKeys(location);

			WebElement fromList = driver.findElement(GenericClass.getbjectLocator("fromList"));
			Actions act1 = new Actions(driver);

			act1.moveToElement(fromList).perform();
			act1.sendKeys(Keys.DOWN).perform();
			Thread.sleep(2000);
			List<WebElement> allStates = driver
					.findElements(By.xpath("//div[@role='presentation']/div[@role='menu']/div"));
			// System.out.println(allStates.size());
			for (int i = 1; i <= allStates.size(); i++) {
				WebElement eachState = driver.findElement(By.xpath("//div[@role='presentation']/div[@role='menu']/div["
						+ i + "]//span/div//span[@class='destination-autocomplete-item__city']"));

				// System.out.println(eachState.getText());

				if (eachState.getText().contains(location)) {
					// a.sendKeys(eachState).perform();
					eachState.click();
					break;
				}

			}
		} catch (Exception e) {

		}
	}

	public void enterFlyingToLocation(String location) {
		try {
			driver.findElement(GenericClass.getbjectLocator("txtFlyingTo")).sendKeys(location);

			WebElement listTo = driver.findElement(GenericClass.getbjectLocator("toList"));
			Actions act2 = new Actions(driver);

			act2.moveToElement(listTo).perform();
			act2.sendKeys(Keys.DOWN).perform();
			Thread.sleep(2000);
			List<WebElement> allStates2 = driver
					.findElements(By.xpath("//div[@role='presentation']/div[@role='menu']/div"));
			// System.out.println(allStates2.size());
			for (int i = 1; i <= allStates2.size(); i++) {
				WebElement eachState = driver.findElement(By.xpath("//div[@role='presentation']/div[@role='menu']/div["
						+ i + "]//span/div//span[@class='destination-autocomplete-item__city']"));

				// System.out.println(eachState.getText());

				if (eachState.getText().trim().toLowerCase().contains(location.toLowerCase())) {
					// a.sendKeys(eachState).perform();
					eachState.click();
					break;
				}
			}
		} catch (Exception e) {

		}
	}

	public void clickonSearchFlight() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Search Flights')]")));
		driver.findElement(GenericClass.getbjectLocator("btnSearchFlights")).click();
	}

	public void verifyUserNavigatedtotheFlightResultsPage(String type) {
		try {
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
		}
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Departing')]")));
		Assert.assertTrue(driver.findElement(GenericClass.getbjectLocator("lblDepart")).isDisplayed());
		}
		catch(Exception e) {
			
		}
	}

	public void sortByCheapestFlight() {
		
	}

	public void selectCheapestFlight() {
		driver.findElement(GenericClass.getbjectLocator("btnCheapestFlight")).click();
		driver.findElement(GenericClass.getbjectLocator("btnSelect")).click();
	}

	public void verifyTotalFareisDisplayingCorrectly() {

	}

	public void verifyPageisRespondingWithinTime() {

	}

	public void verifySessionExpiryMessageisDisplaying() {

	}

	public void isFormDisplayed() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Layout and Presentation");
	}

	public void selectBreakfast(String item) {
		try {
			switch (item) {
			case "Orange Juice":
				driver.findElement(GenericClass.getbjectLocator("chkOrangeJuice")).click();
				break;
			default:
				driver.findElement(GenericClass.getbjectLocator("chkEggs")).click();
				break;
			}
		} catch (Exception e) {

		}
	}

	public void clickonAlertWindow() {
		driver.switchTo().alert().accept();
	}
}
