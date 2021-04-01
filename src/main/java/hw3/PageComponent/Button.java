package hw3.PageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Button implements InteractiveElement, HtmlElement {
    @FindBy(css = "div.main-content-hg .uui-button")
    List<WebElement> buttons;

    @Override
    public void select(String name) {
        for (WebElement button : buttons) {
            if (button.getText().equals(name)) {
                button.click();
            }
        }
    }

    @Override
    public boolean isSelected(String name) throws Exception {
        for (WebElement button : buttons) {
            if (button.getText().equals(name)) {
                return button.isSelected();
            }
        }
        throw new Exception("There is no such a button.");
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
    public boolean isDisplayed(String name) {
        return true;
    }

    public int getSize() {
        return buttons.size();
    }
}
