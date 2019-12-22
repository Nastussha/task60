package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoggedInHomePage;
import pages.WebDriverSingleton;

public class LogoutTest {

    private static final String TEST_LOGIN = "seleniumtests@tut.by";
    private static final String TEST_PASSWORD = "123456789zxcvbn";

    WebDriver driver;
    HomePage homePage;
    LoggedInHomePage loggedInHomePage;

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
        homePage = new HomePage();
        homePage.load();
        loggedInHomePage = homePage.login(TEST_LOGIN, TEST_PASSWORD);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void logout() {
        loggedInHomePage.logout();
        Assertions.assertTrue(loggedInHomePage.getLogOutResult(), "User is not logged out");
    }
}
