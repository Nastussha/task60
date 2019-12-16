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
    LoginPopup loginPopup;
    LogoutPopup logoutPopup;

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
        driver.get("https://www.tut.by/");
        loginPopup = new LoginPopup();
        logoutPopup = new LogoutPopup();
        loginPopup.login(TEST_LOGIN, TEST_PASSWORD);
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