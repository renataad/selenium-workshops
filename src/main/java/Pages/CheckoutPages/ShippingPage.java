package Pages.CheckoutPages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShippingPage extends BasePage {

    private By proceedToCheckoutButtonLocator = By.cssSelector("button[name='processCarrier']");
    private By termsCheckboxLocator = By.id("cgv");


    public PaymentPage proceedToCheckoutAndGoToPaymentPage() {
        clickOnElement(proceedToCheckoutButtonLocator);
        return new PaymentPage();
    }

    public ShippingPage acceptTermsOfService() {
        WebElement termsCheckbox = findElement(termsCheckboxLocator);
        if (!termsCheckbox.isSelected()) {
            clickOnElement(termsCheckboxLocator);
        }
        return this;
    }
}
