package io.github.seleniumhelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementFinder {

    private static final Logger logger = LogManager.getLogger(ElementFinder.class);

    public WebElement getElement(WebDriver driver, final By elementLocator, int timeOutInSecs) {
        return waitForElement(driver, elementLocator, timeOutInSecs);
    }

    public List<WebElement> getElements(WebDriver driver, final By elementLocator, int timeOutInSecs) {
        return waitForElements(driver, elementLocator, timeOutInSecs);
    }

    public WebElement getElementByIdOrName(WebDriver driver, final String byIdOrName, int timeOutInSecs) {
        return waitForElement(driver, new ByIdOrName(byIdOrName), timeOutInSecs);
    }

    public WebElement getElementByChained(WebDriver driver, final ByChained chainedValue, int timeOutInSecs) {
        return waitForElement(driver, chainedValue, timeOutInSecs);
    }

    private WebElement waitForElement(WebDriver driver, final By elementLocator, int timeOutInSecs) {
        return waitFor(driver, elementLocator, timeOutInSecs, false);
    }

    private List<WebElement> waitForElements(WebDriver driver, final By elementLocator, int timeOutInSecs) {
        return waitFor(driver, elementLocator, timeOutInSecs, true);
    }

    private <T> T waitFor(WebDriver driver, final By elementLocator, int timeOutInSecs, boolean isList) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecs));
        wait.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);

        try {
            if (isList) {
                return (T) wait.until(driver1 -> getElements(driver1, elementLocator));
            } else {
                return (T) wait.until(driver1 -> getElement(driver1, elementLocator));
            }
        } catch (Exception ex) {
            logger.error("Error while waiting for element(s): {}", elementLocator, ex);
            throw ex;
        }
    }

    private WebElement getElement(SearchContext searchContext, final By elementLocator) {
        WebElement element = searchContext.findElement(elementLocator);
        if (element.isDisplayed() && element.isEnabled()) {
            return element;
        }
        throw new NoSuchElementException("WebElement with locator " + elementLocator + " is not found.");
    }


    private List<WebElement> getElements(SearchContext searchContext, final By elementLocator) {
        List<WebElement> elements = searchContext.findElements(elementLocator);
        if (!elements.isEmpty()) {
            return elements;
        }
        throw new NoSuchElementException("No WebElements found with locator " + elementLocator + ".");
    }

    private WebElement getByIdOrName(SearchContext searchContext, final String elementLocatorValue) {
        WebElement element = searchContext.findElement(new ByIdOrName(elementLocatorValue));
        if (element.isDisplayed() && element.isEnabled()) {
            return element;
        }
        throw new NoSuchElementException("WebElement with Id or Name " + elementLocatorValue + " not found.");
    }

    private WebElement getByChained(SearchContext searchContext, final ByChained getByChained) {
        WebElement element = searchContext.findElement(getByChained);
        if (element.isDisplayed() && element.isEnabled()) {
            return element;
        }
        throw new NoSuchElementException("WebElement with chained locator " + getByChained.toString() + " is not visible.");
    }
}
