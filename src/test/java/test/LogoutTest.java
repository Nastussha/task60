package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPopup;
import pages.LogoutPopup;
import pages.WebDriverSingleton;

import java.util.concurrent.TimeUnit;

public class LogoutTest {

    private static final String TEST_LOGIN = "seleniumtests@tut.by";
    private static final String TEST_PASSWORD = "123456789zxcvbn";

    WebDriver driver;
    LoginPopup loginPopup;
    LogoutPopup logoutPopup;

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
        driver.get("https://www.tut.by/");
        loginPopup = new LoginPopup();
        loginPopup.login(TEST_LOGIN, TEST_PASSWORD);
        logoutPopup = new LogoutPopup();
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
