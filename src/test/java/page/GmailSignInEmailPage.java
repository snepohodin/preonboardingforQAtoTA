package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailSignInEmailPage extends BasePage {

    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    @FindBy(css = "div[role='button']")
    private WebElement nextButton;

    public GmailSignInEmailPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(emailField, 10);
    }

    public GmailSignInPasswordPage setEmail(String userEmail) {
        emailField.sendKeys(userEmail);
        nextButton.click();
        return new GmailSignInPasswordPage(browser);
    }

    public boolean isLoaded() {
        return emailField.isDisplayed();
    }
}
