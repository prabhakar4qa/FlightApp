package com.org.flightCenter.stepDefinitions;

import com.org.flightCenter.pageObjects.SearchFlight;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	SearchFlight sf;

	public StepDefinitions() {
		try {
			sf = new SearchFlight();
		} catch (Exception e) {

		}
	}

	
	@Given("^User open the application$")
	public void user_open_the_application() throws Throwable {
		sf.openApplication();
	}

	@When("^Click on Return option$")
	public void click_on_Return_option() {
		sf.tripType();
	}

	@When("^Enter Flying from \"([^\"]*)\" domestic location$")
	public void enter_Flying_from_domestic_location(String location) {
		sf.enterFlyingFromLocation(location);
	}
	
	@When("^Enter Flying to \"([^\"]*)\" domestic location$")
	public void enter_Flying_to_domestic_location(String location) {
		sf.enterFlyingToLocation(location);
	}

	@When("^Click on Search Flight$")
	public void click_on_Search_Flight() {
		sf.clickonSearchFlight();
	}

	@Then("^Verify user navigated to the \"([^\"]*)\" flight results page$")
	public void verify_user_navigated_to_the_flight_results_page(String departing) throws Throwable {
		sf.verifyUserNavigatedtotheFlightResultsPage(departing);
	}

	@When("^Sort by cheapest flight$")
	public void sort_by_cheapest_flight() throws Throwable {

	}

	@When("^Select cheapest flight$")
	public void select_cheapest_flight() throws Throwable {

	}

	@Then("^Verify that the total fare is displaying correctly$")
	public void verify_that_the_total_fare_is_displaying_correctly() throws Throwable {

	}

	@Then("^Verify that the the page is responding with in (\\d+)\\.(\\d+) seconds$")
	public void verify_that_the_the_page_is_responding_with_in_seconds(int arg1, int arg2) throws Throwable {

	}

	@Then("^Verify that If user leaves page for (\\d+) minutes then Session Expire message is displaying$")
	public void verify_that_If_user_leaves_page_for_minutes_then_Session_Expire_message_is_displaying(int arg1) throws Throwable {

	}

}
