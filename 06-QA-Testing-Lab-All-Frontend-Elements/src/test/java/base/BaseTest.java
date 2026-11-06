
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
     * Launches Chrome, maximises the browser window
     * and navigates to the local Selenium practice website.
     *
     * Runs before each TestNG test method.
     */
    @BeforeMethod
    public void setUp() {

        // Initialise Chrome browser
        driver = new ChromeDriver();

        // Maximise browser window
        driver.manage().window().maximize();

        // Locate the local practice website
        File file = new File("src/test/resources/SeleniumProject/index.html");

        // Open the practice website
        driver.get(file.getAbsolutePath());
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
        driver.quit();
    }
}
