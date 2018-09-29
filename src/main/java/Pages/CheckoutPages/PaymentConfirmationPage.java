package Pages.CheckoutPages;

import Pages.BasePage;
import org.openqa.selenium.By;

public class PaymentConfirmationPage extends BasePage {

    private By confirmOrderButtonLocator = By.cssSelector("p#cart_navigation button[type='submit']");

    public OrderSuccessPage confirmOrder(){
        clickOnElement(confirmOrderButtonLocator);
        return new OrderSuccessPage();
    }
}
