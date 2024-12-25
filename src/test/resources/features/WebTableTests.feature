@WebTable
Feature: WebTableHelper - This feature provides helper methods to interact with web table elements,
  such as retrieving cell text, clicking cells, and performing searches within the table.

  Background:
    Given I have a table element

  Scenario: Retrieve cell text by row and column indices
    When I retrieve the text from the cell at row 1, column 1
    Then the retrieved text should be "John"

  Scenario: Click a cell by row and column indices
    When I click on the cell at row 1, column 5
    Then url should be updated with action

  Scenario: Get the number of rows in the table
    When I determine the total number of rows in the table
    Then the result should be 5

  Scenario: Get the exact rows with combination of text
    When I find row contains text "Doe", "Jason" , "jdoe@hotmail.com"
    Then the row identified should include "Doe" , "Jason ", "jdoe@hotmail.com"