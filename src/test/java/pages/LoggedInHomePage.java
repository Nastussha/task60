package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInHomePage {

    private static final By LOGGED_IN_LINK = By.xpath(".//a[contains(@class, 'logedin')]");
    private static final By LOGGED_OUT_BUTTON = By.xpath(".//a[contains(text(), 'Выйти')]");
    private static final By LOGGED_OUT_RESULT = By.xpath(".//a[contains(text(), 'Войти')]");

    private final WebDriver driver;

    public LoggedInHomePage() {
        this.driver = WebDriverSingleton.getInstance();
    }

    public HomePage logout() {
        driver.findElement(LOGGED_IN_LINK).click();
        driver.findElement(LOGGED_OUT_BUTTON).click();
        return new HomePage();
    }

    public boolean getLogOutResult() {
        return driver.findElement(LOGGED_OUT_RESULT).isDisplayed();
    }
}
