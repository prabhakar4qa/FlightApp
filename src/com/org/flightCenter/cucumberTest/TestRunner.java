package com.org.flightCenter.cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"com.org.flightCenter.stepDefinitions"}
		,monochrome=true
		,tags= {"@FlightBooking"}
		)

public class TestRunner {

}
