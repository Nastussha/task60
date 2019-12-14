package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPopup {

    WebDriver driver;
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

    public LoginPopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginPopup(){
        loginLink.click();
    }

    public void setUserName(String username){
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void login(String username, String password){
        openLoginPopup();
        setUserName(username);
        setPassword(password);
        clickLoginButton();
    }

    public boolean getLoggedInResult (){
        return loggedinResult.isDisplayed();
    }
}
