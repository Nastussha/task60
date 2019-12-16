package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPopup {

    private final WebDriver driver;

    @FindBy(xpath = ".//a[contains(@class, 'logedin')]")
    private WebElement loggedinLink;

    @FindBy(xpath = ".//a[contains(text(), 'Выйти')]")
    private WebElement logoutButton;

    @FindBy(xpath = ".//a[contains(text(), 'Войти')]")
    private WebElement logoutResult;

    public LogoutPopup() {
        this.driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        loggedinLink.click();
        logoutButton.click();
    }

    public boolean getLogOutResult() {
        return logoutResult.isDisplayed();
    }


}
