
package pages;

import base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * AlertsPage Class
 *
 * Contains Page Object methods for interacting with JavaScript alerts,
 * confirm and prompt dialogs, inline notifications and custom modal popups.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class AlertsPage extends BasePage {

    // ==========================================
    // JavaScript Alert Locators
    // ==========================================

    private By triggerAlertButton = By.id("trigger-alert-btn");


    // ==========================================
    // JavaScript Confirm Dialog Locators
    // ==========================================

    private By triggerConfirmButton = By.id("trigger-confirm-btn");


    // ==========================================
    // JavaScript Prompt Dialog Locators
    // ==========================================

    private By triggerPromptButton = By.id("trigger-prompt-btn");
    private By promptResult = By.id("prompt-result");


    // ==========================================
    // Inline Notification Locators
    // ==========================================

    // Notification Buttons
    private By showSuccessButton = By.id("show-success-btn");
    private By showErrorButton = By.id("show-error-btn");
    private By showInfoButton = By.id("show-info-alert-btn");
    private By hideAllButton = By.id("hide-all-alerts-btn");

    // Notification Elements
    private By successNotification = By.id("success-notification");
    private By errorNotification = By.id("error-notification");
    private By infoNotification = By.id("info-notification");


    // ==========================================
    // Custom Modal Popup Locators
    // ==========================================

    private By openModalButton = By.id("open-modal-btn");
    private By modalConfirmButton = By.id("modal-confirm-btn");
    private By modalCancelButton = By.id("modal-cancel-btn");
    private By modalInput = By.id("modal-input");
    private By infoModal = By.id("info-modal");
    private By modalResult = By.id("modal-result");


    // ==========================================
    // Danger Modal Locators
    // ==========================================

    private By openDangerModalButton = By.id("open-danger-modal-btn");
    private By dangerModalCancelButton = By.id("danger-modal-cancel-btn");
    private By dangerModalConfirmButton = By.id("danger-modal-confirm-btn");
    private By dangerModal = By.id("danger-modal");


    // ==========================================
    // Constructor
    // ==========================================

    /**
     * Initializes the WebDriver instance for the alerts page.
     *
     * @param driver WebDriver instance passed from the test class
     */
    public AlertsPage(WebDriver driver) {
        super(driver);
    }


    // ==========================================
    // JavaScript Alert Methods
    // ==========================================

    /**
     * Clicks the button to trigger a JavaScript alert.
     */
    public void clickTriggerAlertButton() {
        driver.findElement(triggerAlertButton).click();
    }

    /**
     * Retrieves the text displayed in the JavaScript alert.
     *
     * @return Alert message text
     */
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    /**
     * Accepts the JavaScript alert.
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }


    // ==========================================
    // JavaScript Confirm Dialog Methods
    // ==========================================

    /**
     * Clicks the button to trigger a JavaScript confirm dialog.
     */
    public void clickTriggerConfirmButton() {
        driver.findElement(triggerConfirmButton).click();
    }

    /**
     * Retrieves the text displayed in the confirm dialog.
     *
     * @return Confirm dialog message text
     */
    public String getConfirmDialogText() {
        return driver.switchTo().alert().getText();
    }

    /**
     * Accepts the JavaScript confirm dialog.
     */
    public void acceptConfirmDialog() {
        driver.switchTo().alert().accept();
    }

    /**
     * Dismisses the JavaScript confirm dialog.
     */
    public void dismissConfirmDialog() {
        driver.switchTo().alert().dismiss();
    }


    // ==========================================
    // JavaScript Prompt Dialog Methods
    // ==========================================

    /**
     * Clicks the button to trigger a JavaScript prompt dialog.
     */
    public void clickTriggerPromptButton() {
        driver.findElement(triggerPromptButton).click();
    }

    /**
     * Retrieves the text displayed in the prompt dialog.
     *
     * @return Prompt dialog message text
     */
    public String getPromptDialogText() {
        return driver.switchTo().alert().getText();
    }

    /**
     * Enters text into the JavaScript prompt dialog.
     *
     * @param text Text to enter into the prompt
     */
    public void enterPromptText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    /**
     * Accepts the JavaScript prompt dialog.
     */
    public void acceptPromptDialog() {
        driver.switchTo().alert().accept();
    }

    /**
     * Dismisses the JavaScript prompt dialog.
     */
    public void dismissPromptDialog() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * Retrieves the result displayed after submitting the prompt.
     *
     * @return Prompt result text
     */
    public String getPromptResult() {
        return driver.findElement(promptResult).getText();
    }


    // ==========================================
    // Inline Notification Methods
    // ==========================================

    /**
     * Clicks the button to display a success notification.
     */
    public void clickShowSuccess() {
        driver.findElement(showSuccessButton).click();
    }

    /**
     * Clicks the button to display an error notification.
     */
    public void clickShowError() {
        driver.findElement(showErrorButton).click();
    }

    /**
     * Clicks the button to display an information notification.
     */
    public void clickShowInfo() {
        driver.findElement(showInfoButton).click();
    }

    /**
     * Clicks the button to hide all notifications.
     */
    public void clickHideAll() {
        driver.findElement(hideAllButton).click();
    }

    /**
     * Retrieves the success notification text.
     *
     * @return Success notification text
     */
    public String getSuccessNotificationText() {
        return driver.findElement(successNotification).getText();
    }

    /**
     * Retrieves the error notification text.
     *
     * @return Error notification text
     */
    public String getErrorNotificationText() {
        return driver.findElement(errorNotification).getText();
    }

    /**
     * Retrieves the information notification text.
     *
     * @return Information notification text
     */
    public String getInfoNotificationText() {
        return driver.findElement(infoNotification).getText();
    }

    /**
     * Checks whether an element identified by the supplied locator is visible.
     *
     * @param locator Locator of the notification element
     * @return true if at least one matching element is displayed, otherwise false
     */
    public boolean isNotificationVisible(By locator) {
        List<WebElement> elements = driver.findElements(locator);

        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks whether the success notification is visible.
     *
     * @return true if visible, otherwise false
     */
    public boolean isSuccessNotificationVisible() {
        return isNotificationVisible(successNotification);
    }

    /**
     * Checks whether the error notification is visible.
     *
     * @return true if visible, otherwise false
     */
    public boolean isErrorNotificationVisible() {
        return isNotificationVisible(errorNotification);
    }

    /**
     * Checks whether the information notification is visible.
     *
     * @return true if visible, otherwise false
     */
    public boolean isInfoNotificationVisible() {
        return isNotificationVisible(infoNotification);
    }


    // ==========================================
    // Custom Modal Popup Methods
    // ==========================================

    /**
     * Clicks the button to open the information modal.
     */
    public void clickOpenModal() {
        driver.findElement(openModalButton).click();
    }

    /**
     * Clicks the Confirm button in the information modal.
     */
    public void clickModalConfirm() {
        driver.findElement(modalConfirmButton).click();
    }

    /**
     * Clicks the Cancel button in the information modal.
     */
    public void clickModalCancel() {
        driver.findElement(modalCancelButton).click();
    }

    /**
     * Checks whether the information modal is visible.
     *
     * @return true if visible, otherwise false
     */
    public boolean isInfoModalVisible() {
        return driver.findElement(infoModal).isDisplayed();
    }

    /**
     * Enters text into the information modal input field.
     *
     * @param text Text to enter
     */
    public void enterModalInput(String text) {
        driver.findElement(modalInput).clear();
        driver.findElement(modalInput).sendKeys(text);
    }

    /**
     * Retrieves the result displayed after interacting with the modal.
     *
     * @return Modal result text
     */
    public String getModalResultText() {
        return driver.findElement(modalResult).getText();
    }

    /**
     * Checks whether the modal result is visible.
     *
     * @return true if visible, otherwise false
     */
    public boolean isModalResultVisible() {
        return driver.findElement(modalResult).isDisplayed();
    }


    // ==========================================
    // Danger Modal Methods
    // ==========================================

    /**
     * Clicks the button to open the danger confirmation modal.
     */
    public void clickOpenDangerModal() {
        driver.findElement(openDangerModalButton).click();
    }

    /**
     * Clicks the Cancel button in the danger modal.
     */
    public void clickDangerModalCancel() {
        driver.findElement(dangerModalCancelButton).click();
    }

    /**
     * Clicks the Confirm button in the danger modal.
     */
    public void clickDangerModalConfirm() {
        driver.findElement(dangerModalConfirmButton).click();
    }

    /**
     * Checks whether the danger modal is visible.
     *
     * @return true if visible, otherwise false
     */
    public boolean isDangerModalVisible() {
        return driver.findElement(dangerModal).isDisplayed();
    }
}
