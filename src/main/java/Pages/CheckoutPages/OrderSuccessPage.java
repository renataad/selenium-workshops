package Pages.CheckoutPages;

import Pages.BasePage;
import org.openqa.selenium.By;

public class OrderSuccessPage extends BasePage {

    private By orderResultMessage = By.cssSelector("p[class='alert alert-success']");

    public String getOrderResultMessage() {
        return findElement(orderResultMessage).getText();
    }
}
