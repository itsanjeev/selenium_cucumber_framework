Feature: Myntra Search Product Functionality
  As a user,
  I want to search for a product on Myntra,
  So that I can compare its price after navigating through categories.

  @smokeTest @gui
  Scenario: Search for a polo t-shirt and compare the price
    Given I navigate to the Myntra homepage
    When I navigate to the "Men" category
    And I select "T-Shirts" from the subcategory
    Then I found "Roadster" in the search result
