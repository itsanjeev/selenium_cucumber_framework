package io.github.seleniumhelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTableHelper {

    private static final Logger logger = LogManager.getLogger(WebTableHelper.class);

    public String getCellText(WebElement tableElement, int rowIndex, int colIndex) {
        try {
            List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
            if (rowIndex < 0 || rowIndex >= rows.size()) {
                throw new IllegalArgumentException("Row index out of bounds");
            }
            List<WebElement> cols = rows.get(rowIndex).findElements(By.tagName("td"));
            if (colIndex < 0 || colIndex >= cols.size()) {
                throw new IllegalArgumentException("Column index out of bounds");
            }

            return cols.get(colIndex).getText();
        } catch (Exception e) {
            logger.error("Error while getting cell text [rowIndex: {}, colIndex: {}]", rowIndex, colIndex, e);
            throw e;
        }
    }

    public void clickCell(WebElement tableElement, int rowIndex, int colIndex) {
        try {
            List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
            if (rowIndex < 0 || rowIndex >= rows.size()) {
                throw new IllegalArgumentException("Row index out of bounds");
            }
            List<WebElement> cols = rows.get(rowIndex).findElements(By.tagName("td"));
            if (colIndex < 0 || colIndex >= cols.size()) {
                throw new IllegalArgumentException("Column index out of bounds");
            }

            WebElement cell = cols.get(colIndex);
            cell.click();
        } catch (Exception e) {
            logger.error("Error while clicking cell [rowIndex: {}, colIndex: {}]", rowIndex, colIndex, e);
            throw e;
        }
    }

    public List<WebElement> getTableRows(WebElement tableElement) {
        try {
            return tableElement.findElements(By.tagName("tr"));
        } catch (Exception e) {
            logger.error("Error while getting table rows", e);
            throw e;
        }
    }

    public void searchAndClickRow(WebElement tableElement, String searchText) {
        try {
            List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                List<WebElement> cols = row.findElements(By.tagName("td"));
                for (WebElement col : cols) {
                    if (col.getText().contains(searchText)) {
                        row.click();
                        return;
                    }
                }
            }
            throw new RuntimeException("Text '" + searchText + "' not found in the table.");
        } catch (Exception e) {
            logger.error("Error while searching and clicking row with text '{}'", searchText, e);
            throw e;
        }
    }

    public int getColumnCount(WebElement tableElement) {
        try {
            List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
            if (rows.isEmpty()) {
                return 0;
            }
            return rows.get(0).findElements(By.tagName("td")).size();
        } catch (Exception e) {
            logger.error("Error while getting column count", e);
            throw e;
        }
    }

    public List<WebElement> getTableColumns(WebElement tableElement, int rowIndex) {
        try {
            List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
            if (rowIndex < 0 || rowIndex >= rows.size()) {
                throw new IllegalArgumentException("Row index out of bounds");
            }

            return rows.get(rowIndex).findElements(By.tagName("td"));
        } catch (Exception e) {
            logger.error("Error while getting table columns for rowIndex: {}", rowIndex, e);
            throw e;
        }
    }

    public WebElement findRowByCombination(WebElement tableElement, String... searchTexts) {
        if (tableElement == null || searchTexts == null || searchTexts.length == 0) {
            throw new IllegalArgumentException("Table element and search texts must not be null or empty.");
        }
        try {
            List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                List<WebElement> cols = row.findElements(By.tagName("td"));

                boolean allMatch = true;
                for (String searchText : searchTexts) {
                    boolean matches = cols.stream()
                            .map(WebElement::getText)
                            .map(String::trim) // Trim the whitespace for more flexibility
                            .anyMatch(colText -> colText.equalsIgnoreCase(searchText)); // Consider case-insensitive matching

                    if (!matches) {
                        allMatch = false;
                        break;
                    }
                }
                if (allMatch) {
                    return row;
                }
            }

            String searchTextList = String.join(", ", searchTexts);
            throw new RuntimeException("No row found with the exact combination: " + searchTextList);
        } catch (Exception e) {
            String searchTextList = String.join(", ", searchTexts);
            logger.error("Error while finding row by combination of values: {}", searchTextList, e);
            throw e;
        }
    }

}
