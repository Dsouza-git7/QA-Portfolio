package tests;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AlertsPage;
import pages.CheckboxesRadioButtonsPage;
import pages.DragDropPage;
import pages.DropDownsPage;
import pages.DynamicElementsPage;
import pages.FileUploadPage;
import pages.FormElementsPage;
import pages.HomePage;
import pages.IframesPage;
import pages.TablesPage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * FirstTest Class
 *
 * Contains TestNG test cases for validating the functionality
 * of the QA Testing Lab practice website.
 *
 * Project: Selenium Automation Practice Project
 * Tester: Namritha Dsouza
 * Framework: Selenium WebDriver with TestNG
 * Design Pattern: Page Object Model (POM)
 * Language: Java
 */
public class FirstTest extends BaseTest {

    @Test
    public void verifyFormElementsNavigation() {

        HomePage homePage = new HomePage(driver);

        homePage.clickFormElements();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("form-elements.html"),
                "Form Elements page was not opened"
        );

// Form Elements
        FormElementsPage formElementsPage = new FormElementsPage(driver);
        formElementsPage.enterFirstName("John");
        String actualFirstName = formElementsPage.getFirstNameValue();
        formElementsPage.enterLastName("Smith");
        String actualLastName = formElementsPage.getLastNameValue();
        formElementsPage.enterEmail("john@example.com");
        String actualEmail = formElementsPage.getEmailValue();
        formElementsPage.enterPhoneNumber("+1 (555) 000-0000");
        String actualPhoneNumber = formElementsPage.getPhoneNumberValue();
        formElementsPage.enterAge("30");
        String actualAge = formElementsPage.getAgeValue();
        formElementsPage.enterWebsiteUrl("https://example.com");
        String actualWebsiteUrl = formElementsPage.getWebsiteUrlValue();
        formElementsPage.enterBirthDate("1990-05-15");
        String actualBirthDate = formElementsPage.getBirthDateValue();
        formElementsPage.enterSearchQuery("test search");
        String actualSearchQuery = formElementsPage.getSearchQueryValue();
        formElementsPage.enterPassword("password123");
        String actualPassword = formElementsPage.getPasswordValue();
        formElementsPage.enterConfirmPassword("password123");
        String actualConfirmPassword = formElementsPage.getConfirmPasswordValue();
        String actualReadOnlyValue = formElementsPage.getReadOnlyValue();
        String actualDisabledValue = formElementsPage.getDisabledValue();
        String biography = "I am learning Selenium automation.";
        formElementsPage.enterBiography(biography);
        String actualBiography = formElementsPage.getBiographyValue();
        String comments = "This is a test comment.";
        formElementsPage.enterComments(comments);
        String actualComments = formElementsPage.getCommentsValue();
        formElementsPage.clickSubmitButton();
        String actualSubmitResult = formElementsPage.getSubmitResult();
        formElementsPage.clickResetButton();
        String actualResetResult = formElementsPage.getSubmitResult();
        formElementsPage.clickSuccessButton();
        String actualSuccessResult = formElementsPage.getSubmitResult();
        formElementsPage.clickDangerButton();
        String actualDangerResult = formElementsPage.getSubmitResult();
        boolean isDisabledButtonEnabled = formElementsPage.isDisabledButtonEnabled();
        formElementsPage.clickSmallButton();
        String actualSmallButtonResult = formElementsPage.getSubmitResult();
        formElementsPage.clickLargeButton();
        String actualLargeButtonResult = formElementsPage.getSubmitResult();
        formElementsPage.clickFormElementsPracticePageLink();
        String actualHref = formElementsPage.getFormElementsPracticePageLinkHref();
        String actualDataTablesHref = formElementsPage.getDataTablesLinkHref();
        String actualAlertsHref = formElementsPage.getAlertsLinkHref();
        String actualDynamicElementsHref = formElementsPage.getDynamicElementsLinkHref();
        String actualDragDropHref = formElementsPage.getDragDropLinkHref();

        // Form Elements Assertions
        Assert.assertEquals(actualFirstName, "John",
                "First Name was not entered correctly");

        Assert.assertEquals(actualLastName, "Smith",
                "Last Name was not entered correctly");

