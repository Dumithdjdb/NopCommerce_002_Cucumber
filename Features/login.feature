Feature: Login
  @sanity
  Scenario Outline: Successful login with valid credentials
    Given User launches the chrome browser
    When User opens the URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "<email>" and password as "<password>"
    And Clicks on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When User clicks the log out link
    Then page title should be "Your store. Login"
    And Close the browser

    Examples:
    |email|password|
    |admin@yourstore.com|admin|
    |admin1@yourstore.com|admin|