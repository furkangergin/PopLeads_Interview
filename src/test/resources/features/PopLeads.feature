Feature: PopLeads Interview


  Background: User enter the main page.
    Given User go to the "https://imperum.io/" page.
    When User click the Accept All button.

  Scenario: Request A Demo
    Given User click the request a demo
    When User enters fullname randomly.
    And User enters jobTitle through PopLeads excel sheet.
    And User select canada as country.
  @pop
  Scenario: Take A Tour
    Given User clik the take a tour.
    When User click see how it works button.






