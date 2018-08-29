package POPTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.MainPage;

public class BaseTest {

    private WebDriver driver;
    protected MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");
        mainPage = new MainPage(driver);
    }

    @After
    public void quitDriver () {
        driver.quit();
    }

}

