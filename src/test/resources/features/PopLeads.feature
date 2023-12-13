Feature: PopLeads Interview


  Background:  User go to the https://www.leoron.com/
    Given User go to the "https://www.leoron.com/"

  Scenario: Sign In Scenario
  When User click to sign in button.
  And User enter the email randomly.
  And User enter the password randomly.
  And User click sign in button.
  Then The sign in button remove top the menu
  @pop
   Scenario: Course select
     When User selects one of the nine courses main page









