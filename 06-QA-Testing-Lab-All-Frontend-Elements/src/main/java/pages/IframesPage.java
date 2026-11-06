
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * IframesPage Class
 *
 * Contains Page Object methods for interacting with single and multiple
 * iFrames, including elements located outside the frames.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class IframesPage extends BasePage {

    // ==========================================
    // Page Heading Locator
    // ==========================================

    private final By pageHeading = By.cssSelector(".page-title h1");


    // ==========================================
    // Single iFrame Locators
    // ==========================================

    private final By practiceIframe = By.id("practice-iframe");
    private final By usernameField = By.id("iframe-username");
    private final By passwordField = By.id("iframe-password");
    private final By emailField = By.id("iframe-email");
    private final By submitButton = By.id("iframe-submit-btn");
    private final By iframeResult = By.id("iframe-result");


    // ==========================================
    // Multiple iFrame Locators
    // ==========================================

    private By firstIframe = By.id("iframe-one");
    private By secondIframe = By.id("iframe-two");


    // ==========================================
    // Elements Outside the iFrame Locators
    // ==========================================

    private By outsideInput = By.id("outside-input");
    private By outsideButton = By.id("outside-btn");
    private By outsideResult = By.id("outside-result");


    // ==========================================
    // Constructor
    // ==========================================

    /**
     * Initializes the WebDriver instance for the iFrames page.
     *
     * @param driver WebDriver instance passed from the test class
     */
    public IframesPage(WebDriver driver) {
        super(driver);
    }


    // ==========================================
    // Page Heading Methods
    // ==========================================

    /**
     * Retrieves the page heading text.
     *
     * @return Page heading text
     */
    public String getPageHeadingText() {
        return driver.findElement(pageHeading).getText();
    }


    // ==========================================
    // Single iFrame Methods
    // ==========================================

    /**
     * Switches WebDriver focus to the practice iFrame using its WebElement.
     */
    public void switchToPracticeIframe() {
        driver.switchTo().frame(driver.findElement(practiceIframe));
    }

    /**
     * Enters a username inside the practice iFrame.
     *
     * @param username Username to enter
     */
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    /**
     * Enters a password inside the practice iFrame.
     *
     * @param password Password to enter
     */
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * Enters an email address inside the practice iFrame.
     *
     * @param email Email address to enter
     */
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    /**
     * Clicks the Submit button inside the practice iFrame.
     */
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    /**
     * Retrieves the result displayed inside the practice iFrame.
     *
     * @return iFrame result text
     */
    public String getIframeResultText() {
        return driver.findElement(iframeResult).getText();
    }

    /**
     * Switches WebDriver focus back to the main page content.
     */
    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }


    // ==========================================
    // Multiple iFrame Methods
    // ==========================================

    /**
     * Switches to the first iFrame using its WebElement.
     */
    public void switchToFirstIframe() {
        driver.switchTo().frame(driver.findElement(firstIframe));
    }

    /**
     * Switches to the second iFrame using its WebElement.
     */
    public void switchToSecondIframe() {
        driver.switchTo().frame(driver.findElement(secondIframe));
    }

    /**
     * Switches to an iFrame using its index.
     *
     * @param index Zero-based index of the iFrame
     */
    public void switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
    }


    // ==========================================
    // Elements Outside the iFrame Methods
    // ==========================================

    /**
     * Enters text into the input field outside the iFrame.
     *
     * @param text Text to enter
     */
    public void enterOutsideInput(String text) {
        driver.findElement(outsideInput).sendKeys(text);
    }

    /**
     * Retrieves the value entered in the outside input field.
     *
     * @return Current input field value
     */
    public String getOutsideInputValue() {
        return driver.findElement(outsideInput).getAttribute("value");
    }

    /**
     * Clicks the button located outside the iFrame.
     */
    public void clickOutsideButton() {
        driver.findElement(outsideButton).click();
    }

    /**
     * Retrieves the result displayed after clicking the outside button.
     *
     * @return Outside button result text
     */
    public String getOutsideResultText() {
        return driver.findElement(outsideResult).getText().trim();
    }
}
