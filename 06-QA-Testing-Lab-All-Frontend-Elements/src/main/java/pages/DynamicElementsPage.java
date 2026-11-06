
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * DynamicElementsPage Class
 *
 * Contains Page Object methods for interacting with dynamic elements,
 * delayed elements, progress bars, interactive counters, skeleton loaders
 * and toast notifications on the practice page.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class DynamicElementsPage extends BasePage {

    // ==========================================
    // Page Heading Locator
    // ==========================================

    private By pageHeading = By.cssSelector(".page-title h1");


    // ==========================================
    // Show / Hide / Toggle Element Locators
    // ==========================================

    private By showElementButton = By.id("show-element-btn");
    private By hideElementButton = By.id("hide-element-btn");
    private By toggleElementButton = By.id("toggle-element-btn");
    private By dynamicBox = By.id("dynamic-box");


    // ==========================================
    // Delayed Element Locators
    // ==========================================

    private By loadDelayedButton = By.id("load-delayed-btn");
    private By delayedElement = By.id("delayed-element");


    // ==========================================
    // Progress Bar Locators
    // ==========================================

    private By startProgressButton = By.id("start-progress-btn");
    private By progressBar = By.id("progress-bar");
    private By progressCompleteMessage = By.xpath(
            "//div[contains(@class,'alert-success') and contains(.,'Progress complete!')]"
    );


    // ==========================================
    // Interactive Counter Locators
    // ==========================================

    private By decrementButton = By.id("decrement-btn");
    private By resetCounterButton = By.id("reset-counter-btn");
    private By incrementButton = By.id("increment-btn");
    private By counterValue = By.id("counter-value");


    // ==========================================
    // Skeleton Loader Locators
    // ==========================================

    private By loadContentButton = By.id("load-content-btn");
    private By loadedTitle = By.id("loaded-title");
    private By loadedDescription = By.id("loaded-description");
    private By enrolledCount = By.id("enrolled-count");


    // ==========================================
    // Dynamic Changing Text Locators
    // ==========================================

    private By changeTextButton = By.id("change-text-btn");
    private By dynamicTextElement = By.id("dynamic-text-element");


    // ==========================================
    // Toast Notification Locators
    // ==========================================

    private By triggerToastButton = By.id("trigger-toast-btn");
    private By toastMessage = By.id("toast-message");


    // ==========================================
    // Constructor
    // ==========================================

    /**
     * Initializes the WebDriver instance for the dynamic elements page.
     *
     * @param driver WebDriver instance passed from the test class
     */
    public DynamicElementsPage(WebDriver driver) {
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
    // Show / Hide / Toggle Element Methods
    // ==========================================

    /**
     * Clicks the button to display the dynamic element.
     */
    public void clickShowElement() {
        driver.findElement(showElementButton).click();
    }

    /**
     * Clicks the button to hide the dynamic element.
     */
    public void clickHideElement() {
        driver.findElement(hideElementButton).click();
    }

    /**
     * Clicks the button to toggle the dynamic element visibility.
     */
    public void clickToggleElement() {
        driver.findElement(toggleElementButton).click();
    }

    /**
     * Checks whether the dynamic box is currently visible.
     *
     * @return true if visible, otherwise false
     */
    public boolean isDynamicBoxVisible() {
        return driver.findElement(dynamicBox).isDisplayed();
    }

    /**
     * Waits until the dynamic box becomes visible.
     *
     * @return true when the dynamic box becomes visible
     */
    public boolean waitForDynamicBoxVisible() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(dynamicBox))
                .isDisplayed();
    }


    // ==========================================
    // Delayed Element Methods
    // ==========================================

    /**
     * Clicks the button to load the delayed element.
     */
    public void clickLoadDelayedElement() {
        driver.findElement(loadDelayedButton).click();
    }

    /**
     * Waits until the delayed element becomes visible.
     *
     * @return true when the delayed element becomes visible
     */
    public boolean isDelayedElementVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(delayedElement)
        ).isDisplayed();
    }


    // ==========================================
    // Progress Bar Methods
    // ==========================================

    /**
     * Clicks the button to start the progress bar.
     */
    public void clickStartProgress() {
        driver.findElement(startProgressButton).click();
    }

    /**
     * Waits until the progress bar reaches 100%
     * and the completion message is displayed.
     *
     * @return true if the completion message is displayed
     */
    public boolean isProgressComplete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "100")
        );

        return driver.findElement(progressCompleteMessage).isDisplayed();
    }


    // ==========================================
    // Interactive Counter Methods
    // ==========================================

    /**
     * Clicks the decrement button.
     */
    public void clickDecrement() {
        driver.findElement(decrementButton).click();
    }

    /**
     * Clicks the reset counter button.
     */
    public void clickResetCounter() {
        driver.findElement(resetCounterButton).click();
    }

    /**
     * Clicks the increment button.
     */
    public void clickIncrement() {
        driver.findElement(incrementButton).click();
    }

    /**
     * Retrieves the current counter value.
     *
     * @return Current counter value as an integer
     */
    public int getCounterValue() {
        return Integer.parseInt(
                driver.findElement(counterValue).getText().trim()
        );
    }


    // ==========================================
    // Skeleton Loader Methods
    // ==========================================

    /**
     * Clicks the button to simulate page content loading.
     */
    public void clickSimulatePageLoad() {
        driver.findElement(loadContentButton).click();
    }

    /**
     * Waits until the loaded content title becomes visible.
     *
     * @return true when the title becomes visible
     */
    public boolean isLoadedTitleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loadedTitle)
        ).isDisplayed();
    }

    /**
     * Retrieves the loaded content title.
     *
     * @return Loaded title text
     */
    public String getLoadedTitleText() {
        return driver.findElement(loadedTitle).getText();
    }

    /**
     * Retrieves the loaded content description.
     *
     * @return Loaded description text
     */
    public String getLoadedDescriptionText() {
        return driver.findElement(loadedDescription).getText();
    }

    /**
     * Retrieves the enrolled count displayed in the loaded content.
     *
     * @return Enrolled count text
     */
    public String getEnrolledCountText() {
        return driver.findElement(enrolledCount).getText();
    }


    // ==========================================
    // Dynamic Changing Text Methods
    // ==========================================

    /**
     * Clicks the button to generate a random status.
     */
    public void clickGenerateRandomStatus() {
        driver.findElement(changeTextButton).click();
    }

    /**
     * Retrieves the dynamically generated text.
     *
     * @return Dynamic text content
     */
    public String getDynamicText() {
        return driver.findElement(dynamicTextElement).getText().trim();
    }


    // ==========================================
    // Toast Notification Methods
    // ==========================================

    /**
     * Clicks the button to display a toast notification.
     */
    public void clickShowToastNotification() {
        driver.findElement(triggerToastButton).click();
    }

    /**
     * Waits until the toast notification becomes visible.
     *
     * @return true when the toast notification becomes visible
     */
    public boolean isToastVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(toastMessage)
        ).isDisplayed();
    }

    /**
     * Retrieves the toast notification message.
     *
     * @return Toast message text
     */
    public String getToastMessageText() {
        return driver.findElement(toastMessage).getText().trim();
    }
}
