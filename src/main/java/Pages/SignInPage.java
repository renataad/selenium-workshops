package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class SignInPage extends BasePage {
    private By emailInputLocator = By.id("email");
    private By passwordInputLocator = By.id("passwd");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage provideEmailInput(String value) {
        provideInput(emailInputLocator, value);
        findElement(emailInputLocator).sendKeys(Keys.TAB);
        return this;
    }
    public boolean isPasswordInputActive = findElement(passwordInputLocator).isEnabled();


}
