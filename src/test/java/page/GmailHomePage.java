package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage extends BasePage {

    @FindBy(css = "a[data-g-label='Sign in']")
    private WebElement signInButton;

    /**
     * Constructor of GmailHomePage class.
     * @param browser - WebDriver instance from test
     */
    public GmailHomePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(signInButton, 10);
    }

    public GmailSignInEmailPage navigateToSignInEmailPage() {
        signInButton.click();
        return new GmailSignInEmailPage(browser);
    }



    public boolean isLoaded() {
        return signInButton.isDisplayed();
    }
}
