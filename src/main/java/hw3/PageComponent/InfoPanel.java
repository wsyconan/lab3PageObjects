package hw3.PageComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.security.PublicKey;
import java.util.List;

public class InfoPanel implements HtmlElement{

    @FindBy(css = "ul.panel-body-list.logs li")
    List<WebElement> infoPanel;

    @Override
    public void initElement(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public String getRecord(int number){
        Assert.assertFalse(infoPanel.isEmpty());
        return infoPanel.get(number).getText();
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