        Assert.assertEquals(actualEmail, "john@example.com",
                "Email was not entered correctly");
        Assert.assertEquals(actualPhoneNumber, "+1 (555) 000-0000",
                "Phone Number was not entered correctly");
        Assert.assertEquals(actualAge, "30",
                "Age was not entered correctly");
        Assert.assertEquals(actualWebsiteUrl, "https://example.com",
                "Website URL was not entered correctly");
        Assert.assertEquals(actualBirthDate, "1990-05-15",
                "Birth Date was not entered correctly");
        Assert.assertEquals(actualSearchQuery, "test search",
                "Search Query was not entered correctly");
        Assert.assertEquals(actualPassword, "password123",
                "Password was not entered correctly");
        Assert.assertEquals(actualConfirmPassword, "password123",
                "Confirm Password was not entered correctly");
        Assert.assertEquals(actualReadOnlyValue, "This field is read-only",
                "Read-Only field was not entered correctly");
        Assert.assertEquals(actualDisabledValue, "This field is disabled",
                "Disabled field value is incorrect");
        Assert.assertEquals(actualBiography, biography,
                "Biography was not entered correctly");
        Assert.assertEquals(actualComments, comments,
                "Comments were not entered correctly");
        Assert.assertEquals(actualSubmitResult, "✅ Submit button clicked!",
                "Submit button result was not displayed correctly");
        Assert.assertEquals(actualResetResult, "✅ Reset button clicked!",
                "Reset button result was not displayed correctly");
        Assert.assertEquals(actualSuccessResult, "✅ Success button clicked!",
                "Success button result was not displayed correctly");
        Assert.assertEquals(actualDangerResult, "✅ Danger button clicked!",
                "Danger button result was not displayed correctly");
        Assert.assertFalse(isDisabledButtonEnabled, "Disabled button should not be enabled");
        Assert.assertEquals(actualSmallButtonResult, "✅ Small button clicked!",
                "Small button result was not displayed correctly");
        Assert.assertEquals(actualLargeButtonResult, "✅ Large button clicked!",
                "Large button result was not displayed correctly");
        Assert.assertTrue(actualHref.endsWith("form-elements.html"),
                "Form Elements Practice Page link has an incorrect destination");
        Assert.assertTrue(actualDataTablesHref.endsWith("tables.html"),
                "Data Tables link has an incorrect destination");
        Assert.assertTrue(actualAlertsHref.endsWith("alerts.html"),
                "Alerts link has an incorrect destination");
        Assert.assertTrue(actualDynamicElementsHref.endsWith("dynamic-elements.html"),
                "Dynamic Elements link has an incorrect destination");
        Assert.assertTrue(actualDragDropHref.endsWith("drag-drop.html"),
                "Drag and Drop link has an incorrect destination");
    }

    @Test
    public void verifyDropdownsNavigation() {

        HomePage homePage = new HomePage(driver);

        homePage.clickDropdowns();

        Assert.assertTrue(driver.getCurrentUrl().contains("dropdowns.html"),
                "Dropdowns page was not opened");

        // Dropdown Elements
        DropDownsPage dropdownsPage = new DropDownsPage(driver);
        dropdownsPage.selectCountryByVisibleText("India");
        String actualCountryResult = dropdownsPage.getCountryResult();
        dropdownsPage.selectContinentByVisibleText("Africa");
        dropdownsPage.selectCityByVisibleText("Cairo");
        String actualChainedResult = dropdownsPage.getChainedResult();

        // Dropdown Assertions
        Assert.assertEquals(actualCountryResult, "✅ Selected: in",
                "Country selection result is incorrect");
        Assert.assertEquals(actualChainedResult, "✅ Selected: cairo",
                "City selection result is incorrect");
    }

    @Test
    public void verifyMultiSelectList() {
        HomePage homePage = new HomePage(driver);
        homePage.clickDropdowns();

        DropDownsPage dropdownsPage = new DropDownsPage(driver);
        dropdownsPage.selectSkills("Python", "Selenium", "Java");
        List<String> actualSelectedSkills = dropdownsPage.getSelectedSkills();

        Assert.assertEquals(actualSelectedSkills, Arrays.asList("Python", "Java", "Selenium"),
                "Selected skills are incorrect");
    }

    @Test
    public void verifyCheckboxesandRadioButtonsNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCheckboxesRadioButtons();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkboxes-radio.html"),
                "Checkboxes-radio page was not opened");

        CheckboxesRadioButtonsPage checkboxesRadioButtonsPage = new CheckboxesRadioButtonsPage(driver);
        // Checkbox and Radio Button Elements
        checkboxesRadioButtonsPage.selectTermsCheckbox();
        checkboxesRadioButtonsPage.selectNewsletterCheckbox();
        boolean actualCheckboxState = checkboxesRadioButtonsPage.isNotificationsCheckboxSelected();
        boolean actualDisabledCheckboxState = checkboxesRadioButtonsPage.isDisabledCheckboxEnabled();
        checkboxesRadioButtonsPage.clickSelectAllButton();
        checkboxesRadioButtonsPage.clickBeginnerRadioButton();
        checkboxesRadioButtonsPage.clickJavaRadioButton();
        checkboxesRadioButtonsPage.clickEndToEndRadioButton();

        // Checkbox and Radio Button Elements Assertions
        Assert.assertTrue(checkboxesRadioButtonsPage.isTermsCheckboxSelected(),
                "Terms checkbox should be selected");

        Assert.assertTrue(checkboxesRadioButtonsPage.isNewsletterCheckboxSelected(),
                "Newsletter checkbox should be selected");
        Assert.assertTrue(actualCheckboxState, "Notifications checkbox should be checked by default");
        Assert.assertFalse(actualDisabledCheckboxState, "Disabled checkbox should not be enabled");
        Assert.assertFalse(checkboxesRadioButtonsPage.isCheckedDisabledCheckboxEnabled(),
                "Checked + disabled checkbox should be disabled");
        Assert.assertTrue(checkboxesRadioButtonsPage.areAllToolCheckboxesSelected(),
                "All tool checkboxes should be selected");
        Assert.assertTrue(checkboxesRadioButtonsPage.getSelectedToolsResult().contains("Selected tools:"),
                "Selected tools result should be displayed");
        Assert.assertTrue(checkboxesRadioButtonsPage.isBeginnerRadioButtonSelected(),
                "Beginner radio button should be selected");
        Assert.assertEquals(checkboxesRadioButtonsPage.getExperienceResult(),
                "✅ Experience level: beginner (id=radio-beginner)",
                "Selected experience level should display Beginner");

        checkboxesRadioButtonsPage.clickJavaRadioButton();
        Assert.assertTrue(checkboxesRadioButtonsPage.isJavaRadioButtonSelected(),
                "Java radio button should be selected");
        Assert.assertTrue(checkboxesRadioButtonsPage.getRadioGroupsResult().contains("Language: java"),
                "Result should display the selected language as java"
        );

        checkboxesRadioButtonsPage.clickEndToEndRadioButton();
        Assert.assertTrue(checkboxesRadioButtonsPage.isEndToEndRadioButtonSelected(),
                "End-to-End Testing radio button should be selected");
        Assert.assertTrue(checkboxesRadioButtonsPage.getRadioGroupsResult().contains("Test type: e2e"),
                "Result should display the selected test type as e2e"
        );
    }

    @Test
    public void verifyTablesNavigation() {

        HomePage homePage = new HomePage(driver);
        homePage.clickTables();
        Assert.assertTrue(
                driver.getCurrentUrl().contains("tables.html"),
                "Tables page was not opened");
        TablesPage tablesPage = new TablesPage(driver);
        // Table Assertions
        Assert.assertTrue(tablesPage.isStaticTableDisplayed(),
                "Static table should be displayed");
        Assert.assertEquals(
                tablesPage.getStaticTableRowCount(), 5,
                "Static table should contain 5 data rows");
        Assert.assertEquals(
                tablesPage.getStaticTableColumnCount(), 6,
                "Static table should contain 6 columns");
        Assert.assertEquals(
                tablesPage.getStaticTableHeader(2), "Full Name",
                "Second column header should be Full Name");
        Assert.assertEquals(
                tablesPage.getStaticTableCellValue(2, 2),
                "Bob Martinez", "Row 2, Column 2 should contain Bob Martinez");
        Assert.assertEquals(
                tablesPage.getEmployeeName("Alice Johnson"), "Alice Johnson",
                "Employee name should be Alice Johnson");
        Assert.assertTrue(
                tablesPage.isSearchableTableDisplayed(),
                "Searchable table should be displayed");
        Assert.assertEquals(
                tablesPage.getSearchableTableRowCount(), 7,
                "Searchable table should initially contain 7 student rows");

        tablesPage.enterTableSearch("Omar Khalid");
        Assert.assertEquals(tablesPage.getSearchableTableRowCount(),
                1, "Searching for Omar Khalid should return one row");


        tablesPage.enterTableSearch("Cairo");
        Assert.assertEquals(
                tablesPage.getSearchableTableRowCount(), 2,
                "Searching for Cairo should return two student rows");

        tablesPage.enterTableSearch("Omar Khalid");
        tablesPage.clearTableSearch();
        Assert.assertEquals(
                tablesPage.getSearchableTableRowCount(), 7,
                "Clearing the search should restore all 7 student rows");

        // Verify that the score column is sorted correctly
        tablesPage.clickScoreColumn();

        List<String> scores =
                tablesPage.getScoreColumnValues();

        List<Integer> actualScores =
                new ArrayList<>();

        for (String score : scores) {
            actualScores.add(Integer.parseInt(score.trim()));
        }

        List<Integer> sortedScores =
                new ArrayList<>(actualScores);

        Collections.sort(sortedScores);

        Assert.assertEquals(actualScores, sortedScores,
                "Score column should be sorted in ascending order");
        // Verify Edit button is displayed
        Assert.assertTrue(
                tablesPage.isEditButton5Displayed(), "Edit button should be displayed");
        // Verify Edit button is enabled
        Assert.assertTrue(tablesPage.isEditButton5Enabled(), "Edit button should be enabled");
        tablesPage.clickEditButton5();
        // Verify the result message
        Assert.assertEquals(tablesPage.getTableActionResult(),
                "✅ Action \"edit\" triggered on row 5: Youssef Tarek",
                "Edit action result message should be correct");
        // Complex Table Assertions
        Assert.assertEquals(tablesPage.getComplexTableRowCount(), 3,
                "Complex table should contain 3 data rows");
        Assert.assertEquals(tablesPage.getQ2EngineeringFail(), "3",
                "Q2 Engineering Fail should be 3");
        Assert.assertEquals(tablesPage.getQ3Total(), "105",
                "Q3 Total should be 105");
        Assert.assertTrue(
                tablesPage.isEngineeringHeaderDisplayed(), "Engineering header should be displayed");
        Assert.assertTrue(tablesPage.isQaHeaderDisplayed(), "QA header should be displayed");
    }

    @Test
    public void verifyAlertsPageNavigation() {

        HomePage homePage = new HomePage(driver);

        homePage.clickAlerts();
        Assert.assertTrue(driver.getCurrentUrl().contains("alerts.html"),
                "Alerts page was not opened");
        AlertsPage alertsPage = new AlertsPage(driver);
        // JavaScript Alert Assertions
        alertsPage.clickTriggerAlertButton();

        String actualAlertText = alertsPage.getAlertText();

        System.out.println("Alert message: " + actualAlertText);

        Assert.assertFalse(
                actualAlertText.isEmpty(),
                "JavaScript alert message should not be empty"
        );

        alertsPage.acceptAlert();

        // JavaScript confirm dialog
        alertsPage.clickTriggerConfirmButton();
        String actualConfirmText = alertsPage.getConfirmDialogText();
        System.out.println("Confirm dialog message: " + actualConfirmText);
        Assert.assertFalse(
                actualConfirmText.isEmpty(),
                "Confirm dialog message should not be empty"
        );
        alertsPage.acceptConfirmDialog();

        alertsPage.clickTriggerConfirmButton();
        String actualDismissText = alertsPage.getConfirmDialogText();
        System.out.println("Dismissed confirm dialog message: " + actualDismissText);
        Assert.assertFalse(
                actualDismissText.isEmpty(),
                "Dismissed confirm dialog message should not be empty"
        );
        alertsPage.dismissConfirmDialog();

        // JavaScript Prompt Assertions
        alertsPage.clickTriggerPromptButton();

        String actualPromptText = alertsPage.getPromptDialogText();
        System.out.println("Prompt message: " + actualPromptText);

        Assert.assertEquals(actualPromptText,"Please enter your name:",
                "Prompt message did not match");
        alertsPage.enterPromptText("Namritha QA");
        alertsPage.acceptPromptDialog();
        String actualResult = alertsPage.getPromptResult();
        Assert.assertEquals(actualResult, "✅ You entered: \"Namritha QA\"",
                "Prompt result did not match the entered name");
        // Inline Notification Assertions
        alertsPage.clickShowInfo();

        Assert.assertTrue(alertsPage.isInfoNotificationVisible(),
                "Info notification should be displayed");

        Assert.assertFalse(alertsPage.getInfoNotificationText().trim().isEmpty(),
                "Info notification should contain text");
        // Click Hide All
        alertsPage.clickHideAll();

        // Verify all notifications are hidden
        Assert.assertFalse(
                alertsPage.isSuccessNotificationVisible(),
                "Success notification should be hidden");

        Assert.assertFalse(
                alertsPage.isErrorNotificationVisible(),
                "Error notification should be hidden");

        Assert.assertFalse(
                alertsPage.isInfoNotificationVisible(),
                "Info notification should be hidden");
        alertsPage.clickOpenModal();

        Assert.assertTrue(alertsPage.isInfoModalVisible(),
                "Custom modal should be displayed");
        String testInput = "Selenium QA";

        // Enter text in the modal input
        alertsPage.enterModalInput(testInput);

        // Confirm the modal
        alertsPage.clickModalConfirm();

        // Verify the result
        Assert.assertTrue(alertsPage.isModalResultVisible(),
                "Modal result should be displayed");

        Assert.assertTrue(alertsPage.getModalResultText().contains(testInput),
                "Modal result should contain the entered text");

        alertsPage.clickOpenModal();
        alertsPage.enterModalInput("Test cancellation");
        alertsPage.clickModalCancel();

        Assert.assertFalse(alertsPage.isInfoModalVisible(),
                "Modal should close after clicking Cancel");

        Assert.assertTrue(
                alertsPage.getModalResultText().contains("✅ Modal cancelled."),
                "Cancellation message should be displayed");
        alertsPage.clickOpenDangerModal();

        Assert.assertTrue(alertsPage.isDangerModalVisible(),
                "Confirm Delete modal should be visible");
        alertsPage.clickDangerModalCancel();

        Assert.assertFalse(alertsPage.isDangerModalVisible(),
                "Confirm Delete modal should close after clicking Cancel");

        Assert.assertTrue(alertsPage.getModalResultText().contains("Deletion cancelled."),
                "Deletion cancelled message should be displayed");
        alertsPage.clickOpenDangerModal();
        alertsPage.clickDangerModalConfirm();

        Assert.assertFalse(alertsPage.isDangerModalVisible(),
                "Confirm Delete modal should close after clicking Delete");

        Assert.assertTrue(alertsPage.getModalResultText().contains("Record deleted!"),
                "Record deleted message should be displayed");
    }

    @Test
    public void verifyDynamicPageNavigation() {

        HomePage homePage = new HomePage(driver);

        homePage.clickDynamicLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("dynamic-elements.html"),
                "Dynamic page was not opened");
        DynamicElementsPage dynamicElementsPage = new DynamicElementsPage(driver);
        Assert.assertTrue(dynamicElementsPage.getPageHeadingText().contains("Dynamic Elements"),
                "Dynamic page heading was not displayed");


        // Dynamic Elements - Show/Hide
        // Click Show Element button
        dynamicElementsPage.clickShowElement();
        Assert.assertTrue(dynamicElementsPage.waitForDynamicBoxVisible(),
                "Dynamic box should be visible after clicking Show Element");

        // Click Hide Element button
        dynamicElementsPage.clickHideElement();
        Assert.assertFalse(dynamicElementsPage.isDynamicBoxVisible(),
                "Dynamic box should be hidden after clicking Hide Element");
        // Click Toggle Element button - first click should show the box
        dynamicElementsPage.clickToggleElement();
        Assert.assertTrue(
                dynamicElementsPage.waitForDynamicBoxVisible(),
                "Dynamic box should be visible after clicking Toggle Element"
        );
        // Click Toggle Element button again - second click should hide the box
        dynamicElementsPage.clickToggleElement();
        Assert.assertFalse(
                dynamicElementsPage.isDynamicBoxVisible(),
                "Dynamic box should be hidden after the second toggle"
        );
        // Delayed Element Appearance
        dynamicElementsPage.clickLoadDelayedElement();

        Assert.assertTrue(dynamicElementsPage.isDelayedElementVisible(),
                "Delayed element should become visible after clicking the button");
        // Progress Bar Completion
        dynamicElementsPage.clickStartProgress();

        Assert.assertTrue(
                dynamicElementsPage.isProgressComplete(),
                "Progress completion message should appear when the bar reaches 100%");

        // Counter Increment and Decrement
        // Counter Increment
        int initialValue = dynamicElementsPage.getCounterValue();

        dynamicElementsPage.clickIncrement();

        Assert.assertEquals(
                dynamicElementsPage.getCounterValue(), initialValue + 1,
                "Counter should increase by 1 after clicking Increment");

        // Counter Decrement
        int valueBeforeDecrement = dynamicElementsPage.getCounterValue();

        dynamicElementsPage.clickDecrement();

        Assert.assertEquals(
                dynamicElementsPage.getCounterValue(), valueBeforeDecrement - 1,
                "Counter should decrease by 1 after clicking Decrement");

        // Counter Reset
        dynamicElementsPage.clickIncrement();
        dynamicElementsPage.clickIncrement();
        dynamicElementsPage.clickResetCounter();

        Assert.assertEquals(dynamicElementsPage.getCounterValue(), 0,
                "Counter should return to 0 after clicking Reset");
        // Skeleton Loader
        dynamicElementsPage.clickSimulatePageLoad();

        Assert.assertTrue(
                dynamicElementsPage.isLoadedTitleVisible(),
                "Loaded course title should become visible");

        Assert.assertTrue(
                dynamicElementsPage.getLoadedTitleText().contains("Course Loaded"),
                "Loaded course title should contain the expected text");

        Assert.assertTrue(
                dynamicElementsPage.getLoadedDescriptionText().contains("42 lessons"),
                "Loaded course description should contain the expected lesson count");

        Assert.assertTrue(
                dynamicElementsPage.getEnrolledCountText().contains("1,247 students enrolled"),
                "Enrolled student count should be displayed correctly");
        // Dynamic Changing Text
        String initialText = dynamicElementsPage.getDynamicText();

        dynamicElementsPage.clickGenerateRandomStatus();

        String updatedText = dynamicElementsPage.getDynamicText();

        Assert.assertNotEquals(updatedText, initialText,
                "Dynamic text should change after clicking Generate Random Status");

        Assert.assertFalse(
                updatedText.isEmpty(), "Updated status text should not be empty");
        dynamicElementsPage.clickShowToastNotification();

        Assert.assertTrue(
                dynamicElementsPage.isToastVisible(),
                "Toast notification should become visible after clicking the button");

        Assert.assertTrue(
                dynamicElementsPage.getToastMessageText().contains("Action completed successfully!"),
                "Toast should display the expected success message");
    }

    @Test
    public void verifyIframesPageNavigation() {

        HomePage homePage = new HomePage(driver);
        homePage.clickIframesLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("iframe.html"),
                "iFrame page was not opened");

        IframesPage iframesPage = new IframesPage(driver);
        Assert.assertTrue(iframesPage.getPageHeadingText().contains("iFrame Practice"),
                "iFrame page heading was not displayed");

        iframesPage.switchToPracticeIframe();
        iframesPage.enterUsername("qa_student");
        iframesPage.enterPassword("Test@123");
        iframesPage.enterEmail("qa.student@example.com");
        iframesPage.clickSubmit();
        Assert.assertTrue(iframesPage.getIframeResultText().contains("qa_student"),
                "Submitted iFrame result should display the username");

        iframesPage.switchToMainPage();
        Assert.assertTrue(
                driver.getPageSource().contains("Elements Outside the Frame"),
                "Selenium should return to the main page after interacting with the iFrame");

        // Switch Between iFrames Using Index
        // Switch to first iFrame (index 0)
        iframesPage.switchToIframeByIndex(0);

        iframesPage.enterUsername("first_frame_user");
        iframesPage.enterPassword("First@123");

        // Return to main page
        iframesPage.switchToMainPage();

        // Switch to second iFrame (index 1)
        iframesPage.switchToIframeByIndex(1);

        iframesPage.enterUsername("second_frame_user");
        iframesPage.enterPassword("Second@123");

        // Return to main page
        iframesPage.switchToMainPage();

        Assert.assertTrue(
                driver.getPageSource().contains("Elements Outside the Frame"),
                "Selenium should return to the main page after interacting with both iFrames");
        // Switch to first iFrame using its WebElement
        iframesPage.switchToFirstIframe();
        iframesPage.enterUsername("frame_one_user");

        // Return to main page
        iframesPage.switchToMainPage();

        // Switch to second iFrame using its WebElement
        iframesPage.switchToSecondIframe();
        iframesPage.enterUsername("frame_two_user");

        // Return to main page
        iframesPage.switchToMainPage();

        Assert.assertTrue(
                driver.getPageSource().contains("Elements Outside the Frame"),
                "Selenium should return to the main page after switching between iFrames"
        );
        // Elements Outside the iFrame
        // Switch into first iFrame
        iframesPage.switchToFirstIframe();

        iframesPage.enterUsername("frame_user");

        // Switch back to main page
        iframesPage.switchToMainPage();

        // Interact with elements outside the iFrame
        String inputText = "Testing outside iframe";

        iframesPage.enterOutsideInput(inputText);

        Assert.assertEquals(iframesPage.getOutsideInputValue(), inputText,
                "Outside input should contain the entered text");

        iframesPage.clickOutsideButton();

        Assert.assertEquals(
                iframesPage.getOutsideResultText(),
                "✅ Outside button clicked! (after switch_to.default_content)",
                "Outside button result message should be displayed correctly");

    }
    @Test
    public void verifyFileUploadPageNavigation() {

        HomePage homePage = new HomePage(driver);
        homePage.clickFileUploadLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("upload.html"),
                "File Upload page was not opened");

        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        Assert.assertTrue(fileUploadPage.getPageHeadingText().contains("File Upload"),
                "File Upload page heading was not displayed");
        // Simple File Upload
        // Get absolute file path
        String filePath = new File(
                "src/test/resources/test-data/sample-upload.txt"
        ).getAbsolutePath();

        // Upload file
        fileUploadPage.uploadSimpleFile(filePath);

        // Verify upload result
        Assert.assertTrue(
                fileUploadPage.getSimpleFileResult().contains("sample-upload.txt"),
                "Uploaded file name should be displayed in the result"
        );
        // Multiple File Upload

        String file1 = new File(
                "src/test/resources/test-data/sample-upload1.txt"
        ).getAbsolutePath();

        String file2 = new File(
                "src/test/resources/test-data/sample-upload2.txt"
        ).getAbsolutePath();

        fileUploadPage.uploadMultipleFiles(file1 + "\n" + file2);

        String uploadedFiles = fileUploadPage.getMultipleFileNames();

        Assert.assertTrue(uploadedFiles.contains("sample-upload1.txt"),
                "First file was not selected");

        Assert.assertTrue(uploadedFiles.contains("sample-upload2.txt"),
                "Second file was not selected");
        // Filtered File Upload
        File imageFile = new File(
                "src/test/resources/test-data/sample-image.png"
        );

        Assert.assertTrue(imageFile.exists(),
                "Test image file does not exist");

        fileUploadPage.uploadImageFile(imageFile.getAbsolutePath());

        Assert.assertEquals(
                fileUploadPage.getSelectedImageFileName(),
                "sample-image.png",
                "Image filename does not match"
        );

        Assert.assertFalse(
                fileUploadPage.getImageFileResult().contains("No image chosen yet"),
                "Image preview was not updated"
        );
        // Drag & Drop File Upload
        File testFile = new File(
                "src/test/resources/test-data/sample-upload.txt"
        );

        Assert.assertTrue(testFile.exists(),
                "Test file does not exist");

        fileUploadPage.uploadFileUsingDropZone(testFile.getAbsolutePath());

        Assert.assertEquals(
                fileUploadPage.getDropZoneUploadedFileName(),
                "sample-upload.txt",
                "Uploaded filename does not match"
        );
        // Upload file as part of a form submission
        // Enter uploader name
        fileUploadPage.enterUploaderName("Namritha");

        // Select assignment file
        File assignmentFile = new File(
                "src/test/resources/test-data/sample-upload.txt"
        );

        Assert.assertTrue(assignmentFile.exists(),
                "Assignment test file does not exist");

        fileUploadPage.uploadAssignmentFile(assignmentFile.getAbsolutePath());

        // Enter file description
        fileUploadPage.enterFileDescription("Selenium Automation Assignment");

        // Submit form
        fileUploadPage.clickSubmitAssignment();

        // Verify submission result
        String result = fileUploadPage.getUploadFormResult();

        Assert.assertFalse(result.isEmpty(),
                "Submission result should not be empty");

        Assert.assertNotEquals(result, "Fill the form and submit.",
                "Form submission was not processed");

    }
    @Test
    public void verifyUploadFormReset() {

        HomePage homePage = new HomePage(driver);
        homePage.clickFileUploadLink();

        FileUploadPage fileUploadPage = new FileUploadPage(driver);

        // Enter form details
        fileUploadPage.enterUploaderName("Namritha");

        File assignmentFile = new File(
                "src/test/resources/test-data/sample-upload.txt"
        );

        Assert.assertTrue(assignmentFile.exists(),
                "Assignment test file does not exist");

        fileUploadPage.uploadAssignmentFile(assignmentFile.getAbsolutePath());

        fileUploadPage.enterFileDescription("Selenium Automation Assignment");

        // Click Reset
        fileUploadPage.clickResetUploadForm();

        // Verify all form fields are cleared
        Assert.assertEquals(fileUploadPage.getUploaderNameValue(), "",
                "Uploader name was not cleared");

        Assert.assertEquals(fileUploadPage.getAssignmentFileCount(), 0,
                "Selected file was not cleared");

        Assert.assertEquals(fileUploadPage.getFileDescriptionValue(), "",
                "File description was not cleared");

        Assert.assertEquals(fileUploadPage.getUploadFormResult(),
                "Fill the form and submit.",
                "Form result was not reset to its initial message");
    }
    @Test
    public void verifyDragDropPageNavigation() {

        HomePage homePage = new HomePage(driver);
        homePage.clickDragDropLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("drag-drop.html"),
                "Drag & Drop page was not opened");

        DragDropPage dragDropPage = new DragDropPage(driver);
        Assert.assertTrue(dragDropPage.getPageHeadingText().contains("Drag & Drop"),
                "Drag & Drop page heading was not displayed");
        // Simple Drag and Drop Assertions
        // Drag Item 1
        dragDropPage.dragItem1ToDropZone();

        // Verify result after first drag
        Assert.assertTrue(
                dragDropPage.getSimpleDndResult().contains("Item 1"),
                "Item 1 was not dropped successfully"
        );

        // Drag Item 2
        dragDropPage.dragItem2ToDropZone();

        // Verify result after second drag
        Assert.assertTrue(
                dragDropPage.getSimpleDndResult().contains("Item 2"),
                "Item 2 was not dropped successfully"
        );

        // Drag Item 3
        dragDropPage.dragItem3ToDropZone();

        // Verify result after third drag
        Assert.assertTrue(
                dragDropPage.getSimpleDndResult().contains("Item 3"),
                "Item 3 was not dropped successfully"
        );

        // Reset Drag & Drop
        dragDropPage.clickResetSimpleDnd();

        Assert.assertEquals(
                dragDropPage.getSimpleDndResult(),
                "Drag items into the drop zone.",
                "Simple Drag & Drop result was not reset correctly"
        );
        // Verify initial task counts
        Assert.assertEquals(dragDropPage.getTodoCount(), "3",
                "Initial To Do count should be 3");

        Assert.assertEquals(dragDropPage.getInProgressCount(), "1",
                "Initial In Progress count should be 1");

        Assert.assertEquals(dragDropPage.getDoneCount(), "1",
                "Initial Done count should be 1");

        // Move Card 1: To Do -> In Progress
        dragDropPage.moveCard1ToInProgress();

        Assert.assertTrue(dragDropPage.getKanbanResult().contains("Write test cases"),
                "Card 1 should be moved successfully");

        Assert.assertEquals(dragDropPage.getTodoCount(), "2",
                "To Do count should decrease to 2");

        Assert.assertEquals(dragDropPage.getInProgressCount(), "2",
                "In Progress count should increase to 2");

        // Move Card 2: To Do -> Done
        dragDropPage.moveCard2ToDone();

        Assert.assertTrue(dragDropPage.getKanbanResult().contains("Set up test environment"),
                "Card 2 should be moved successfully");

        Assert.assertEquals(dragDropPage.getTodoCount(), "1",
                "To Do count should decrease to 1");

        Assert.assertEquals(dragDropPage.getDoneCount(), "2",
                "Done count should increase to 2");
        // Automation category
        dragDropPage.dragSeleniumToAutomation();
        Assert.assertTrue(dragDropPage.getBucketResult().contains("Selenium"),
                "Selenium was not sorted into Automation");
        Assert.assertTrue(dragDropPage.isChipInBucket("chip-selenium", "bucket-automation"),
                "Selenium is not inside Automation");

        dragDropPage.dragPytestToAutomation();
        Assert.assertTrue(dragDropPage.getBucketResult().contains("PyTest"),
                "PyTest was not sorted into Automation");
        Assert.assertTrue(dragDropPage.isChipInBucket("chip-pytest", "bucket-automation"),
                "PyTest is not inside Automation");


        dragDropPage.dragPlaywrightToAutomation();
        Assert.assertTrue(dragDropPage.getBucketResult().contains("Playwright"),
                "Playwright was not sorted into Automation");

        Assert.assertTrue(dragDropPage.isChipInBucket("chip-playwright", "bucket-automation"),
                "Playwright is not inside Automation");

        // Frontend category
        dragDropPage.dragReactToFrontend();
        Assert.assertTrue(dragDropPage.getBucketResult().contains("React"),
                "React was not sorted into Frontend");
        Assert.assertTrue(dragDropPage.isChipInBucket("chip-react", "bucket-frontend"),
                "React is not inside Frontend");

        dragDropPage.dragVueToFrontend();
        Assert.assertTrue(dragDropPage.getBucketResult().contains("Vue.js"),
                "Vue.js was not sorted into Frontend");
        Assert.assertTrue(dragDropPage.isChipInBucket("chip-vue", "bucket-frontend"),
                "Vue.js is not inside Frontend");

        dragDropPage.dragNextjsToFrontend();
        Assert.assertTrue(dragDropPage.getBucketResult().contains("Next.js"),
                "Next.js was not sorted into Frontend");
        Assert.assertTrue(dragDropPage.isChipInBucket("chip-nextjs", "bucket-frontend"),
                "Next.js is not inside Frontend");

        // Backend category
        dragDropPage.dragDjangoToBackend();
        System.out.println("Django result: " + dragDropPage.getBucketResult());
        Assert.assertTrue(dragDropPage.getBucketResult().contains("Django"),
                "Django was not sorted into Backend");

        dragDropPage.dragFastApiToBackend();
        Assert.assertTrue(dragDropPage.getBucketResult().contains("FastAPI"),
                "FastAPI was not sorted into Backend");
        Assert.assertTrue(dragDropPage.isChipInBucket("chip-fastapi", "bucket-backend"),
                "FastAPI is not inside Backend");

    }
}
