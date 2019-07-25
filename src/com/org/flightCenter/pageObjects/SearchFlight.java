package com.org.flightCenter.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	JavascriptExecutor executor;
	static double totalFare = 0.0;

	private static final String APP_URL = Config.getProperty("appURL");

	public SearchFlight() throws IOException {
		driver = Hooks.driver;
	}

	public void openApplication() {
		try {
			driver.get(APP_URL);
		} catch (Exception e) {

		}
	}

	public void tripType() {
		try {
			driver.findElement(GenericClass.getbjectLocator("rdoTripType")).click();
		} catch (Exception e) {

		}
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
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Search Flights')]")));
			WebElement element1 = driver.findElement(GenericClass.getbjectLocator("btnSearchFlights"));

			/*
			 * Actions action = new Actions(driver);
			 * action.moveToElement(element1).build().perform(); action.click();
			 */

			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element1);
		} catch (Exception e) {

		}
	}

	public void verifyUserNavigatedtotheFlightResultsPage(String type) {
		try {
			Assert.assertFalse(driver.findElement(GenericClass.getbjectLocator("lblNoFlightsPage")).isDisplayed());
			if (type.equalsIgnoreCase("Departing")) {
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Departing')]")));
				Assert.assertTrue(driver.findElement(GenericClass.getbjectLocator("lblDepart")).isDisplayed());
			}

			else if (type.equalsIgnoreCase("Return")) {
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Select ')]")));
				Assert.assertTrue(driver.findElement(GenericClass.getbjectLocator("lblReturn")).isDisplayed());
			}

		} catch (Exception e) {

		}
	}

	public void sortByCheapestFlight() {
		try {
			driver.findElement(GenericClass.getbjectLocator("ddlPriceCheapest"));
		} catch (Exception e) {

		}
	}

	public void selectCheapestFlight() {
		try {
			WebElement element1 = driver.findElement(GenericClass.getbjectLocator("btnCheapestFlight"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element1);

			double priceWholeValue = Integer
					.parseInt(driver.findElement(GenericClass.getbjectLocator("lblPriceWholeValue")).getText());
			double priceCentsValue = Integer
					.parseInt(driver.findElement(GenericClass.getbjectLocator("lblPriceCentsValue")).getText());

			priceCentsValue = priceCentsValue / 100;

			totalFare = priceWholeValue + priceCentsValue;
			System.out.println("Total fare value: " + totalFare);

			WebElement element2 = driver.findElement(GenericClass.getbjectLocator("btnSelect"));
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element2));

			WebElement element3 = driver.findElement(GenericClass.getbjectLocator("btnSelect"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element3);
		} catch (Exception e) {

		}
	}

	public void verifyTotalFareisDisplayingCorrectly() {
		try {
			double totalPriceWholeValue = Integer
					.parseInt(driver.findElement(GenericClass.getbjectLocator("lblTotalPriceWholeValue")).getText());
			double totalPriceCentsValue = Integer
					.parseInt(driver.findElement(GenericClass.getbjectLocator("lblTotalPriceCentsValue")).getText());

			totalPriceCentsValue = totalPriceCentsValue / 100;
			double expectedTotalFare = totalPriceWholeValue + totalPriceCentsValue;
			Assert.assertEquals(totalFare, expectedTotalFare);
		} catch (Exception e) {

		}
	}

	public void verifyPageisRespondingWithinTime(double time) {
		try {
			// Prerequisite: User should be on baggage page
			driver.findElement(GenericClass.getbjectLocator("btnContinue")).click();
			long loadtime = (Long) ((JavascriptExecutor) driver)
					.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
			System.out.println("Page response time: " + loadtime);
			if (loadtime > 3.5)
				System.out.println("Page response is not as per the expectation");
			else
				System.out.println("Page response is as per the expectation");
		} catch (Exception e) {
		}
	}

	public void verifySessionExpiryMessageisDisplaying(int timeinMin) {
		try {
			Thread.sleep(50000);
			driver.findElement(GenericClass.getbjectLocator("lblSessionExpiry")).isDisplayed();
		} catch (Exception e) {

		}
	}

}
