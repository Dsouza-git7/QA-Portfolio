
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * TablesPage Class
 *
 * Contains Page Object methods for interacting with static,
 * searchable, sortable and complex tables on the practice page.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class TablesPage extends BasePage {

    // ==========================================
    // Static Table Locators
    // ==========================================

    private By staticTable = By.id("static-table");
    private By staticTableRows = By.cssSelector("#static-table tbody tr");
    private By staticTableHeaders = By.cssSelector("#static-table thead th");


    // ==========================================
    // Searchable and Sortable Table Locators
    // ==========================================

    private By tableSearchInput = By.id("table-search-input");
    private By searchableTable = By.id("searchable-table");
    private By searchableTableRows = By.cssSelector("#searchable-table tbody tr");

    // Sortable Score Column
    private By scoreColumn = By.id("sort-score");

    // Student 5 Edit Button
    private By editButton5 = By.id("edit-btn-5");
    private By tableActionResult = By.id("table-action-result");


    // ==========================================
    // Complex Table Locators
    // ==========================================

    private By complexTableRows = By.cssSelector("tr[id^='complex-row-']");
    private By engineeringHeader = By.xpath("//th[normalize-space()='Engineering']");
    private By qaHeader = By.xpath("//th[normalize-space()='QA']");


    // ==========================================
    // Constructor
    // ==========================================

    /**
     * Initializes the WebDriver instance for the tables page.
     *
     * @param driver WebDriver instance passed from the test class
     */
    public TablesPage(WebDriver driver) {
        super(driver);
    }


    // ==========================================
    // Static Table Methods
    // ==========================================

    /**
     * Checks whether the static table is displayed.
     *
     * @return true if the table is displayed, otherwise false
     */
    public boolean isStaticTableDisplayed() {
        return driver.findElement(staticTable).isDisplayed();
    }

    /**
     * Retrieves the number of data rows in the static table.
     *
     * @return Number of data rows
     */
    public int getStaticTableRowCount() {
        return driver.findElements(staticTableRows).size();
    }

    /**
     * Retrieves the number of columns in the static table.
     *
     * @return Number of table columns
     */
    public int getStaticTableColumnCount() {
        return driver.findElements(staticTableHeaders).size();
    }

    /**
     * Retrieves a cell value using its row and column numbers.
     *
     * @param row Row number (1-based)
     * @param column Column number (1-based)
     * @return Text value of the specified table cell
     */
    public String getStaticTableCellValue(int row, int column) {
        return driver.findElement(
                By.xpath("//table[@id='static-table']/tbody/tr["
                        + row + "]/td[" + column + "]")).getText();
    }

    /**
     * Retrieves the header text for a specified column.
     *
     * @param column Column number (1-based)
     * @return Table header text
     */
    public String getStaticTableHeader(int column) {
        return driver.findElement(
                By.cssSelector("#static-table thead th:nth-child("
                        + column + ")")).getText();
    }

    /**
     * Retrieves the name of a specific employee from the static table.
     *
     * @param name Employee name to locate
     * @return Employee name text
     */
    public String getEmployeeName(String name) {
        return driver.findElement(
                By.xpath("//table[@id='static-table']//td[text()='" + name + "']")).getText();
    }


    // ==========================================
    // Searchable Table Methods
    // ==========================================

    /**
     * Searches the table using a name, city or status.
     *
     * @param searchText Text to enter in the search field
     */
    public void enterTableSearch(String searchText) {
        driver.findElement(tableSearchInput).clear();
        driver.findElement(tableSearchInput).sendKeys(searchText);
    }

    /**
     * Retrieves the number of currently displayed student rows.
     *
     * @return Number of visible rows
     */
    public int getSearchableTableRowCount() {
        List<WebElement> rows = driver.findElements(searchableTableRows);

        int visibleRowCount = 0;

        for (WebElement row : rows) {
            if (row.isDisplayed()) {
                visibleRowCount++;
            }
        }

        return visibleRowCount;
    }

    /**
     * Clears the table search input.
     */
    public void clearTableSearch() {
        WebElement searchBox = driver.findElement(tableSearchInput);
        searchBox.clear();
        searchBox.sendKeys(" ");
        searchBox.clear();
    }

    /**
     * Checks whether the searchable table is displayed.
     *
     * @return true if the table is displayed, otherwise false
     */
    public boolean isSearchableTableDisplayed() {
        return driver.findElement(searchableTable).isDisplayed();
    }


    // ==========================================
    // Sortable Table Methods
    // ==========================================

    /**
     * Retrieves all score column values from the searchable table.
     *
     * @return List of score values
     */
    public List<String> getScoreColumnValues() {
        List<WebElement> scores = driver.findElements(
                By.cssSelector("#searchable-table tbody tr td:nth-child(4)")
        );

        List<String> scoreValues = new ArrayList<>();

        for (WebElement score : scores) {
            scoreValues.add(score.getText());
        }

        return scoreValues;
    }

    /**
     * Clicks the Score column header to sort the table.
     */
    public void clickScoreColumn() {
        driver.findElement(scoreColumn).click();
    }


    // ==========================================
    // Table Action Methods
    // ==========================================

    /**
     * Checks whether the Edit button for Student 5 is displayed.
     *
     * @return true if displayed, otherwise false
     */
    public boolean isEditButton5Displayed() {
        return driver.findElement(editButton5).isDisplayed();
    }

    /**
     * Checks whether the Edit button for Student 5 is enabled.
     *
     * @return true if enabled, otherwise false
     */
    public boolean isEditButton5Enabled() {
        return driver.findElement(editButton5).isEnabled();
    }

    /**
     * Clicks the Edit button for Student 5.
     */
    public void clickEditButton5() {
        driver.findElement(editButton5).click();
    }

    /**
     * Retrieves the result displayed after performing a table action.
     *
     * @return Table action result text
     */
    public String getTableActionResult() {
        return driver.findElement(tableActionResult).getText();
    }


    // ==========================================
    // Complex Table Methods
    // ==========================================

    /**
     * Retrieves the number of data rows in the complex table.
     *
     * @return Number of complex table rows
     */
    public int getComplexTableRowCount() {
        return driver.findElements(complexTableRows).size();
    }

    /**
     * Retrieves the Q2 Engineering Fail value.
     *
     * @return Q2 Engineering Fail cell value
     */
    public String getQ2EngineeringFail() {
        return driver.findElement(
                By.xpath("//tr[@id='complex-row-q2']/td[3]")
        ).getText();
    }

    /**
     * Retrieves the Q3 Total value.
     *
     * @return Q3 Total cell value
     */
    public String getQ3Total() {
        return driver.findElement(
                By.xpath("//td[@class='cell-quarter' and normalize-space()='Q3']/following-sibling::td[last()]")
        ).getText();
    }

    /**
     * Checks whether the Engineering column header is displayed.
     *
     * @return true if displayed, otherwise false
     */
    public boolean isEngineeringHeaderDisplayed() {
        return driver.findElement(engineeringHeader).isDisplayed();
    }

    /**
     * Checks whether the QA column header is displayed.
     *
     * @return true if displayed, otherwise false
     */
    public boolean isQaHeaderDisplayed() {
        return driver.findElement(qaHeader).isDisplayed();
    }
}
