
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * FormElementsPage Class
 *
 * Contains locators and reusable methods for interacting
 * with the Form Elements Practice Page.
 *
 * Covers text inputs, special inputs, text areas,
 * buttons and navigation links.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class FormElementsPage extends BasePage {

    // ==========================================
    // Text Input Locators
    // ==========================================

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By emailField = By.id("email-address");
    private By phoneNumberField = By.id("phone-number");
    private By ageField = By.id("age");
    private By websiteUrlField = By.id("website-url");

    // ==========================================
    // Special Input Locators
    // ==========================================

    private By birthDateField = By.id("birth-date");
    private By searchBoxField = By.name("searchQuery");
    private By passwordField = By.cssSelector("input#password-field");
    private By confirmPasswordField = By.xpath("//input[@id='confirm-password']");
    private By readOnlyField = By.cssSelector("input[readonly]");
    private By disabledField = By.cssSelector("input[disabled]");

    // ==========================================
    // Text Area Locators
    // ==========================================

    private By biographyField = By.id("bio");
    private By commentsField = By.cssSelector("textarea#comments");

    // ==========================================
    // Button Locators
    // ==========================================

    private By submitButton = By.id("submit-btn");
    private By submitResult = By.id("submit-result");
    private By resetButton = By.id("reset-btn");
    private By successButton = By.id("success-btn");
    private By dangerButton = By.id("danger-btn");
    private By disabledButton = By.id("disabled-btn");
    private By smallButton = By.id("small-btn");
    private By largeButton = By.id("large-btn");

    // ==========================================
    // Navigation Link Locators
    // ==========================================

    private By formElementsPracticePageLink =
            By.linkText("Form Elements Practice Page");

    private By dataTablesLink =
            By.partialLinkText("Data Tables");

    private By alertsLink =
            By.linkText("JavaScript Alerts and Popup Dialogs");

    private By dynamicElementsLink =
            By.linkText("Dynamic and Asynchronous Elements");

    private By dragDropLink =
            By.linkText("Drag and Drop Interaction Zone");


    // ==========================================
    // Constructor
    // ==========================================

    public FormElementsPage(WebDriver driver) {
        super(driver);
    }


    // ==========================================
    // Text Input Methods
    // ==========================================

    /**
     * Enters a first name into the First Name field.
     */
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    /**
     * Retrieves the value entered in the First Name field.
     */
    public String getFirstNameValue() {
        return driver.findElement(firstNameField).getAttribute("value");
    }

    /**
     * Enters a last name into the Last Name field.
     */
    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    /**
     * Retrieves the value entered in the Last Name field.
     */
    public String getLastNameValue() {
        return driver.findElement(lastNameField).getAttribute("value");
    }

    /**
     * Enters an email address into the Email field.
     */
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    /**
     * Retrieves the value entered in the Email field.
     */
    public String getEmailValue() {
        return driver.findElement(emailField).getAttribute("value");
    }

    /**
     * Enters a phone number into the Phone Number field.
     */
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    /**
     * Retrieves the value entered in the Phone Number field.
     */
    public String getPhoneNumberValue() {
        return driver.findElement(phoneNumberField).getAttribute("value");
    }

    /**
     * Enters an age into the Age field.
     */
    public void enterAge(String age) {
        driver.findElement(ageField).sendKeys(age);
    }

    /**
     * Retrieves the value entered in the Age field.
     */
    public String getAgeValue() {
        return driver.findElement(ageField).getAttribute("value");
    }

    /**
     * Enters a website URL into the Website URL field.
     */
    public void enterWebsiteUrl(String websiteUrl) {
        driver.findElement(websiteUrlField).sendKeys(websiteUrl);
    }

    /**
     * Retrieves the value entered in the Website URL field.
     */
    public String getWebsiteUrlValue() {
        return driver.findElement(websiteUrlField).getAttribute("value");
    }


    // ==========================================
    // Special Input Methods
    // ==========================================

    /**
     * Enters a birth date using JavaScript.
     *
     * JavaScript is used to set the value of the date input field.
     */
    public void enterBirthDate(String birthDate) {
        WebElement birthDateElement = driver.findElement(birthDateField);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value = arguments[1];",
                birthDateElement,
                birthDate
        );
    }

    /**
     * Retrieves the selected birth date.
     */
    public String getBirthDateValue() {
        return driver.findElement(birthDateField).getAttribute("value");
    }

    /**
     * Enters a search query into the Search field.
     */
    public void enterSearchQuery(String searchQuery) {
        driver.findElement(searchBoxField).sendKeys(searchQuery);
    }

    /**
     * Retrieves the value entered in the Search field.
     */
    public String getSearchQueryValue() {
        return driver.findElement(searchBoxField).getAttribute("value");
    }

    /**
     * Enters a password into the Password field.
     */
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * Retrieves the value entered in the Password field.
     */
    public String getPasswordValue() {
        return driver.findElement(passwordField).getAttribute("value");
    }

    /**
     * Enters a confirmation password.
     */
    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    /**
     * Retrieves the value entered in the Confirm Password field.
     */
    public String getConfirmPasswordValue() {
        return driver.findElement(confirmPasswordField).getAttribute("value");
    }

    /**
     * Retrieves the predefined value of the Read-Only field.
     */
    public String getReadOnlyValue() {
        return driver.findElement(readOnlyField).getAttribute("value");
    }

    /**
     * Retrieves the predefined value of the Disabled field.
     */
    public String getDisabledValue() {
        return driver.findElement(disabledField).getAttribute("value");
    }


    // ==========================================
    // Text Area Methods
    // ==========================================

    /**
     * Enters text into the Biography text area.
     */
    public void enterBiography(String biography) {
        driver.findElement(biographyField).sendKeys(biography);
    }

    /**
     * Retrieves the value entered in the Biography text area.
     */
    public String getBiographyValue() {
        return driver.findElement(biographyField).getAttribute("value");
    }

    /**
     * Enters text into the Comments text area.
     */
    public void enterComments(String comments) {
        driver.findElement(commentsField).sendKeys(comments);
    }

    /**
     * Retrieves the value entered in the Comments text area.
     */
    public String getCommentsValue() {
        return driver.findElement(commentsField).getAttribute("value");
    }


    // ==========================================
    // Button Interaction Methods
    // ==========================================

    /**
     * Clicks the Submit button.
     */
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    /**
     * Retrieves the result message displayed after a button action.
     */
    public String getSubmitResult() {
        return driver.findElement(submitResult).getText();
    }

    /**
     * Clicks the Reset button.
     */
    public void clickResetButton() {
        driver.findElement(resetButton).click();
    }

    /**
     * Clicks the Success button.
     */
    public void clickSuccessButton() {
        driver.findElement(successButton).click();
    }

    /**
     * Clicks the Danger button.
     */
    public void clickDangerButton() {
        driver.findElement(dangerButton).click();
    }

    /**
     * Checks whether the Disabled button is enabled.
     *
     * @return true if the button is enabled; otherwise false
     */
    public boolean isDisabledButtonEnabled() {
        return driver.findElement(disabledButton).isEnabled();
    }

    /**
     * Clicks the Small button.
     */
    public void clickSmallButton() {
        driver.findElement(smallButton).click();
    }

    /**
     * Clicks the Large button.
     */
    public void clickLargeButton() {
        driver.findElement(largeButton).click();
    }


    // ==========================================
    // Navigation Link Methods
    // ==========================================

    /**
     * Clicks the Form Elements Practice Page link.
     */
    public void clickFormElementsPracticePageLink() {
        driver.findElement(formElementsPracticePageLink).click();
    }

    /**
     * Retrieves the destination URL of the Form Elements Practice Page link.
     */
    public String getFormElementsPracticePageLinkHref() {
        return driver.findElement(formElementsPracticePageLink)
                .getAttribute("href");
    }

    /**
     * Clicks the Data Tables link.
     */
    public void clickDataTablesLink() {
        driver.findElement(dataTablesLink).click();
    }

    /**
     * Retrieves the destination URL of the Data Tables link.
     */
    public String getDataTablesLinkHref() {
        return driver.findElement(dataTablesLink).getAttribute("href");
    }

    /**
     * Clicks the Alerts link.
     */
    public void clickAlertsLink() {
        driver.findElement(alertsLink).click();
    }

    /**
     * Retrieves the destination URL of the Alerts link.
     */
    public String getAlertsLinkHref() {
        return driver.findElement(alertsLink).getAttribute("href");
    }

    /**
     * Clicks the Dynamic Elements link.
     */
    public void clickDynamicElementsLink() {
        driver.findElement(dynamicElementsLink).click();
    }

    /**
     * Retrieves the destination URL of the Dynamic Elements link.
     */
    public String getDynamicElementsLinkHref() {
        return driver.findElement(dynamicElementsLink).getAttribute("href");
    }

    /**
     * Clicks the Drag and Drop link.
     */
    public void clickDragDropLink() {
        driver.findElement(dragDropLink).click();
    }

    /**
     * Retrieves the destination URL of the Drag and Drop link.
     */
    public String getDragDropLinkHref() {
        return driver.findElement(dragDropLink)
                .getAttribute("href");
    }
}
