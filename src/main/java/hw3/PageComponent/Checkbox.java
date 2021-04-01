package hw3.PageComponent;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Checkbox implements InteractiveElement, HtmlElement {
    @FindBy(css = "label.label-checkbox")
    List<WebElement> checkboxes;

    @Override
    public void select(String name) {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().equals(name)) {
                checkbox.click();
            }
        }
    }

    @Override
    public boolean isSelected(String name) {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().equals(name) && checkbox.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return checkboxes.size();
    }

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

}
