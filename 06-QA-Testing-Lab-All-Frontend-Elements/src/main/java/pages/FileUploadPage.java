
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * FileUploadPage Class
 *
 * Contains Page Object methods for interacting with different file upload
 * options, including single file upload, multiple file upload, filtered
 * file input, drag-and-drop upload and form-based file submission.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class FileUploadPage extends BasePage {

    // ==========================================
    // Page Heading Locator
    // ==========================================

    private final By pageHeading = By.cssSelector(".page-title h1");


    // ==========================================
    // Simple File Upload Locators
    // ==========================================

    private By simpleFileInput = By.id("simple-file-input");
    private By simpleFileResult = By.id("simple-file-result");


    // ==========================================
    // Multiple File Upload Locators
    // ==========================================

    private By multiFileInput = By.id("multi-file-input");


    // ==========================================
    // Filtered File Input Locators
    // ==========================================

    private By imageFileInput = By.id("image-file-input");
    private By imageFileResult = By.id("image-file-result");


    // ==========================================
    // Drag-and-Drop Upload Locators
    // ==========================================

    private By hiddenDropInput = By.id("hidden-drop-input");


    // ==========================================
    // Form-Based File Upload Locators
    // ==========================================

    private By uploaderName = By.id("uploader-name");
    private By formFileInput = By.id("form-file-input");
    private By fileDescription = By.id("file-description");
    private By uploadSubmitButton = By.id("upload-submit-btn");
    private By uploadResetButton = By.id("upload-reset-btn");
    private By uploadFormResult = By.id("upload-form-result");


    // ==========================================
    // Constructor
    // ==========================================

    /**
     * Initializes the WebDriver instance for the file upload page.
     *
     * @param driver WebDriver instance passed from the test class
     */
    public FileUploadPage(WebDriver driver) {
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
    // Simple File Upload Methods
    // ==========================================

    /**
     * Uploads a single file using the file input element.
     *
     * @param filePath Absolute path of the file to upload
     */
    public void uploadSimpleFile(String filePath) {
        driver.findElement(simpleFileInput).sendKeys(filePath);
    }

    /**
     * Retrieves the result displayed after uploading a single file.
     *
     * @return File upload result text
     */
    public String getSimpleFileResult() {
        return driver.findElement(simpleFileResult).getText().trim();
    }


    // ==========================================
    // Multiple File Upload Methods
    // ==========================================

    /**
     * Uploads multiple files using the multiple file input element.
     *
     * @param filePaths File paths to upload
     */
    public void uploadMultipleFiles(String filePaths) {
        driver.findElement(multiFileInput).sendKeys(filePaths);
    }

    /**
     * Retrieves the names of all selected files.
     *
     * @return Comma-separated list of selected filenames
     */
    public String getMultipleFileNames() {
        return (String) ((JavascriptExecutor) driver)
                .executeScript(
                        "return Array.from(arguments[0].files)"
                                + ".map(file => file.name).join(',');",
                        driver.findElement(multiFileInput)
                );
    }


    // ==========================================
    // Filtered File Input Methods
    // ==========================================

    /**
     * Uploads an image file using the filtered file input.
     *
     * @param filePath Absolute path of the image file
     */
    public void uploadImageFile(String filePath) {
        driver.findElement(imageFileInput).sendKeys(filePath);
    }

    /**
     * Retrieves the name of the selected image file.
     *
     * @return Selected image filename
     */
    public String getSelectedImageFileName() {
        return (String) ((JavascriptExecutor) driver)
                .executeScript(
                        "return arguments[0].files[0].name;",
                        driver.findElement(imageFileInput)
                );
    }

    /**
     * Retrieves the image file upload result text.
     *
     * @return Image upload result text
     */
    public String getImageFileResult() {
        return driver.findElement(imageFileResult).getText().trim();
    }


    // ==========================================
    // Drag-and-Drop Upload Methods
    // ==========================================

    /**
     * Uploads a file through the hidden file input
     * associated with the drag-and-drop upload zone.
     *
     * @param filePath Absolute path of the file to upload
     */
    public void uploadFileUsingDropZone(String filePath) {
        driver.findElement(hiddenDropInput).sendKeys(filePath);
    }

    /**
     * Retrieves the name of the file uploaded through the drop zone.
     *
     * @return Uploaded filename
     */
    public String getDropZoneUploadedFileName() {
        return (String) ((JavascriptExecutor) driver)
                .executeScript(
                        "return arguments[0].files[0].name;",
                        driver.findElement(hiddenDropInput)
                );
    }


    // ==========================================
    // Form-Based File Upload Methods
    // ==========================================

    /**
     * Enters the uploader's name.
     *
     * @param name Uploader name
     */
    public void enterUploaderName(String name) {
        driver.findElement(uploaderName).sendKeys(name);
    }

    /**
     * Uploads an assignment file through the form.
     *
     * @param filePath Absolute path of the assignment file
     */
    public void uploadAssignmentFile(String filePath) {
        driver.findElement(formFileInput).sendKeys(filePath);
    }

    /**
     * Enters the file description.
     *
     * @param description Description of the uploaded file
     */
    public void enterFileDescription(String description) {
        driver.findElement(fileDescription).sendKeys(description);
    }

    /**
     * Clicks the Submit Assignment button.
     */
    public void clickSubmitAssignment() {
        driver.findElement(uploadSubmitButton).click();
    }

    /**
     * Retrieves the form submission result.
     *
     * @return Upload form result text
     */
    public String getUploadFormResult() {
        return driver.findElement(uploadFormResult).getText().trim();
    }

    /**
     * Clicks the Reset Form button.
     */
    public void clickResetUploadForm() {
        driver.findElement(uploadResetButton).click();
    }


    // ==========================================
    // Upload Form Reset Verification Methods
    // ==========================================

    /**
     * Retrieves the current uploader name field value.
     *
     * @return Uploader name field value
     */
    public String getUploaderNameValue() {
        return driver.findElement(uploaderName).getAttribute("value");
    }

    /**
     * Retrieves the current file description field value.
     *
     * @return File description field value
     */
    public String getFileDescriptionValue() {
        return driver.findElement(fileDescription).getAttribute("value");
    }

    /**
     * Retrieves the number of files currently selected
     * in the assignment file input.
     *
     * @return Number of selected files
     */
    public int getAssignmentFileCount() {
        return ((Number) ((JavascriptExecutor) driver)
                .executeScript(
                        "return arguments[0].files.length;",
                        driver.findElement(formFileInput)
                )).intValue();
    }
}
