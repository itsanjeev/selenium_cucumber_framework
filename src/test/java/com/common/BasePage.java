package com.common;

import io.github.seleniumhelper.ElementFinder;
import io.github.seleniumhelper.WebTableHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    protected ElementFinder elementFinder;
    protected WebTableHelper webTableHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.elementFinder = new ElementFinder();
        this.webTableHelper = new WebTableHelper();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void clickElement(By locator) {
        WebElement element = elementFinder.getElement(driver, locator, 30);
        element.click();
    }

    protected void sendText(By locator, String text) {
        WebElement element = elementFinder.getElement(driver, locator, 30);
        element.sendKeys(text);
    }
}
