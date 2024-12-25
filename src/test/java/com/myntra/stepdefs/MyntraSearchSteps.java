package com.myntra.stepdefs;

import com.myntra.hooks.TestHooks;
import com.myntra.pages.MyntraPageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        pageManager.getHomePage().navigateToSubCategory();
    }

    @Then("I found {string} in the search result")
    public void iSearchForInTheSearchBar(String product) {
        Assert.assertTrue("Product not found in the search result", pageManager.getHomePage().searchProduct(product));
    }


}

