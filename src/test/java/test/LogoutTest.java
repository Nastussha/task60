package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageFactory.*;

import java.util.concurrent.TimeUnit;

public class LogoutTest {
    WebDriver driver;
    LoginPopup loginPopup;
    LogoutPopup logoutPopup;

    @BeforeEach
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://www.tut.by/");
        loginPopup = new LoginPopup(driver);
        logoutPopup = new LogoutPopup(driver);
        loginPopup.openLoginPopup();
        loginPopup.setUserName("seleniumtests@tut.by");
        loginPopup.setPassword("123456789zxcvbn");
        loginPopup.clickLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void logout(){
        logoutPopup.openLogoutPopup();
        logoutPopup.clickLogOutButton();

        Assertions.assertTrue(logoutPopup.getLogOutResult(), "User is not logged out");
    }
}