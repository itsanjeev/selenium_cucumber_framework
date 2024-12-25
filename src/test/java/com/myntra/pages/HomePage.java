package com.myntra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    private final By categoryLinkLocator = By.cssSelector("a.desktop-main[href=\"/shop/men\"]");
    private final By subCategoryLinkLocator = By.cssSelector("a.desktop-main[href=\"/shop/men/shirts\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        super.driver.get("https://www.myntra.com/");
    }

    public void navigateToCategoryAndSubCategory() {
        super.clickElement(categoryLinkLocator);
    }
}
