package com.internet.herokuapp.stepdefs;

import com.common.TestHooks;
import com.internet.herokuapp.pages.HerokuPageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.common.utils.ScenarioContext;

public class WebTableSteps {
    private final HerokuPageManager pageManager;
    private final ScenarioContext scenarioContext;

    public WebTableSteps(TestHooks testHooks, ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        this.pageManager = new HerokuPageManager(testHooks.getDriver());
    }

    @Given("I have a table element")
    public void i_have_a_table_element() {
        pageManager.getWebTablePage().navigateToWebTablePage();
        Assert.assertTrue("Table is not displayed", pageManager.getWebTablePage().isTableDisplayed());
    }

    @When("I retrieve the text from the cell at row {int}, column {int}")
    public void i_retrieve_the_text_from_the_cell_at_row_column(int rowIndex, int columnIndex) {
        String retrievedText = pageManager.getWebTablePage().getTableText(rowIndex, columnIndex);
        scenarioContext.set("retrievedText", retrievedText);
        Assert.assertNotNull("Retrieved text is null", retrievedText);
    }

    @Then("the retrieved text should be {string}")
    public void the_retrieved_text_should_be(String expectedText) {
        String retrievedText = scenarioContext.get("retrievedText");
        Assert.assertEquals("Retrieved text does not match", expectedText, retrievedText);
    }

    @When("I click on the cell at row {int}, column {int}")
    public void iClickOnTheCellAtRowColumn(int rowIndex, int ColumnIndex) {
        pageManager.getWebTablePage().clickOnCell(rowIndex, ColumnIndex);
    }

    @Then("url should be updated with action")
    public void urlShouldBeUpdatedWithAction() {
        System.out.println("URL: " + pageManager.getWebTablePage().getCurrentUrl());
        Assert.assertTrue("Url is not updated",
                pageManager.getWebTablePage().getCurrentUrl().contains("#delete"));
    }

    @When("I determine the total number of rows in the table")
    public void iDetermineTheTotalNumberOfRowsInTheTable() {
        scenarioContext.set("rowCount", pageManager.getWebTablePage().getNumberOfRows());
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expectedRowCount) {
        Assert.assertEquals("Row count is not correct",
                expectedRowCount, pageManager.getWebTablePage().getNumberOfRows());
    }

    @When("I find row contains text {string}, {string} , {string}")
    public void iFindRowContainsText(String searchText, String searchText2, String searchText3) {
        String foundRow = pageManager.getWebTablePage().getRowUsingCombinationOfText(searchText, searchText2, searchText3);
        scenarioContext.set("foundRow", foundRow);
    }

    @Then("the row identified should include {string} , {string}, {string}")
    public void theRowIdentifiedShouldInclude(String arg0, String arg1, String arg2) {
        String foundRow = scenarioContext.get("foundRow");
        Assert.assertTrue("Row identified is not correct", foundRow.contains(arg0) && foundRow.contains(arg1) && foundRow.contains(arg2));
    }
}
