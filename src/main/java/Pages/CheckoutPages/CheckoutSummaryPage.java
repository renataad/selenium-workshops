package Pages.CheckoutPages;

import Pages.BasePage;
import Pages.AutenticationPages.SignInPage;
import org.openqa.selenium.By;

public class CheckoutSummaryPage extends BasePage {

    private By proceedToCheckoutLocator = By.cssSelector("p.cart_navigation a[title='Proceed to checkout']");


    public SignInPage proceedToCheckoutAndGoToSignInPage() {
        clickOnElement(proceedToCheckoutLocator);
        return new SignInPage();
    }
}
