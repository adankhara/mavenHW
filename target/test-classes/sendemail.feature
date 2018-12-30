Feature: Email

  Scenario: Registered user should able to send an email to friend with product
    Given User is logged in on https://demo.nopcommerce.com/
    When User click on a product
    And User click on Email a friend
    And User type friend's email address in Friend's Email
    And User type message in Personal message box
    And User click on Send Email button
    Then User should be able to send an email to friend
    And "Your message has been sent." message should be displayed

  Scenario: Registered user should not able to send an email to friend with product with empty Friend's email field
    Given User is logged in on https://demo.nopcommerce.com/
    When User click on a product
    And User click on Email a friend
    And User type message in Personal message box
    And User click on Send Email button
    Then User should not be able to send an email to friend
    And "Enter friend's email" message should be displayed under Friend's Email field

  Scenario: Registered user should not able to send an email to friend with product with empty Personal Message field
    Given User is logged in on https://demo.nopcommerce.com/
    When User click on a product
    And User click on Email a friend
    And User type friend's email address in Friend's Email
    And User click on Send Email button
    Then User should not be able to send an email to friend


  Scenario: Unregistered user should not able to send an email to friend with product
    Given User is on https://demo.nopcommerce.com/
    When User click on a product
    And User click on Email a friend
    And User type friend's email address in Friend's Email
    And User type own email address in Your email address field
    And User type message in Personal message box
    And User click on Send Email button
    Then User should not be able to send an email to friend
    And "Only registered customers can use email a friend feature" message should be displayed

