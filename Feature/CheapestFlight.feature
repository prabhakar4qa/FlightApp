
Feature: Domestic Flights booking 

  Background: 
    Given User open the application

  @FlightBooking
  Scenario Outline: Search for the Cheapest Flight
    When Click on Return option
    And Enter Flying from "<From>" domestic location
    And Enter Flying to "<To>" domestic location
    And Click on Search Flight
    Then Verify user navigated to the "Departing" flight results page
    When Sort by cheapest flight
    And Select cheapest flight
    Then Verify user navigated to the "Return" flight results page
    When Sort by cheapest flight
    And Select cheapest flight
    Then Verify that the total fare is displaying correctly
    And Verify that the the page is responding with in 3.5 seconds
    And Verify that If user leaves page for 5 minutes then Session Expire message is displaying
    
    Examples: 
      |From     |To         |
      |Auckland |Wellington |
