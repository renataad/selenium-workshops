package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private By signInLocator = By.className("login");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void provideInput(By inputLocator, CharSequence value) {
        WebElement input = driver.findElement((inputLocator));
        input.clear();
        input.sendKeys(value);
    }

    public void clickOnElement(By elementBy) {
        driver.findElement(elementBy).click();
    }

    public WebElement findElement(By elementBy) {
        return driver.findElement(elementBy);
    }

    public List<WebElement> findElements(By elementBy) {
        return driver.findElements(elementBy);
    }

    public MainPage switchToDefaultIFrame() {
        driver.switchTo().defaultContent();
        return new MainPage(driver);
    }

    public SignInPage clickSignIn() {
        clickOnElement(signInLocator);
        return new SignInPage(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
