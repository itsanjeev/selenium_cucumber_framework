package io.github.seleniumhelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebDropdownHelper {
    private static final Logger logger = LogManager.getLogger(WebDropdownHelper.class);

    public void deselectAll(WebElement dropdownElement) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.deselectAll();
        } catch (Exception e) {
            logger.error("Error while deselecting all options.", e);
        }
    }

    public void deselectByVisibleText(WebElement dropdownElement, String visibleText) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.deselectByVisibleText(visibleText);
        } catch (Exception e) {
            logger.error("Error while deselecting option by visible text: {}", visibleText);
        }
    }

    public void deselectByIndex(WebElement dropdownElement, int index) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.deselectByIndex(index);
        } catch (Exception e) {
            logger.error("Error while deselecting option by index: {}", index, e);
        }
    }

    public void deselectByValue(WebElement dropdownElement, String value) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.deselectByValue(value);
        } catch (Exception e) {
            logger.error("Error while deselecting option by value: {}", value);
        }
    }

    public List<WebElement> getAllSelectedOptions(WebElement dropdownElement) {
        try {
            Select dropdown = new Select(dropdownElement);
            return dropdown.getAllSelectedOptions();
        } catch (Exception e) {
            logger.error("Error while retrieving all selected options: {}", e.getMessage());
            return null;
        }
    }

    public WebElement getFirstSelectedOption(WebElement dropdownElement) {
        try {
            Select dropdown = new Select(dropdownElement);
            return dropdown.getFirstSelectedOption();
        } catch (Exception e) {
            logger.error("Error while retrieving the first selected option: {}", e.getMessage());
            return null;
        }
    }

    public boolean isMultiple(WebElement dropdownElement) {
        try {
            Select dropdown = new Select(dropdownElement);
            return dropdown.isMultiple();
        } catch (Exception e) {
            logger.error("Error while checking if dropdown allows multiple selection: {}", e.getMessage());
            return false;
        }
    }

    public void selectByVisibleText(WebElement dropdownElement, String visibleText) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText(visibleText);
        } catch (Exception e) {
            logger.error("Error while selecting option by visible text: {}", visibleText);
        }
    }

    public void selectByIndex(WebElement dropdownElement, int index) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByIndex(index);
        } catch (Exception e) {
            logger.error("Error while selecting option by index: {}", index);
        }
    }

    public void selectByValue(WebElement dropdownElement, String value) {
        try {
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByValue(value);
        } catch (Exception e) {
            logger.error("Error while selecting option by value: {}", value);
        }
    }

    public void selectNonNativeByVisibleText(WebElement dropdownElement, String visibleText) {
        try {
            dropdownElement.click();
            List<WebElement> options = new WebDriverWait(((WrapsDriver) dropdownElement).getWrappedDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(
                            dropdownElement.findElements(By.xpath(".//li[contains(text(),'" + visibleText + "')]"))
                    ));

            if (options.isEmpty()) {
                throw new RuntimeException("Option with text '" + visibleText + "' not found.");
            }
            options.get(0).click();
        } catch (Exception e) {
            logger.error("Error while selecting non-native option by visible text: {}", visibleText, e);
            throw e;
        }
    }


}
