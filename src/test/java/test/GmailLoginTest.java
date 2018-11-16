package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

public class GmailLoginTest extends BaseTest {

    @DataProvider
    public Object[][] validFieldsCombination() {
        return new Object[][]{
                {"rdmntest@gmail.com", "0131223689"},
                {"RDMNTEST@gmail.coM", "0131223689"}
        };
    }

    @Test(invocationCount = 2, dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass) {

        Assert.assertTrue(gmailHomePage.isLoaded(),"Gmail page should be opened.");

        GmailSignInEmailPage gmailSignInEmailPage = gmailHomePage.navigateToSignInEmailPage();
        Assert.assertTrue(gmailSignInEmailPage.isLoaded(),"Gmail Sign In should be opened.");

        GmailSignInPasswordPage gmailSignInPasswordPage = gmailSignInEmailPage.setEmail(userEmail);
        Assert.assertTrue(gmailSignInPasswordPage.isLoaded(),"Gmail Sign In password page should be opened.");

        GmailInboxPage gmailInboxPage = gmailSignInPasswordPage.setValidPassword(userPass);
        Assert.assertTrue(gmailInboxPage.isLoaded(),"Gmail Inbox page should be opened.");
    }

    @Test
    public void unsuccessfullLoginTest() {

        Assert.assertTrue(gmailHomePage.isLoaded(),"Gmail page should be opened.");

        GmailSignInEmailPage gmailSignInEmailPage = gmailHomePage.navigateToSignInEmailPage();
        Assert.assertTrue(gmailSignInEmailPage.isLoaded(),"Gmail Sign In should be opened.");

        GmailSignInPasswordPage gmailSignInPasswordPage = gmailSignInEmailPage.setEmail("rdmntest@gmail.com");
        Assert.assertTrue(gmailSignInPasswordPage.isLoaded(),"Gmail Sign In password page should be opened..");

        GmailSignInPasswordErrorPage gmailSignInPasswordErrorPage = gmailSignInPasswordPage.setInvalidPassword("123123123123");

        Assert.assertTrue(gmailSignInPasswordErrorPage.getPasswordErrorText().equals("Неправильний пароль. Повторіть спробу або натисніть \"Не пам’ятаю пароль\", щоб скинути його."),
                "Error messages are not similar on password page.");
    }

    @Test
    public void letterWithSpecificSubjectTest() {

        Assert.assertTrue(gmailHomePage.isLoaded(),"Gmail page should be opened.");

        GmailSignInEmailPage gmailSignInEmailPage = gmailHomePage.navigateToSignInEmailPage();
        Assert.assertTrue(gmailSignInEmailPage.isLoaded(),"Gmail Sign In page should be opened.");

        GmailSignInPasswordPage gmailSignInPasswordPage = gmailSignInEmailPage.setEmail("rdmntest@gmail.com");
        Assert.assertTrue(gmailSignInPasswordPage.isLoaded(),"Gmail Sign In password page should be opened..");

        GmailInboxPage gmailInboxPage = gmailSignInPasswordPage.setValidPassword("0131223689");
        Assert.assertTrue(gmailInboxPage.isLoaded(),"Gmail Inbox page should be opened.");

        GmailEmailPage gmailEmailPage = gmailInboxPage.navigateToEmailPage();
        Assert.assertTrue(gmailEmailPage.isLoaded(),"Gmail Email page should be opened.");
    }
}
