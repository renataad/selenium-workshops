package Pages.AutenticationPages;

import Pages.BasePage;
import Pages.CheckoutPages.AddressPage;
import org.openqa.selenium.By;

public class SignInPage extends BasePage {

    private By emailInputLocator = By.id("email");
    private By passwordInputLocator = By.id("passwd");
    private By signInButtonLocator = By.id("SubmitLogin");

    public SignInPage provideEmailInput(String email) {
        provideInput(emailInputLocator, email);
        return this;
    }

    public SignInPage providePasswordInput(String password) {
        provideInput(passwordInputLocator, password);
        return this;
    }

    public AddressPage clickSignInButtonAndGoToAddressPage() {
        clickOnElement(signInButtonLocator);
        return new AddressPage();
    }

    public boolean isPasswordInputActive = findElement(passwordInputLocator).isEnabled();

}
