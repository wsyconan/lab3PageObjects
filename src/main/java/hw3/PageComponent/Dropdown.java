package hw3.PageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dropdown implements InteractiveElement, HtmlElement {
    @FindBy(css = "select.uui-form-element")
    List<WebElement> dropdowns;
    @FindBy(css = "select.uui-form-element>option")
    List<WebElement> sections;

    @Override
    public void initElement(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public boolean isDisplayed(String str) {
        return dropdowns.get(0).isDisplayed();
    }

    @Override
    public void select(String name) {
        dropdowns.get(0).click();
        for (WebElement section : sections) {
            if (section.getText().equals(name)) {
                section.click();
            }
        }
    }

    @Override
    public boolean isSelected(String name) {
        return false;
    }

    public int getSize() {
        return dropdowns.size();
    }
}
