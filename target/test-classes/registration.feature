Feature: Registration
  Scenario: User should be able to register successfully
    Given User is on https://demo.nopcommerce.com/register
    When User enter first name in First Name field
    And User enter last name in Last Name field
    And User enter email address in Email field
    And User enter password in Password field
    And User enter password in Confirm Password field
    And User click on Register button
    Then User should be able to register successfully
    And "Your registration completed" message should be displayed

  Scenario: User should not be able to register successfully with empty First Name field
    Given User is on https://demo.nopcommerce.com/register
    When User enter last name in Last Name field
    And User enter email address in Email field
    And User enter password in Password field
    And User enter password in Confirm Password field
    And User click on Register button
    Then User should not be able to register successfully
    And "First name is required." message should be displayed under First Name field

  Scenario: User should not be able to register successfully with empty Last Name field
    Given User is on https://demo.nopcommerce.com/register
    When User enter first name in First Name field
    And User enter email address in Email field
    And User enter password in Password field
    And User enter password in Confirm Password field
    And User click on Register button
    Then User should not be able to register successfully
    And "Last name is required." message should be displayed under Last Name field

  Scenario: User should not be able to register successfully with empty Email field
    Given User is on https://demo.nopcommerce.com/register
    When User enter first name in First Name field
    And User enter last name in Last name field
    And User enter password in Password field
    And User enter password in Confirm Password field
    And User click on Register button
    Then User should not be able to register successfully
    And "Email is required." message should be displayed under Email field

  Scenario: User should not be able to register successfully with empty Password field
    Given User is on https://demo.nopcommerce.com/register
    When User enter first name in First Name field
    And User enter last name in Last name field
    And User enter email address in Email field
    And User enter password in Confirm Password field
    And User click on Register button
    Then User should not be able to register successfully
    And "Password is required." message should be displayed under Password field

  Scenario: User should not be able to register successfully with empty First Name field
    Given User is on https://demo.nopcommerce.com/register
    When User enter first name in First Name field
    And User enter last name in Last name field
    And User enter email address in Email field
    And User enter password in Password field
    And User click on Register button
    Then User should not be able to register successfully
    And "Password is required." message should be displayed under Confirm Password field