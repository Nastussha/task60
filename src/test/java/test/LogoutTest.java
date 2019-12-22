package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageFactory.*;

public class LogoutTest {

    private static final String TEST_LOGIN = "seleniumtests@tut.by";
    private static final String TEST_PASSWORD = "123456789zxcvbn";

    WebDriver driver;
    HomePage homePage;
    LoggedInHomePage logoutPopup;

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
        homePage = new HomePage();
        homePage.load();
        logoutPopup = homePage.login(TEST_LOGIN, TEST_PASSWORD);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void logout() {
        logoutPopup.logout();
        Assertions.assertTrue(logoutPopup.getLogOutResult(), "User is not logged out");
    }
}