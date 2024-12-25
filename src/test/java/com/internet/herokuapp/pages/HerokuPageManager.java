package com.internet.herokuapp.pages;


import org.openqa.selenium.WebDriver;

public class HerokuPageManager {
    private final WebDriver driver;

    public HerokuPageManager(WebDriver driver) {
        this.driver = driver;
    }
    public WebTablePage getWebTablePage() {
        return new WebTablePage(driver);
    }

}
