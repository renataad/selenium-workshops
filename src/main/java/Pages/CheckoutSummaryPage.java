package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSummaryPage extends BasePage{

    private By proceedToCheckoutLocator = By.cssSelector("p.cart_navigation a[title='Proceed to checkout']");

    public CheckoutSummaryPage(WebDriver driver) {
        super(driver);
    }

    public  proceedToCheckoutAndGoToSignInPage() {
        clickOnElement(proceedToCheckoutLocator);
    }
}
