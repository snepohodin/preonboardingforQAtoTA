package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailSignInPasswordPage extends BasePage {

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "#passwordNext")
    private WebElement nextButton;

    public GmailSignInPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(passwordField, 10);
    }

    public GmailInboxPage setValidPassword(String userPass) {
        passwordField.sendKeys(userPass);
        nextButton.click();
        return new GmailInboxPage(browser);
    }

    public GmailSignInPasswordErrorPage setInvalidPassword(String userPass) {
        passwordField.sendKeys(userPass);
        nextButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new GmailSignInPasswordErrorPage(browser);
    }

    public boolean isLoaded() {
        return passwordField.isDisplayed();
    }
}
