package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailSignInPasswordErrorPage extends BasePage {

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "#password>div:last-child")
    private WebElement passwordErrorText;

    @FindBy(css = "#passwordNext")
    private WebElement nextButton;

    public GmailSignInPasswordErrorPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(passwordField, 10);
    }

    public String getPasswordErrorText() {
        return passwordErrorText.getText();
    }

    public boolean isLoaded() {
        return passwordField.isDisplayed();
    }
}
