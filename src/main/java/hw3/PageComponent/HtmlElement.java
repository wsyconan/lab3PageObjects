package hw3.PageComponent;

import org.openqa.selenium.WebDriver;

public interface HtmlElement {
    void initElement(WebDriver webDriver);
    String getText();
    boolean isDisplayed(String str) throws Exception;
}
