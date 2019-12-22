package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    private static final String URL = "https://www.tut.by/";

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

    public HomePage() {
        this.driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public void load(){
        this.driver.get(URL);
    }

    public LoggedInHomePage login(String username, String password) {
        loginLink.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new LoggedInHomePage();
    }

    public boolean getLoggedInResult() {
        return loggedinResult.isDisplayed();
    }
}
