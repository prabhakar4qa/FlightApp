# FlightApp

User Story
STORY ID 001: Search for the Cheapest Fare
As a customer of flight center
I want to search for the cheapest fare for the onward trip(domestic only)
And the return trip So that I should be able to select the cheapest fares for both and get a total for the round trip.
ACCEPTANCE CRITERIA 
1.	I should see the fares sorted descending (small to large)
2.	I should be able to select the cheapest for onward and then backward
3.	I should be able to get the total and it should be correct depending on the fares
4.	The responses come back within 3.5 seconds
5.	I should get a proper message should the session expire

For the above user story, created Hybrid framework which includes BDD/Cucumber, POM, Data Driven, and Junit. Have used Maven as a build 
tool. Test management/execution starts from TestRunner class with the help of Junit. Entire project source code is uploaded in open source
git location https://github.com/prabhakar4qa/FlightApp.git. 
 
Important points:
	Not automated the functionality for Departing & Returning date selections and Passengers / Ticket class. If no flights are available as per the default dates then whole test cases will be failed.
	Feature file accepts the data “Flying from” and “Flying To” and Time in seconds to verify the page loading time.
	Automation scripts were executed/tested in Chrome browser


