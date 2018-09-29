package POPTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.MainPage;
import Driver.Driver;

public class BaseTest {

    protected MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = Driver.openPage();

    }


    @After
    public void quitDriver() {
        Driver.quit();
    }

}

