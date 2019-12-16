package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPopup {

    private final WebDriver driver;

    @FindBy(className = "enter")
    private WebElement loginLink;

    @FindBy(name = "login")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = ".//input[contains(@class, 'button auth__enter')]")
    private WebElement loginButton;

    @FindBy(xpath = ".//a[contains(@class, 'logedin')]")
    private WebElement loggedinResult;

    public LoginPopup() {
        this.driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        loginLink.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean getLoggedInResult() {
        return loggedinResult.isDisplayed();
    }
}
