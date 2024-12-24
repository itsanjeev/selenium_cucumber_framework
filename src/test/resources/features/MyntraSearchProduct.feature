Feature: Myntra Search Product Functionality
  As a user,
  I want to search for a product on Myntra,
  So that I can compare its price after navigating through categories.

  @SmokeTest
  Scenario: Search for a polo t-shirt and compare the price
    Given I navigate to the Myntra homepage
    When I navigate to the "Men" category
    And I select "T-Shirts" from the subcategory
    And I search for "polo t-shirt" in the search bar
    And I open the first product from the search results
    Then I should see the product details page
    And I should compare the displayed price with the expected price


