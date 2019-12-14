package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageFactory.*;

import java.util.concurrent.TimeUnit;

public class LogoutTest {
    WebDriver driver;
    LoginPopup loginPopup;
    LogoutPopup logoutPopup;

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.tut.by/");
        loginPopup = new LoginPopup(driver);
        logoutPopup = new LogoutPopup(driver);
        loginPopup.login("seleniumtests@tut.by", "123456789zxcvbn");
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