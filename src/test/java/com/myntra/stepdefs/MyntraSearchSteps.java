package com.myntra.stepdefs;

import com.myntra.hooks.TestHooks;
import com.myntra.pages.MyntraPageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyntraSearchSteps {
    private final MyntraPageManager pageManager;

    public MyntraSearchSteps(TestHooks testHooks) {
        this.pageManager = new MyntraPageManager(testHooks.getDriver());
    }

    @Given("I navigate to the Myntra homepage")
    public void iNavigateToTheMyntraHomepage() {
        pageManager.getHomePage().navigateToHomePage();
    }

    @When("I navigate to the {string} category")
    public void iNavigateToTheCategory(String category) {
        pageManager.getHomePage().navigateToCategoryAndSubCategory();
    }

    @When("I select {string} from the subcategory")
    public void iSelectFromTheSubcategory(String subcategory) {
    }

    @When("I search for {string} in the search bar")
    public void iSearchForInTheSearchBar(String product) {

    }

    @When("I open the first product from the search results")
    public void iOpenTheFirstProductFromTheSearchResults() {

    }

    @Then("I should see the product details page")
    public void iShouldSeeTheProductDetailsPage() {

    }

    @Then("I should compare the displayed price with the expected price")
    public void iShouldCompareTheDisplayedPriceWithTheExpectedPrice() {

    }
}

