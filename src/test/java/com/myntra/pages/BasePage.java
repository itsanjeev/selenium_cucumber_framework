package com.myntra.pages;

import io.github.seleniumhelper.ElementFinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    protected ElementFinder elementFinder;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.elementFinder = new ElementFinder();
    }

    protected void clickElement(By locator) {
        WebElement element = elementFinder.getElement(driver, locator, 10);
        element.click();
    }

    protected void sendText(By locator, String text) {
        WebElement element = elementFinder.getElement(driver, locator, 10);
        element.sendKeys(text);
    }
}
