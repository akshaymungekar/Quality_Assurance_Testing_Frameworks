Feature: Add a new Customer

  Background: Below are common steps for every scenario
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    When User enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers Menu Item

  @sanity
  Scenario: Add a new customer
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And close browser

  @regression
  Scenario: Search Customer by EMailID
    And Enter customer EMail
    When Click on search button
    Then User should found Email in the Search table
    And close browser

  @regression
  Scenario: Search Customer by Name
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found Name in the Search table
    And close browser