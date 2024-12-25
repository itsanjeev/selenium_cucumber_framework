package com.myntra.pages;

import com.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomePage extends BasePage {
    private final By categoryLinkLocator = By.cssSelector("a.desktop-main[href=\"/shop/men\"]");
    private final By subCategoryLinkLocator = By.cssSelector("a[href=\"/men-tshirts\"]");
    private final By resultsBaseLocator = By.cssSelector("ul.results-base > li.product-base");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        super.driver.get("https://www.myntra.com/");
    }

    public void navigateToCategoryAndSubCategory() {
        super.clickElement(categoryLinkLocator);
    }

    public void navigateToSubCategory() {
        super.clickElement(subCategoryLinkLocator);
    }

    public boolean searchProduct(String productName) {
        List<WebElement> results = super.elementFinder.getElements(driver, resultsBaseLocator, 30);
        for (WebElement result : results) {
            if (result.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

}
