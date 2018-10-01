package POPTests;

import Driver.Driver;
import Pages.MainPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class BaseTest {

    protected MainPage mainPage;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(String browser, Method method) {

        Driver.setUpDriver(browser);
        Driver.getDriver();
        Driver.waitFor();
        mainPage = Driver.openPage();
        System.out.println("Test na przeglądarce: " + browser);
        System.out.println("Method name: " + method.getName());


    }

    @AfterMethod
    public void quitDriver(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("passed **********");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed ***********");

        } else if (result.getStatus() == ITestResult.SKIP) {

            System.out.println("Skiped***********");

        }
        Driver.quit();
    }

}

