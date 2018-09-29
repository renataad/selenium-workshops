package Pages.CheckoutPages;

import Pages.BasePage;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private By payByCheckLocator = By.className("cheque");

    public PaymentConfirmationPage clickPayByCheck() {
        clickOnElement(payByCheckLocator);
        return new PaymentConfirmationPage();
    }
}
