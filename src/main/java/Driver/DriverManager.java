package Driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverManager {

    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.setCapability("name", "myTestName");
        return options;
    }

    public static FirefoxOptions getFirefoxOptions(){
        FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
        return options;
    }
}

