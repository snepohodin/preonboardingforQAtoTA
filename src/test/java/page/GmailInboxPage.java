package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailInboxPage extends BasePage {

    @FindBy(css = "input[placeholder]")
    private WebElement searchField;

    @FindBy(css = ".zA")
    private List<WebElement> email;

    public GmailInboxPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(searchField, 10);
    }

    public boolean isLoaded() {
        return searchField.isDisplayed();
    }

    public GmailEmailPage navigateToEmailPage() {
        for (WebElement emailsub : email) {
            if (emailsub.getText().toLowerCase().contains("thank you for your order") == true) {
                emailsub.click();
                break;
            }
        }
        return new GmailEmailPage(browser);
    }
}
