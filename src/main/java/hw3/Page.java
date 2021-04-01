package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Page {

    @FindBy(css = "li.dropdown.uui-profile-menu")
    WebElement loginIcon;
    @FindBy(css = "#name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(css = "#user-name")
    WebElement user_name;
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 a")
    List<WebElement> headerSection;
    @FindBy(css = ".benefit-icon")
    List<WebElement> images;
    @FindBy(css = ".benefit-icon+.benefit-txt")
    List<WebElement> textUnderImages;
    @FindBy(css = "h3.main-title.text-center")
    WebElement mainHeader;
    @FindBy(css = "p.main-txt.text-center")
    WebElement mainText;
    @FindBy(css = "#second_frame")
    WebElement second_frame;
    @FindBy(css = "img#epam-logo")
    WebElement frameLogo;
    @FindBy(css = "h3.text-center>a")
    WebElement subHeader;
    @FindBy(css = "h3.text-center>a[target=_blank]")
    WebElement jdiLink;
    @FindBy(css = "ul.sidebar-menu")
    WebElement leftSection;
    @FindBy(css = "footer")
    WebElement footer;
    @FindBy(className = "dropdown")
    WebElement topService;
    @FindBy(css = "ul.dropdown-menu>li>a")
    List<WebElement> topServiceContents;
    @FindBy(css = "li.menu-title[index='3']")
    WebElement leftService;
    @FindBy(css = "li.menu-title[index='3'] li[index]>a")
    List<WebElement> leftServiceContents;
    @FindBy(css = "ul.sub>li[index='8']")
    WebElement diffElePage;


    public Page(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void login(String username, String password){
        this.loginIcon.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    // Assert text of one WebElement
    public void assertText(WebElement we, String str){
        Assert.assertEquals(we.getText(), str);
    }

    // Assert texts of series of WebElements
    public void assertTextOfElements(List<WebElement> list, String[] strArray) {
        int i = 0;
        for (WebElement webElement : list) {
            if (webElement.isEnabled() && webElement.isDisplayed()) {
                Assert.assertEquals(webElement.getText(), strArray[i++]);
            }
        }
    }

    // Assert size of Elements
    public void assertSizeOfElements(List<WebElement> list, int number){
        Assert.assertEquals(list.size(), number);
    }

    // Assert WebElements are existed
    public void assertElementsAreExisted(List<WebElement> list){
        for (WebElement webElement : list) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    public void assertElementIsDisplayed(WebElement webElement){
        Assert.assertTrue(webElement.isDisplayed());
    }

    // Assert WebElements are displayed
    public void assertElementsAreDisplayed(List<WebElement> list){
        for (WebElement webElement : list) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    // Switch to another frame
    public void switchToFrame(WebDriver webDriver, String str){
        webDriver.switchTo().frame(str);
    }

    // Switch to homepage
    public void switchToDefFrame(WebDriver webDriver){
        webDriver.switchTo().defaultContent();
    }

    public void assertHref(WebElement webElement, String link){
        Assert.assertEquals(webElement.getAttribute("href"), link);
    }

    public void assertLink(WebElement webElement){
        Assert.assertEquals(webElement.getAttribute("ui"), "link");
    }

    public void assertBrowserTitle(WebDriver webDriver, String str){
        Assert.assertEquals(webDriver.getTitle(), str);
    }

    public void closeBrowser(WebDriver webDriver){
        webDriver.close();
    }

}
