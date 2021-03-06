package Pages;

import Driver.Driver;
import Pages.CheckoutPages.CheckoutSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFrameQuickViewPage extends BasePage {

    private By addToCartLocator = By.cssSelector(".buttons_bottom_block.no-print > button.exclusive");
    private By resultMessageLocator = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2");
    private By proceedToCheckoutLocator = By.cssSelector("a[title='Proceed to checkout']");

    public IFrameQuickViewPage switchToIFrame(By frameElement) {
        WebElement iFrame = wait.until(ExpectedConditions.presenceOfElementLocated(frameElement));
        Driver.getDriver().switchTo().frame(iFrame);
        return this;
    }

    public IFrameQuickViewPage addToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));
        addToCartButton.click();
        return this;
    }

    public String getResultMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(resultMessageLocator)).getText();
    }

    public CheckoutSummaryPage proceedToCheckoutAndGoToCheckoutSummaryPage() {
        clickOnElement(proceedToCheckoutLocator);

        return new CheckoutSummaryPage();
    }
}
