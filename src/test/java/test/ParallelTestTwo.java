package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GmailSignInEmailPage;
import page.GmailSignInPasswordErrorPage;
import page.GmailSignInPasswordPage;

public class ParallelTestTwo extends BaseTest {

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

        System.out.println("Test Case One in " + getClass().getSimpleName()
                + " with Thread Id:- " + Thread.currentThread().getId());
    }
}
