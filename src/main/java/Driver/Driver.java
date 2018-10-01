package Driver;

import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Driver.DriverManager.getChromeOptions;
import static Driver.DriverManager.getFirefoxOptions;


public class Driver {
    private static WebDriver driverLocal;

    private static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();


    public static void setUpDriver(String browser) {
        if (browser.equals("firefox")) {
            try {
                driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getFirefoxOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else if (browser.equals("chrome")) {
            try {
                driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getChromeOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void waitFor(){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void quit() {
        if (null != driver) {
            getDriver().quit();
        }
    }

    public static MainPage openPage() {
        getDriver().navigate().to("http://automationpractice.com");
        return new MainPage();

    }

}
