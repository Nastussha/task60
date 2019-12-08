package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPopup;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    LoginPopup loginPopup;

    @BeforeEach
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.get("https://www.tut.by/");

    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void login(){
        loginPopup = new LoginPopup(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPopup.openLoginPopup();
        loginPopup.setUserName("seleniumtests@tut.by");
        loginPopup.setPassword("123456789zxcvbn");
        loginPopup.clickLoginButton();

        Assertions.assertTrue(loginPopup.getLoggedInResult(), "User is not logged in");
    }

}
