package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPopup {

    private static final By LOGGED_IN_LINK = By.xpath(".//a[contains(@class, 'logedin')]");
    private static final By LOGGED_OUT_BUTTON = By.xpath(".//a[contains(text(), 'Выйти')]");
    private static final By LOGGED_OUT_RESULT = By.xpath(".//a[contains(text(), 'Войти')]");

    WebDriver driver;

    public LogoutPopup(WebDriver driver) {
        this.driver = driver;
    }

    public void openLogoutPopup() {
        driver.findElement(LOGGED_IN_LINK).click();
    }

    public void clickLogOutButton() {
        driver.findElement(LOGGED_OUT_BUTTON).click();
    }

    public void logout() {
        openLogoutPopup();
        clickLogOutButton();
    }

    public boolean getLogOutResult() {
        return driver.findElement(LOGGED_OUT_RESULT).isDisplayed();
    }
}
