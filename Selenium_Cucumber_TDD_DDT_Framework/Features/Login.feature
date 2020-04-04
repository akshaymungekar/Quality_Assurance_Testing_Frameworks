Feature: Login

  @sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    When User enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then Page Title after login should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title after logout should be "Your store. Login"
    And close browser

  @regression
  Scenario Outline: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    When User enters Email as "<email>" and Password as "<password>"
    And click on Login
    Then Page Title after login should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title after logout should be "Your store. Login"
    And close browser

    Examples:
      | email                | password |
      | admin@yourstore.com  | admin    |
      | admin1@yourstore.com | admin123 |