
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * DragDropPage Class
 *
 * Contains Page Object methods for interacting with simple drag-and-drop
 * elements, Kanban board cards and technology categorisation buckets.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class DragDropPage extends BasePage {

    // ==========================================
    // Page Heading Locator
    // ==========================================

    private final By pageHeading = By.cssSelector(".page-title h1");


    // ==========================================
    // Simple Drag-and-Drop Locators
    // ==========================================

    private By dragItem1 = By.id("drag-item-1");
    private By dragItem2 = By.id("drag-item-2");
    private By dragItem3 = By.id("drag-item-3");
    private By dropTarget = By.id("drop-target-1");
    private By simpleDndResult = By.id("simple-dnd-result");
    private By resetSimpleDndButton = By.id("reset-simple-dnd-btn");


    // ==========================================
    // Kanban Board Locators
    // ==========================================

    // Kanban Columns
    private By todoColumn = By.id("kanban-todo");
    private By inProgressColumn = By.id("kanban-inprogress");
    private By doneColumn = By.id("kanban-done");

    // Kanban Cards
    private By kanbanCard1 = By.id("kanban-card-1");
    private By kanbanCard2 = By.id("kanban-card-2");
    private By kanbanCard3 = By.id("kanban-card-3");
    private By kanbanCard4 = By.id("kanban-card-4");
    private By kanbanCard5 = By.id("kanban-card-5");

    // Kanban Column Counts and Result
    private By todoCount = By.id("todo-count");
    private By inProgressCount = By.id("inprogress-count");
    private By doneCount = By.id("done-count");
    private By kanbanResult = By.id("kanban-result");


    // ==========================================
    // Sort into Categories Locators
    // ==========================================

    // Technology Chips
    private By chipSelenium = By.id("chip-selenium");
    private By chipReact = By.id("chip-react");
    private By chipPytest = By.id("chip-pytest");
    private By chipDjango = By.id("chip-django");
    private By chipVue = By.id("chip-vue");
    private By chipFastApi = By.id("chip-fastapi");
    private By chipPlaywright = By.id("chip-playwright");
    private By chipNextjs = By.id("chip-nextjs");

    // Category Buckets
    private By automationBucket = By.id("bucket-automation");
    private By frontendBucket = By.id("bucket-frontend");
    private By backendBucket = By.id("bucket-backend");
    private By miscBucket = By.id("bucket-misc");

    // Category Result
    private By bucketResult = By.id("bucket-result");


    // ==========================================
    // Constructor
    // ==========================================

    /**
     * Initializes the WebDriver instance for the drag-and-drop page.
     *
     * @param driver WebDriver instance passed from the test class
     */
    public DragDropPage(WebDriver driver) {
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
    // Simple Drag-and-Drop Methods
    // ==========================================

    /**
     * Drags the first item into the drop zone.
     */
    public void dragItem1ToDropZone() {
        new Actions(driver).dragAndDrop(
                driver.findElement(dragItem1),
                driver.findElement(dropTarget)
        ).perform();
    }

    /**
     * Drags the second item into the drop zone.
     */
    public void dragItem2ToDropZone() {
        new Actions(driver).dragAndDrop(
                driver.findElement(dragItem2),
                driver.findElement(dropTarget)
        ).perform();
    }

    /**
     * Drags the third item into the drop zone.
     */
    public void dragItem3ToDropZone() {
        new Actions(driver).dragAndDrop(
                driver.findElement(dragItem3),
                driver.findElement(dropTarget)
        ).perform();
    }

    /**
     * Retrieves the simple drag-and-drop result.
     *
     * @return Drag-and-drop result text
     */
    public String getSimpleDndResult() {
        return driver.findElement(simpleDndResult).getText().trim();
    }

    /**
     * Clicks the button to reset the simple drag-and-drop exercise.
     */
    public void clickResetSimpleDnd() {
        driver.findElement(resetSimpleDndButton).click();
    }


    // ==========================================
    // Kanban Board Methods
    // ==========================================

    /**
     * Moves the first Kanban card to the In Progress column.
     */
    public void moveCard1ToInProgress() {
        new Actions(driver).dragAndDrop(
                driver.findElement(kanbanCard1),
                driver.findElement(inProgressColumn)
        ).perform();
    }

    /**
     * Moves the second Kanban card to the Done column.
     */
    public void moveCard2ToDone() {
        new Actions(driver).dragAndDrop(
                driver.findElement(kanbanCard2),
                driver.findElement(doneColumn)
        ).perform();
    }

    /**
     * Moves the third Kanban card to the Done column.
     */
    public void moveCard3ToDone() {
        new Actions(driver).dragAndDrop(
                driver.findElement(kanbanCard3),
                driver.findElement(doneColumn)
        ).perform();
    }

    /**
     * Moves the fourth Kanban card to the Done column.
     */
    public void moveCard4ToDone() {
        new Actions(driver).dragAndDrop(
                driver.findElement(kanbanCard4),
                driver.findElement(doneColumn)
        ).perform();
    }

    /**
     * Moves the fifth Kanban card to the Done column.
     */
    public void moveCard5ToDone() {
        new Actions(driver).dragAndDrop(
                driver.findElement(kanbanCard5),
                driver.findElement(doneColumn)
        ).perform();
    }

    /**
     * Retrieves the number of cards in the To Do column.
     *
     * @return To Do card count
     */
    public String getTodoCount() {
        return driver.findElement(todoCount).getText().trim();
    }

    /**
     * Retrieves the number of cards in the In Progress column.
     *
     * @return In Progress card count
     */
    public String getInProgressCount() {
        return driver.findElement(inProgressCount).getText().trim();
    }

    /**
     * Retrieves the number of cards in the Done column.
     *
     * @return Done card count
     */
    public String getDoneCount() {
        return driver.findElement(doneCount).getText().trim();
    }

    /**
     * Retrieves the Kanban board result.
     *
     * @return Kanban result text
     */
    public String getKanbanResult() {
        return driver.findElement(kanbanResult).getText().trim();
    }


    // ==========================================
    // Sort into Categories Methods
    // ==========================================

    /**
     * Drags the Selenium technology chip into the Automation bucket.
     */
    public void dragSeleniumToAutomation() {
        new Actions(driver).dragAndDrop(
                driver.findElement(chipSelenium),
                driver.findElement(automationBucket)
        ).perform();
    }

    /**
     * Drags the React technology chip into the Frontend bucket.
     */
    public void dragReactToFrontend() {
        new Actions(driver).dragAndDrop(
                driver.findElement(chipReact),
                driver.findElement(frontendBucket)
        ).perform();
    }

    /**
     * Drags the Pytest technology chip into the Automation bucket.
     */
    public void dragPytestToAutomation() {
        new Actions(driver).dragAndDrop(
                driver.findElement(chipPytest),
                driver.findElement(automationBucket)
        ).perform();
    }

    /**
     * Drags the Django technology chip into the Backend bucket
     * using JavaScript drag-and-drop events.
     */
    public void dragDjangoToBackend() {
        ((JavascriptExecutor) driver).executeScript(
                "const source = arguments[0];" +
                        "const target = arguments[1];" +
                        "const dataTransfer = new DataTransfer();" +

                        "source.dispatchEvent(new DragEvent('dragstart', {" +
                        "bubbles: true, cancelable: true, dataTransfer: dataTransfer}));" +

                        "target.dispatchEvent(new DragEvent('dragover', {" +
                        "bubbles: true, cancelable: true, dataTransfer: dataTransfer}));" +

                        "target.dispatchEvent(new DragEvent('drop', {" +
                        "bubbles: true, cancelable: true, dataTransfer: dataTransfer}));" +

                        "source.dispatchEvent(new DragEvent('dragend', {" +
                        "bubbles: true, cancelable: true, dataTransfer: dataTransfer}));",

                driver.findElement(chipDjango),
                driver.findElement(backendBucket)
        );
    }

    /**
     * Drags the Vue technology chip into the Frontend bucket.
     */
    public void dragVueToFrontend() {
        new Actions(driver).dragAndDrop(
                driver.findElement(chipVue),
                driver.findElement(frontendBucket)
        ).perform();
    }

    /**
     * Drags the FastAPI technology chip into the Backend bucket
     * using JavaScript drag-and-drop events.
     */
    public void dragFastApiToBackend() {
        ((JavascriptExecutor) driver).executeScript(
                "const source = arguments[0];" +
                        "const target = arguments[1];" +
                        "const dataTransfer = new DataTransfer();" +

                        "source.dispatchEvent(new DragEvent('dragstart', {" +
                        "bubbles: true, cancelable: true, dataTransfer: dataTransfer}));" +

                        "target.dispatchEvent(new DragEvent('dragover', {" +
                        "bubbles: true, cancelable: true, dataTransfer: dataTransfer}));" +

                        "target.dispatchEvent(new DragEvent('drop', {" +
                        "bubbles: true, cancelable: true, dataTransfer: dataTransfer}));" +

                        "source.dispatchEvent(new DragEvent('dragend', {" +
                        "bubbles: true, cancelable: true, dataTransfer: dataTransfer}));",

                driver.findElement(chipFastApi),
                driver.findElement(backendBucket)
        );
    }

    /**
     * Drags the Playwright technology chip into the Automation bucket.
     */
    public void dragPlaywrightToAutomation() {
        new Actions(driver).dragAndDrop(
                driver.findElement(chipPlaywright),
                driver.findElement(automationBucket)
        ).perform();
    }

    /**
     * Drags the Next.js technology chip into the Frontend bucket.
     */
    public void dragNextjsToFrontend() {
        new Actions(driver).dragAndDrop(
                driver.findElement(chipNextjs),
                driver.findElement(frontendBucket)
        ).perform();
    }

    /**
     * Retrieves the category sorting result.
     *
     * @return Category sorting result text
     */
    public String getBucketResult() {
        return driver.findElement(bucketResult).getText().trim();
    }

    /**
     * Checks whether a technology chip is present inside a category bucket.
     *
     * @param chipId ID of the technology chip
     * @param bucketId ID of the category bucket
     * @return true if the chip is found inside the bucket, otherwise false
     */
    public boolean isChipInBucket(String chipId, String bucketId) {
        return !driver.findElement(By.id(bucketId))
                .findElements(By.id(chipId))
                .isEmpty();
    }
}
