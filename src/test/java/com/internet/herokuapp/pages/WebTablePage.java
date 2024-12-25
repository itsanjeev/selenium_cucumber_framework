package com.internet.herokuapp.pages;

import com.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTablePage extends BasePage {
    private final By tableLocator = By.id("table1");

    public WebTablePage(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }

    public void navigateToWebTablePage() {
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    public boolean isTableDisplayed() {
        return super.elementFinder.getElement(driver, tableLocator, 10).isDisplayed();
    }

    public String getTableText(int rowIndex, int columnIndex) {
        WebElement element = super.elementFinder.getElement(driver, tableLocator, 10);
        return super.webTableHelper.getCellText(element, rowIndex, columnIndex);
    }

    public void clickOnCell(int rowIndex, int columnIndex) {
        WebElement tableElement = super.elementFinder.getElement(driver, tableLocator, 10);
        super.webTableHelper.clickCell(tableElement, rowIndex, columnIndex);
    }

    public int getNumberOfRows() {
        WebElement tableElement = super.elementFinder.getElement(driver, tableLocator, 10);
        return super.webTableHelper.getTableRows(tableElement).size();
    }
}
