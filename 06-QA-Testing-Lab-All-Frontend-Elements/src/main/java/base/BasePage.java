
package base;

import org.openqa.selenium.WebDriver;

/**
 * BasePage Class
 *
 * Provides common functionality and shared WebDriver access
 * for all Page Object classes in the Selenium automation framework.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class BasePage {

    // Shared WebDriver instance accessible by child page classes
    protected WebDriver driver;

    /**
     * Initializes the WebDriver instance for the page class.
     *
     * @param driver WebDriver instance passed from the test setup
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
