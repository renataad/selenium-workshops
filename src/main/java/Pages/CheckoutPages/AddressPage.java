package Pages.CheckoutPages;

import Pages.BasePage;
import org.openqa.selenium.By;

public class AddressPage extends BasePage {

    private By proceedToCheckoutButtonLocator = By.cssSelector("button[name='processAddress']");

    public ShippingPage proccedToCheckoutAndGoToShippingPage() {
        clickOnElement(proceedToCheckoutButtonLocator);
        return new ShippingPage();
    }
}
