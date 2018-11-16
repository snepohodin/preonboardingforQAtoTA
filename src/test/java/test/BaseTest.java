package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GmailHomePage;

public class BaseTest {
    WebDriver browser;
    GmailHomePage gmailHomePage;

    @Parameters({"browserName"})
    @BeforeMethod
    public void beforeMethod(@Optional("default")String browserName) {
        if (browserName.toLowerCase().equals("firefox")) {
            browser = new FirefoxDriver();
        } else {
            browser = new ChromeDriver();
        }
        browser.get("https://www.google.com/gmail/about/#");
        gmailHomePage = new GmailHomePage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }
}
