
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

/**
 * BaseTest Class
 *
 * Provides common browser setup and teardown functionality
 * for all TestNG test classes.
 *
 * Framework: Selenium WebDriver with TestNG
 * Browser: Google Chrome
 */
public class BaseTest {

    // Shared WebDriver instance accessible by child test classes
    protected WebDriver driver;

    // ==========================================
    // Browser Setup
    // ==========================================

    /**
     * Launches Chrome in headless mode and navigates
     * to the local Selenium practice website.
     *
     * Runs before each TestNG test method.
     */
    @BeforeMethod
    public void setUp() {

        // Configure Chrome browser options
        ChromeOptions options = new ChromeOptions();

        // Enable headless execution for CI environments
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        // Initialise Chrome browser
        driver = new ChromeDriver(options);

        // Locate the local practice website
        File file = new File(
                "src/test/resources/SeleniumProject/index.html"
        );

        // Open the local practice website using a file URL
        driver.get(file.toURI().toString());
    }

    // ==========================================
    // Browser Teardown
    // ==========================================

    /**
     * Closes the browser and ends the WebDriver session.
     *
     * Runs after each TestNG test method.
     */
    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
