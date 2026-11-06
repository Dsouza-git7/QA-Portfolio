package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * DropDownsPage Class
 *
 * Contains Page Object methods for interacting with dropdown elements
 * on the Dropdowns Practice Page.
 *
 * Design Pattern: Page Object Model (POM)
 */
public class DropDownsPage extends BasePage {

    // ==========================================
    // Dropdown Locators
    // ==========================================

    // Country Dropdown
    private By countryDropdown = By.id("country-select");
    private By countryResult = By.id("country-result");

    // Chained Dropdowns
    private By continentDropdown = By.id("continent-select");
    private By cityDropdown = By.id("city-select");
    private By chainedResult = By.id("chained-result");

    // Multi-Select Dropdown
    private By skillsDropdown = By.id("skills-select");


    // ==========================================
    // Constructor
    // ==========================================

    /**
     * Initializes the WebDriver instance for the dropdowns page.
     *
     * @param driver WebDriver instance passed from the test class
     */
    public DropDownsPage(WebDriver driver) {
        super(driver);
    }


    // ==========================================
    // Country Dropdown Methods
    // ==========================================

    /**
     * Selects a country using its visible text.
     *
     * @param country Country name to select
     */
    public void selectCountryByVisibleText(String country) {
        Select select = new Select(driver.findElement(countryDropdown));
        select.selectByVisibleText(country);
    }

    /**
     * Retrieves the displayed country selection result.
     *
     * @return Country selection result text
     */
    public String getCountryResult() {
        return driver.findElement(countryResult).getText();
    }


    // ==========================================
    // Chained Dropdown Methods
    // ==========================================

    /**
     * Selects a continent using its visible text.
     *
     * @param continent Continent name to select
     */
    public void selectContinentByVisibleText(String continent) {
        Select select = new Select(driver.findElement(continentDropdown));
        select.selectByVisibleText(continent);
    }

    /**
     * Selects a city using its visible text.
     *
     * @param city City name to select
     */
    public void selectCityByVisibleText(String city) {
        Select select = new Select(driver.findElement(cityDropdown));
        select.selectByVisibleText(city);
    }

    /**
     * Retrieves the displayed chained dropdown selection result.
     *
     * @return Chained dropdown result text
     */
    public String getChainedResult() {
        return driver.findElement(chainedResult).getText();
    }


    // ==========================================
    // Multi-Select Dropdown Methods
    // ==========================================

    /**
     * Selects multiple skills using their visible text.
     *
     * @param skills Skill names to select
     */
    public void selectSkills(String... skills) {
        Select select = new Select(driver.findElement(skillsDropdown));

        for (String skill : skills) {
            select.selectByVisibleText(skill);
        }
    }

    /**
     * Retrieves all currently selected skills.
     *
     * @return List of selected skill names
     */
    public List<String> getSelectedSkills() {
        Select select = new Select(driver.findElement(skillsDropdown));

        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> selectedSkills = new ArrayList<>();

        for (WebElement option : selectedOptions) {
            selectedSkills.add(option.getText());
        }

        return selectedSkills;
    }
}