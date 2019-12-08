package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import pageFactory.LoginPopup;

import java.io.File;
import java.io.IOException;
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
    public void login() throws Exception {
        loginPopup = new LoginPopup(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        takeScreenshot();
        loginPopup.openLoginPopup();
        loginPopup.setUserName("seleniumtests@tut.by");
        loginPopup.setPassword("123456789zxcvbn");
        loginPopup.clickLoginButton();

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
