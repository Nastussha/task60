package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import pageFactory.LoginPopup;
import pageFactory.WebDriverSingleton;

import java.io.File;
import java.io.IOException;

public class LoginTest {

    private static final String TEST_LOGIN = "seleniumtests@tut.by";
    private static final String TEST_PASSWORD = "123456789zxcvbn";

    WebDriver driver;
    LoginPopup loginPopup;

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
        driver.get("https://www.tut.by/");
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void login() {
        loginPopup = new LoginPopup();
        loginPopup.login(TEST_LOGIN, TEST_PASSWORD);
        takeScreenshot();
        Assertions.assertTrue(loginPopup.getLoggedInResult(), "User is not logged in");
    }

    public void takeScreenshot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(src, new File("./target/screenshot.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
