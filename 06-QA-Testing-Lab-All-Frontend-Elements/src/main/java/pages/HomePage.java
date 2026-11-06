
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * HomePage Class
 *
 * Contains locators and reusable methods for navigating
 * from the home page to different sections of the QA Testing Lab.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class HomePage extends BasePage {

    // ==========================================
    // Page Navigation Locators
    // ==========================================

    // Form Elements
    private By formElementsLink = By.id("card-forms");

    // Dropdowns
    private By dropdownsLink = By.id("card-dropdowns");

    // Checkboxes and Radio Buttons
    private By checkboxesRadioButtonsLink = By.id("card-checkboxes");

    // Tables
    private By tablesLink = By.id("nav-tables");

    // Alerts and Popups
    private By alertsLink = By.id("nav-alerts");

    // Dynamic Elements
    private By dynamicLink = By.id("nav-dynamic");

    // iFrames
    private By iframesLink = By.id("nav-iframe");

    // File Upload
    private By fileUploadLink = By.id("nav-upload");

    // Drag and Drop
    private By dragDropLink = By.id("nav-dragdrop");


    // ==========================================
    // Constructor
    // ==========================================

    public HomePage(WebDriver driver) {
        super(driver);
    }


    // ==========================================
    // Page Navigation Methods
    // ==========================================

    /**
     * Navigates to the Form Elements page.
     */
    public void clickFormElements() {
        driver.findElement(formElementsLink).click();
    }

    /**
     * Navigates to the Dropdowns page.
     */
    public void clickDropdowns() {
        driver.findElement(dropdownsLink).click();
    }

    /**
     * Navigates to the Checkboxes and Radio Buttons page.
     */
    public void clickCheckboxesRadioButtons() {
        driver.findElement(checkboxesRadioButtonsLink).click();
    }

    /**
     * Navigates to the Tables page.
     */
    public void clickTables() {
        driver.findElement(tablesLink).click();
    }

    /**
     * Navigates to the Alerts page.
     */
    public void clickAlerts() {
        driver.findElement(alertsLink).click();
    }

    /**
     * Navigates to the Dynamic Elements page.
     */
    public void clickDynamicLink() {
        driver.findElement(dynamicLink).click();
    }

    /**
     * Navigates to the iFrames page.
     */
    public void clickIframesLink() {
        driver.findElement(iframesLink).click();
    }

    /**
     * Navigates to the File Upload page.
     */
    public void clickFileUploadLink() {
        driver.findElement(fileUploadLink).click();
    }

    /**
     * Navigates to the Drag and Drop page.
     */
    public void clickDragDropLink() {
        driver.findElement(dragDropLink).click();
    }
}
