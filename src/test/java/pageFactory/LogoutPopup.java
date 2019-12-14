package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPopup {

    WebDriver driver;

    @FindBy(xpath = ".//a[contains(@class, 'logedin')]")
    private WebElement loggedinLink;

    @FindBy(xpath = ".//a[contains(text(), 'Выйти')]")
    private WebElement logoutButton;

    @FindBy(xpath = ".//a[contains(text(), 'Войти')]")
    private WebElement logoutResult;

    public LogoutPopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLogoutPopup() {
        loggedinLink.click();
    }

    public void clickLogOutButton() {
        logoutButton.click();
    }

    public void logout() {
        openLogoutPopup();
        clickLogOutButton();
    }

    public boolean getLogOutResult() {
        return logoutResult.isDisplayed();
    }


}
