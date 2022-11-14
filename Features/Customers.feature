Feature: Customer
  Background: Below are the common steps for all scenarios
    Given User launches the chrome browser
    When User opens the URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Clicks on Login
    Then User can view Dashboard

  @sanity
  Scenario: Add New Customer
    When User clicks the CustomerMenu
    And User clicks the CustomerMenuIcon
    And Click on Add New Button
    Then User can view Add New Customer page
    When User enters the customer info
    And Click on Save button
    Then User can view the Confirmation message "The new Customer has been added Successfully."
    And Close the browser

    @regression
    Scenario: Search customer by EmailID
      When User clicks the CustomerMenu
      And User clicks the CustomerMenuIcon
      And Enter Customer Email
      And Click on the Search button
      Then User should find the customer email on the table
      And Close the browser