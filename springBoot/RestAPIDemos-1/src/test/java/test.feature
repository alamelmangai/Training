#Features
Feature: Add Flight Details

	Scenario: Successful creation
		Given I have chosen to insert flight detail
		When I insert valid flight details
		Then Map should be inserted with new details

	Scenario: Successful update
		Given I have chosen to update flight detail
		When I update valid flight details
		Then Map should be updated with new details