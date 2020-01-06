package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    public static final String USERNAME = "avlandd";
    public static final String ACCESS_KEY = "c616b8e4-10cf-4d2b-9e86-1362ca0e39a4";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";


    public static WebDriver driver;

    public static WebDriver getInstance() {
        try {
            if (driver == null) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "Windows 8.1");
                caps.setCapability("version", "39.0");
                driver = new RemoteWebDriver(new URL(URL), caps);
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }

    public static void closeBrowser(){
        driver.close();
        driver = null;
    }
}
