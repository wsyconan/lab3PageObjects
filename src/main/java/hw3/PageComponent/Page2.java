package hw3.PageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.regex.Pattern;

public class Page2 {
    SoftAssert softAssert;
    Checkbox checkboxes;
    Radio radios;
    Dropdown dropdowns;
    InfoPanel infoPanel;
    Button buttons;
    @FindBy(css = "#mCSB_2")
    public WebElement rightSection;
    @FindBy(css = "#mCSB_1")
    WebElement leftSection;


    public Page2(WebDriver webDriver) {
        softAssert = new SoftAssert();
        checkboxes = new Checkbox();
        radios = new Radio();
        dropdowns = new Dropdown();
        infoPanel = new InfoPanel();
        PageFactory.initElements(webDriver, this);
        buttons = new Button();
        HtmlElement[] elements={checkboxes, radios, dropdowns, infoPanel, buttons};
        for (HtmlElement element : elements) {
            element.initElement(webDriver);
        }
    }

    public int getCheckboxNum(){
        return checkboxes.getSize();
    }

    public int getRadioNum(){
        return radios.getSize();
    }

    public int getdropdownNum(){
        return dropdowns.getSize();
    }

    public int getbuttonNum(){
        return buttons.getSize();
    }

    public void clickCheckbox(String str){
        checkboxes.select(str);
    }

    public void checkInfoPanel(Pattern str, int recordNum){
        softAssert.assertTrue(str.matcher(infoPanel.getRecord(recordNum)).matches());
        softAssert.assertAll();
    }

    public void clickRadio(String str){
        radios.select(str);
    }

    public void clickDropdown(String str){
        dropdowns.select(str);
    }

}
