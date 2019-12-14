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
    WebDriver driver;
    LoginPopup loginPopup;
    LogoutPopup logoutPopup;

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
        driver.get("https://www.tut.by/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPopup = new LoginPopup(driver);
        loginPopup.login("seleniumtests@tut.by", "123456789zxcvbn");
        logoutPopup = new LogoutPopup(driver);
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
