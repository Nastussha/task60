package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class GridTest {
    public static WebDriver driver;
    public static final String URL = "http://localhost:4444/wd/hub/";

    @Test
    void testingGrid() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "71.0");
        driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://pogoda.tut.by/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }
}
