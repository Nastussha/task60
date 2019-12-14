package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPopup {
    private static final By LOGIN_LINK = By.className("enter");
    private static final By LOGIN = By.name("login");
    private static final By PASSWORD = By.name("password");
    private static final By LOGIN_BUTTON = By.xpath(".//input[contains(@class, 'button auth__enter')]");
    private static final By LOGGED_IN_RESULT = By.xpath(".//a[contains(@class, 'logedin')]");
    WebDriver driver;

    public LoginPopup(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPopup() {
        driver.findElement(LOGIN_LINK).click();
    }

    public void setUserName(String username) {
        driver.findElement(LOGIN).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void login(String username, String password) {
        openLoginPopup();
        setUserName(username);
        setPassword(password);
        clickLoginButton();
    }

    public boolean getLoggedInResult() {
        return driver.findElement(LOGGED_IN_RESULT).isDisplayed();
    }
}
