package Driver;

import Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver) {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("browserName", "chrome");
            options.setCapability("platform", "LINUX");
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quit() {
        if (null != driver) {
            getDriver().quit();
        }
        driver = null;
    }

    public static MainPage openPage(){
        getDriver().navigate().to("http://automationpractice.com");
        return new MainPage();

    }

}
