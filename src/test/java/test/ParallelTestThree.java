package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailEmailPage;
import page.GmailInboxPage;
import page.GmailSignInEmailPage;
import page.GmailSignInPasswordPage;

public class ParallelTestThree extends BaseTest {
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

        System.out.println("Test Case One in " + getClass().getSimpleName()
                + " with Thread Id:- " + Thread.currentThread().getId());
    }
}
