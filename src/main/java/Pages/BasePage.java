package Pages;

import Driver.Driver;
import Pages.AutenticationPages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriverWait wait;
    protected Actions actions;
    private By signInLocator = By.className("login");

    public BasePage() {
        wait = new WebDriverWait(Driver.getDriver(), 30);
        actions = new Actions(Driver.getDriver());
    }

    public void provideInput(By inputLocator, CharSequence value) {
        WebElement input = findElement((inputLocator));
        input.clear();
        input.sendKeys(value);
    }

    public void clickOnElement(By elementBy) {
        findElement(elementBy).click();
    }

    public WebElement findElement(By elementBy) {
        return Driver.getDriver().findElement(elementBy);
    }

    public List<WebElement> findElements(By elementBy) {
        return Driver.getDriver().findElements(elementBy);
    }

    public MainPage switchToDefaultIFrame() {
        Driver.getDriver().switchTo().defaultContent();
        return new MainPage();
    }

    public SignInPage clickSignInLink() {
        clickOnElement(signInLocator);
        return new SignInPage();
    }

    public String getTitle() {
        return Driver.getDriver().getTitle();
    }

    public void switchWindow(String handle) {
        Driver.getDriver().switchTo().window(handle);
    }

    public Set<String> getAllWindowHandles() {
        return Driver.getDriver().getWindowHandles();
    }

    public void switchToNextWindow() {
        String parentHandle = Driver.getDriver().getWindowHandle();
        for (String handle : getAllWindowHandles()) {
            if (!handle.equals(parentHandle)) {
                switchWindow(handle);
            }
        }


    }
}