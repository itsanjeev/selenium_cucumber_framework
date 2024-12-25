package com.myntra.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.github.seleniumhelper.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;

public class TestHooks {

    @Before
    public void setUp() {
        System.out.println("Setting up test");
        WebDriverManager.createDriver(Browser.CHROME); // Setup driver
    }

    @After
    public void tearDown() {
        WebDriverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return WebDriverManager.getDriver();
    }
}

