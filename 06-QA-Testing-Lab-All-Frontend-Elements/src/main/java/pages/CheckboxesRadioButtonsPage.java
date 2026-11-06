package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * CheckboxesRadioButtonsPage Class
 *
 * Contains Page Object methods for interacting with checkbox
 * and radio button elements on the practice page.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class CheckboxesRadioButtonsPage extends BasePage {

    // ==========================================
    // Checkbox Locators
    // ==========================================

    // Individual Checkboxes
    private By termsCheckbox = By.id("terms-checkbox");
    private By newsletterCheckbox = By.id("newsletter-checkbox");
    private By notificationsCheckbox = By.id("notifications-checkbox");

    // Disabled Checkboxes
    private By disabledCheckbox = By.id("disabled-checkbox");
    private By checkedDisabledCheckbox = By.id("checked-disabled-checkbox");

    // Grouped Checkboxes
    private By seleniumCheckbox = By.id("tool-selenium");
    private By toolsResult = By.id("tools-result");
    private By selectAllButton = By.id("select-all-btn");
    private By toolCheckboxes = By.cssSelector(".tool-checkbox");


    // ==========================================
    // Radio Button Locators
    // ==========================================

    // Individual Radio Button
    private By beginnerRadio = By.id("radio-beginner");

    // Multiple Radio Groups
    private By languageRadioButtons = By.name("language");
    private By javaRadio = By.xpath("//input[@name='language' and @value='java']");
    private By languageResult = By.id("multi-radio-result");

    // Test Type Radio Button
    private By endToEndRadio = By.xpath("//input[@name='testType' and @value='e2e']");


    // ==========================================
    // Constructor
    // ==========================================

    /**
     * Initializes the WebDriver instance for the checkboxes and radio buttons page.
     *
     * @param driver WebDriver instance passed from the test class
     */
    public CheckboxesRadioButtonsPage(WebDriver driver) {
        super(driver);
    }


    // ==========================================
    // Individual Checkbox Methods
    // ==========================================

    /**
     * Selects the terms and conditions checkbox.
     */
    public void selectTermsCheckbox() {
        driver.findElement(termsCheckbox).click();
    }

    /**
     * Checks whether the terms checkbox is selected.
     *
     * @return true if selected, otherwise false
     */
    public boolean isTermsCheckboxSelected() {
        return driver.findElement(termsCheckbox).isSelected();
    }

    /**
     * Selects the newsletter checkbox.
     */
    public void selectNewsletterCheckbox() {
        driver.findElement(newsletterCheckbox).click();
    }

    /**
     * Checks whether the newsletter checkbox is selected.
     *
     * @return true if selected, otherwise false
     */
    public boolean isNewsletterCheckboxSelected() {
        return driver.findElement(newsletterCheckbox).isSelected();
    }

    /**
     * Checks whether the notifications checkbox is selected.
     *
     * @return true if selected, otherwise false
     */
    public boolean isNotificationsCheckboxSelected() {
        return driver.findElement(notificationsCheckbox).isSelected();
    }


    // ==========================================
    // Disabled Checkbox Methods
    // ==========================================

    /**
     * Checks whether the disabled checkbox is enabled.
     *
     * @return true if enabled, otherwise false
     */
    public boolean isDisabledCheckboxEnabled() {
        return driver.findElement(disabledCheckbox).isEnabled();
    }

    /**
     * Checks whether the checked and disabled checkbox is enabled.
     *
     * @return true if enabled, otherwise false
     */
    public boolean isCheckedDisabledCheckboxEnabled() {
        return driver.findElement(checkedDisabledCheckbox).isEnabled();
    }


    // ==========================================
    // Grouped Checkbox Methods
    // ==========================================

    /**
     * Selects the Selenium checkbox.
     */
    public void selectSeleniumCheckbox() {
        driver.findElement(seleniumCheckbox).click();
    }

    /**
     * Checks whether the Selenium checkbox is selected.
     *
     * @return true if selected, otherwise false
     */
    public boolean isSeleniumCheckboxSelected() {
        return driver.findElement(seleniumCheckbox).isSelected();
    }

    /**
     * Retrieves the selected tools result.
     *
     * @return Selected tools result text
     */
    public String getSelectedToolsResult() {
        return driver.findElement(toolsResult).getText();
    }

    /**
     * Clicks the Select All button.
     */
    public void clickSelectAllButton() {
        driver.findElement(selectAllButton).click();
    }

    /**
     * Checks whether all tool checkboxes are selected.
     *
     * @return true if all checkboxes are selected, otherwise false
     */
    public boolean areAllToolCheckboxesSelected() {
        List<WebElement> checkboxes = driver.findElements(toolCheckboxes);

        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Retrieves the selected tools result text.
     *
     * @return Selected tools result text
     */
    public String getSelectedToolsResults() {
        return driver.findElement(toolsResult).getText();
    }


    // ==========================================
    // Individual Radio Button Methods
    // ==========================================

    /**
     * Selects the Beginner experience radio button.
     */
    public void clickBeginnerRadioButton() {
        driver.findElement(beginnerRadio).click();
    }

    /**
     * Checks whether the Beginner radio button is selected.
     *
     * @return true if selected, otherwise false
     */
    public boolean isBeginnerRadioButtonSelected() {
        return driver.findElement(beginnerRadio).isSelected();
    }

    /**
     * Retrieves the experience radio button result.
     *
     * @return Experience selection result text
     */
    public String getExperienceResult() {
        return driver.findElement(By.id("radio-result")).getText();
    }


    // ==========================================
    // Multiple Radio Group Methods
    // ==========================================

    /**
     * Selects the Java radio button.
     */
    public void clickJavaRadioButton() {
        driver.findElement(javaRadio).click();
    }

    /**
     * Checks whether the Java radio button is selected.
     *
     * @return true if selected, otherwise false
     */
    public boolean isJavaRadioButtonSelected() {
        return driver.findElement(javaRadio).isSelected();
    }

    /**
     * Retrieves the multiple radio groups result.
     *
     * @return Radio groups result text
     */
    public String getRadioGroupsResult() {
        return driver.findElement(languageResult).getText();
    }


    // ==========================================
    // Test Type Radio Button Methods
    // ==========================================

    /**
     * Selects the End-to-End testing radio button.
     */
    public void clickEndToEndRadioButton() {
        driver.findElement(endToEndRadio).click();
    }

    /**
     * Checks whether the End-to-End testing radio button is selected.
     *
     * @return true if selected, otherwise false
     */
    public boolean isEndToEndRadioButtonSelected() {
        return driver.findElement(endToEndRadio).isSelected();
    }
}