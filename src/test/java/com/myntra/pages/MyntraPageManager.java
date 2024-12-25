package com.myntra.pages;

import org.openqa.selenium.WebDriver;

public class MyntraPageManager {

    private final WebDriver driver;
    private HomePage homePage;

    String baseUrl = "https://www.myntra.com";

    public MyntraPageManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }
}
