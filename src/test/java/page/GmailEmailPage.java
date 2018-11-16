package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailEmailPage extends BasePage {

    @FindBy(css = "input[placeholder]")
    private WebElement searchField;

    public GmailEmailPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(searchField, 10);
    }

    public boolean isLoaded() {
        return searchField.isDisplayed() && getCurrentPageTitle().contains("Thank you");
    }
}
