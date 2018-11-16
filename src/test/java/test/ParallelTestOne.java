package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

public class ParallelTestOne extends BaseTest {

    @DataProvider
    public Object[][] validFieldsCombination() {
        return new Object[][]{
                {"rdmntest@gmail.com", "0131223689"},
                {"RDMNTEST@gmail.com", "0131223689"}
        };
    }

    @Test(dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass) {

        Assert.assertTrue(gmailHomePage.isLoaded(),"Gmail page should be opened.");

        GmailSignInEmailPage gmailSignInEmailPage = gmailHomePage.navigateToSignInEmailPage();
        Assert.assertTrue(gmailSignInEmailPage.isLoaded(),"Gmail Sign In should be opened.");

        GmailSignInPasswordPage gmailSignInPasswordPage = gmailSignInEmailPage.setEmail(userEmail);
        Assert.assertTrue(gmailSignInPasswordPage.isLoaded(),"Gmail Sign In password page should be opened..");

        GmailInboxPage gmailInboxPage = gmailSignInPasswordPage.setValidPassword(userPass);
        Assert.assertTrue(gmailInboxPage.isLoaded(),"Gmail Inbox page should be opened.");

        System.out.println("Test Case One in " + getClass().getSimpleName()
                + " with Thread Id:- " + Thread.currentThread().getId());

        System.out.println("Test Case One in " + getClass().getSimpleName()
                + " with Thread Id:- " + Thread.currentThread().getId());
    }

}
