package com.myntra.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.seleniumhelper.ElementFinder;
import io.github.seleniumhelper.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;

public class MyntraSearchSteps {

    WebDriver driver;
    ElementFinder elementFinder;
    String baseUrl = "https://www.myntra.com";
    String expectedPrice = "₹1999"; // Replace with your expected price
    final int TIMEOUT_IN_SECONDS = 10;


    @Given("I navigate to the Myntra homepage")
    public void iNavigateToTheMyntraHomepage() {
        WebDriverManager.createDriver(Browser.CHROME);
        driver = WebDriverManager.getDriver();
        elementFinder = new ElementFinder();
        driver.get(baseUrl);
    }

    @When("I navigate to the {string} category")
    public void iNavigateToTheCategory(String category) {
        WebElement categoryElement = elementFinder.getElement(driver, By.linkText(category), TIMEOUT_IN_SECONDS);
        categoryElement.click();
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

        WebDriverManager.quitDriver();
    }
}

