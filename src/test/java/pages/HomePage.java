package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static final By LOGIN_LINK = By.className("enter");
    private static final By LOGIN = By.name("login");
    private static final By PASSWORD = By.name("password");
    private static final By LOGIN_BUTTON = By.xpath(".//input[contains(@class, 'button auth__enter')]");
    private static final By LOGGED_IN_RESULT = By.xpath(".//a[contains(@class, 'logedin')]");
    private static final String URL = "https://www.tut.by/";
    private final WebDriver driver;

    public HomePage() {
        this.driver = WebDriverSingleton.getInstance();
    }

    public void load() {
        this.driver.get(URL);
    }

    public LoggedInHomePage login(String username, String password) {
        driver.findElement(LOGIN_LINK).click();
        driver.findElement(LOGIN).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new LoggedInHomePage();
    }

    public boolean getLoggedInResult() {
        try {
            return driver.findElement(LOGGED_IN_RESULT).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
