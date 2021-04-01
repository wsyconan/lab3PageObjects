package hw3.PageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Radio implements InteractiveElement, HtmlElement {
    @FindBy(css = "label.label-radio")
    List<WebElement> radios;

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
        return false;
    }

    @Override
    public void select(String name) {
        for (WebElement checkbox : radios) {
            if (checkbox.getText().equals(name)) {
                checkbox.click();
            }
        }
    }

    @Override
    public boolean isSelected(String name) {
        for (WebElement checkbox : radios) {
            if (checkbox.getText().equals(name) && checkbox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return radios.size();
    }
}
