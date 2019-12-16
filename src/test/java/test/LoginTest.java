package test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import junit.MyExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.WebDriverSingleton;

@ExtendWith(MyExtension.class)
public class LoginTest {

    private static final String TEST_LOGIN = "seleniumtests@tut.by";
    private static final String TEST_PASSWORD = "123456789zxcvbn1";

    WebDriver driver;
    HomePage homePage;
    String message;

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
    }

    @AfterEach
    public void closeBrowser() {
        WebDriverSingleton.closeBrowser();
    }

    @Feature("Authorization")
    @Description("Verifies if user can log in")
    @Issue("ID_1")
    @Test
    public void login() {
        homePage = new HomePage();
        homePage.load();
        homePage.login(TEST_LOGIN, TEST_PASSWORD);
        message = "User is logged in";
        Assertions.assertTrue(homePage.getLoggedInResult(), message);
    }
}
