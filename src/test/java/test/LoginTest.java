package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPopup;
import pages.WebDriverSingleton;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    LoginPopup loginPopup;

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.tut.by/");
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void login(){
        loginPopup = new LoginPopup(driver);
        loginPopup.login("seleniumtests@tut.by", "123456789zxcvbn");
        Assertions.assertTrue(loginPopup.getLoggedInResult(), "User is not logged in");
    }

}
