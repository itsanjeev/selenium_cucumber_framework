Feature: Feature: WebTableHelper - This feature provides helper methods to interact with web table elements,
    such as retrieving cell text, clicking cells, and performing searches within the table.

  Background:
    Given I have a table element

  Scenario: Retrieve cell text by row and column indices
    When I retrieve the text from the cell at row 1, column 2
    Then the retrieved text should be "Expected Text"

  Scenario: Click a cell by row and column indices
    When I click on the cell at row 1, column 2
    Then the cell at row 1, column 2 should register the click action

  Scenario: Get the number of rows in the table
    When I determine the total number of rows in the table
    Then the result should be 5

  Scenario: Search and click a row by text in the table
    When I search for the text "Search Text" and perform a click action on the row
    Then the row containing the text "Search Text" should register the click action

  Scenario: Get the number of columns in the table
    When I determine the total number of columns in the table
    Then the result should be 4

  Scenario: Get columns of a specific row
    When I fetch the columns from row 1
    Then the resulting columns should include "Column 1", "Column 2", "Column 3"

  Scenario: Find a row by a combination of search texts
    When I locate a row containing both "Search Text 1" and "Search Text 2"
    Then the row identified should include both "Search Text 1" and "Search Text 2"
