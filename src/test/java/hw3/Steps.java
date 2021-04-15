package hw3;

import hw3.PageComponent.Page2;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

import static org.testng.Assert.*;

public class Steps {
    WebDriver webDriver;
    Properties properties;
    SoftAssert softAssert;
    Page page;
    Page2 page2;
    String mainHeader;
    String[] mainText;
    Pattern patternWater, patternWind, patternSelen, patternYellow, patternWaterFalse, patternWindFalse;


    @Before
    public void initTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        softAssert = new SoftAssert();
        properties = new Properties();
        properties.load(new FileInputStream("Data.properties"));
        page = new Page(webDriver);
        mainHeader = "EPAM FRAMEWORK WISHES…";
        mainText = new String[]{"To include good practices\n" + "and ideas from successful\n" + "EPAM project",
                "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 20 internal and\n" +
                        "some external projects),\n" + "wish to get more…"

        };
        patternWater = Pattern.compile("[0-9]+:[0-9]+:[0-9]+ Water: condition changed to true");
        patternWind = Pattern.compile("[0-9]+:[0-9]+:[0-9]+ Wind: condition changed to true");
        patternSelen = Pattern.compile("[0-9]+:[0-9]+:[0-9]+ metal: value changed to Selen");
        patternYellow = Pattern.compile("[0-9]+:[0-9]+:[0-9]+ Colors: value changed to Yellow");
        patternWaterFalse = Pattern.compile("[0-9]+:[0-9]+:[0-9]+ Water: condition changed to false");
        patternWindFalse = Pattern.compile("[0-9]+:[0-9]+:[0-9]+ Wind: condition changed to false");
    }

    @After
    public void afterTest() {
        webDriver.quit();
    }

    // Step 1: Open test site by URL
    @Given("I open the page")
    public void openPage() {
        webDriver.get(properties.getProperty("ex1.url"));
        page.assertBrowserTitle(webDriver, properties.getProperty("ex1.pageTitle"));
        webDriver.manage().window().maximize();
    }

    // Step 3: Perform login
    @And("I log as {string} - {string}")
    public void login(String username, String password) {
        page.login(username, password);
    }

    // Step 4: Assert User name in the left-top side of screen that user is loggined
    @Then("Username is {string}")
    public void assertUsername(String str) {
        page.assertText(page.user_name, str);
    }

    // Step 2, 5: Assert Browser title
    @Then("Browser title is {string}")
    public void assertBrowserTitle(String title) {
        Assert.assertEquals(webDriver.getTitle(), title);
    }

    // Step 6: Assert that there are 4 items on the header section.
    @Then("4 items of header section have proper texts")
    public void HeaderSectionContext() {
        page.assertTextOfElements(page.headerSection,
                properties.getProperty("ex1.heads").split(",  "));
    }

    // Step 7: Assert that there are 4 images
    @Then("Images are displayed")
    public void assertImages() {
        page.assertSizeOfElements(page.images, 4);
        page.assertElementsAreDisplayed(page.images);
    }

    // Step 8: Assert that there are 4 texts below images
    @Then("Texts blow images are displayed")
    public void assertTextsBelowImages() {
        page.assertSizeOfElements(page.textUnderImages, 4);
    }

    @And("They have proper text")
    public void assetContentOfTexts() {
        page.assertTextOfElements(page.textUnderImages, mainText);
    }

    // Step 9: Assert a text of the main headers
    @Then("First paragraph of main header has proper text")
    public void assertMainHeader1() {
        page.assertText(page.mainHeader, mainHeader);
    }

    @Then("Second paragraph of main header has proper text")
    public void assertMainHeader2() {
        page.assertText(page.mainText, properties.getProperty("ex1.mainText"));
    }

    // Step 10: Assert that there is the iframe in the center of page
    @Then("The iframe exists")
    public void assertIframe() {
        page.assertElementIsDisplayed(page.second_frame);
    }

    // Step 11: Switch to the iframe and check EPAM logo
    @When("Switch to the iframe")
    public void sweitchToFrame() {
        page.switchToFrame(webDriver, properties.getProperty("ex1.secondframe"));
    }

    @Then("Check EPAM logo")
    public void checkLogo() {
        page.assertElementIsDisplayed(page.frameLogo);
    }

    // Step 12: Switch to original window back
    @And("Switch to home page")
    public void backToHomePage() {
        page.switchToDefFrame(webDriver);
    }

    // Step 13: Assert a text of the sub header
    @Then("Text has proper value")
    public void assertSubHeader() {
        page.assertText(page.subHeader, properties.getProperty("ex1.subHeader"));
    }

    // Step 14: Assert that JDI GITHUB is a link and has a proper URL
    @Then("JDI GITHUB is a Link")
    public void assertJDI() {
        page.assertLink(page.jdiLink);
    }

    @And("It has proper value")
    public void assertJDILink() {
        page.assertHref(page.jdiLink, properties.getProperty("ex1.jdiUrl"));
    }

    // Step 15: Assert that there is Left Section
    @Then("Left Section exists")
    public void checkLeftSection() {
        page.assertElementIsDisplayed(page.leftSection);
    }

    // Step 16: Assert that there is Footer
    @Then("Footer exists")
    public void checkFooter() {
        page.assertElementIsDisplayed(page.footer);
    }

    // Step 17: Close Browser
    @Then("Close browser")
    public void closeBrowser() {
        page.closeBrowser(webDriver);
    }

    // Now begin Step defines of ex2
    // Step 5: Click on "Service" subcategory in the header and check that drop down contains options
    @Then("Drop down options of top Service have proper values")
    public void checkTopService() throws InterruptedException {
        page.topService.click();
        String[] topServiceText = properties.getProperty("ex2.serviceOptionsTop").split(",  ");
        page.assertTextOfElements(page.topServiceContents, topServiceText);
    }

    // Step 6: Click on Service subcategory in the left section and check that drop down contains options
    @Then("Drop down options of left Service have proper values")
    public void checkLeftService() throws InterruptedException {
        page.leftService.click();
        String[] topService = properties.getProperty("ex2.serviceOptionsSide").split(",  ");
        page.assertTextOfElements(page.leftServiceContents, topService);
    }

    // Step 7: Open through the header menu Service -> Different Elements Page
    @Given("Open \"Different Elements\" Page")
    public void openDiffElePage() {
        page.leftSection.click();
        page.diffElePage.click();
        page2 = new Page2(webDriver);
    }

    // Step 8: Check interface on Different elements page, it contains all needed elements
    @Then("There are 4 checkboxes")
    public void assertCheckboxes() {
        Assert.assertEquals(page2.getCheckboxNum(), 4);
    }

    @Then("There are 4 radios")
    public void assertRadios() {
        Assert.assertEquals(page2.getRadioNum(), 4);
    }

    @Then("There are 1 dropdown")
    public void assertDropdown() {
        Assert.assertEquals(page2.getdropdownNum(), 1);
    }

    @Then("There are 2 buttons")
    public void assertButtons() {
        Assert.assertEquals(page2.getbuttonNum(), 2);
    }

    // Step 9: Assert that there is Right Section
    @Then("Right Section displayed")
    public void assertRightSection() {
        softAssert.assertTrue(page2.rightSection.isDisplayed());
        softAssert.assertAll();
    }

    // Step 10: Assert that there is Left Section
    @And("Left Section displayed")
    public void assertLeftSection() {
        softAssert.assertTrue(page2.rightSection.isDisplayed());
        softAssert.assertAll();
    }

    // Step 11: Select checkboxes
    @Then("Checkboxes {string} and {string} are selected")
    public void selectCheckbox(String str1, String str2) throws InterruptedException {
        page2.clickCheckbox(str1);
        page2.clickCheckbox(str2);
    }

    // Step 12: Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    @And("Status of checkboxes in Log row are displayed and corresponding")
    public void assertCheckboxLog() throws InterruptedException {
        page2.checkInfoPanel(patternWater, 1);
        page2.checkInfoPanel(patternWind, 0);
    }

    // Step 13: Select radio
    @Then("Radio {string} is selected")
    public void selectRadio(String str) {
        page2.clickRadio(str);
    }

    // Step 14: Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
    @And("Status of radios in Log row is displayed and corresponding")
    public void assertRadioLog() throws InterruptedException {
        page2.checkInfoPanel(patternSelen, 0);
    }

    // Step 15: Select in dropdown
    @Then("{string} in dropdown is selected")
    public void selectDropdown(String str) {
        page2.clickDropdown(str);
    }

    // Step 16: Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @And("Status of dropdown in Log row is displayed and corresponding")
    public void assertDropdownLog() {
        page2.checkInfoPanel(patternYellow, 0);
    }

    // Step 17: Unselect and assert checkboxes
    @Then("Checkboxes {string} and {string} are unselected")
    public void unselectCheckbox(String str1, String str2) {
        page2.clickCheckbox(str1);
        page2.clickCheckbox(str2);
    }

    // Step 18: Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
    @And("Status of checkboxes are displayed and corresponding")
    public void assertCheckboxLog2() throws InterruptedException {
        page2.checkInfoPanel(patternWaterFalse, 1);
        page2.checkInfoPanel(patternWindFalse, 0);
    }


}