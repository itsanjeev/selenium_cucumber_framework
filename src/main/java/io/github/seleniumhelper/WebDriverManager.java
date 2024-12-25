package io.github.seleniumhelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;

import static org.openqa.selenium.remote.Browser.*;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final Logger LOG = LogManager.getLogger(WebDriverManager.class);

    // Constants for browser options
    private static final String NO_SANDBOX = "--no-sandbox";
    private static final String DISABLE_DEV_SHM = "--disable-dev-shm-usage";
    private static final String CUSTOM_WINDOW_SIZE = "--window-size=1050,600";
    private static final String HEADLESS = "--headless";

    public static void createDriver(final Browser browser) {
        if (FIREFOX.equals(browser)) {
            setupFirefoxDriver();
        } else if (EDGE.equals(browser)) {
            setupEdgeDriver();
        } else if (CHROME.equals(browser)) {
            setupChromeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser type: " + browser);
        }
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void quitDriver() {
        if (DRIVER.get() != null) {
            LOG.info("Closing the driver...");
            getDriver().quit();
            DRIVER.remove();
        }
    }

    private static void setupChromeDriver() {
        LOG.info("Setting up Chrome Driver...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(NO_SANDBOX, DISABLE_DEV_SHM);
        options.addArguments(HEADLESS);
        DRIVER.set(new ChromeDriver(options));
        LOG.info("Chrome Driver created successfully!");
    }

    private static void setupFirefoxDriver() {
        LOG.info("Setting up Firefox Driver...");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(NO_SANDBOX, DISABLE_DEV_SHM, HEADLESS);
        DRIVER.set(new FirefoxDriver(options));
        LOG.info("Firefox Driver created successfully!");
    }

    private static void setupEdgeDriver() {
        LOG.info("Setting up Edge Driver...");
        EdgeOptions options = new EdgeOptions();
        options.addArguments(NO_SANDBOX, DISABLE_DEV_SHM);
        DRIVER.set(new EdgeDriver(options));
        LOG.info("Edge Driver created successfully!");
    }


}
