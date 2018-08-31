package POPTests;

import Pages.CheckoutSummaryPage;
import Pages.IFrameQuickViewPage;
import Pages.SignInPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class POPTest extends BaseTest {

    private By iFrameQuickViewLocator = By.xpath("//iframe[@src='http://automationpractice.com/index.php?id_product=1&controller=product&content_only=1']");

    @Test
    public void addToCart() {
        String successMessage = "Product successfully added to your shopping cart";

        IFrameQuickViewPage iFrameQuickViewPage = mainPage.firstProductQuickView()
                .switchToIFrame(iFrameQuickViewLocator)
                .addToCart();

        Assert.assertEquals("Product hasn't been added to shopping cart!", successMessage, iFrameQuickViewPage.getResultMessage());
    }

    @Test
    public void checkIfPasswordInputIsActive() {
        String userEmail = "zzz@z.com";
        SignInPage signInPage = mainPage.clickSignIn()
                .provideEmailInput(userEmail + Keys.TAB);
        System.out.println(signInPage.isPasswordInputActive);

        Assert.assertTrue("Password input is inactive!", signInPage.isPasswordInputActive);
    }

    @Test
    public void checkSocialMediaPageTitle() {
        String parentHandle = mainPage.getParentWindowHandle();

        for (WebElement element : mainPage.getSocialMediaList()) {
            element.click();
            String nameOfSocialMediaElement = element.findElement(By.tagName("span")).getAttribute("innerText").toLowerCase();

            for (String handle : mainPage.getAllWindowHandles()) {
                if (!handle.equals(parentHandle)) {
                    mainPage.switchWindow(handle);
                    String pageTitle = mainPage.getTitle().toLowerCase();
                    boolean ifContainsName = pageTitle.contains(nameOfSocialMediaElement);

                    Assert.assertTrue("Page Title does not contain " + nameOfSocialMediaElement, ifContainsName);

                    mainPage.closeActiveWindow();
                }
            }
            mainPage.switchWindow(parentHandle);
        }
    }

    @Test
    public void orderByGuest() {
        String successMessage = "Product successfully added to your shopping cart";

        IFrameQuickViewPage iFrameQuickViewPage = mainPage.firstProductQuickView()
                .switchToIFrame(iFrameQuickViewLocator)
                .addToCart();

        //check total price= total product + total shipping

        Assert.assertEquals("Product hasn't been added to shopping cart!", successMessage, iFrameQuickViewPage.getResultMessage());


        CheckoutSummaryPage checkoutSummaryPage = iFrameQuickViewPage.proceedToCheckoutAndGoToCheckoutSummaryPage();

        //sprawdz czy lista produktow nie jest pusta
        //sprawdz quantity, product name, price, total price

        checkoutSummaryPage.proceedToCheckoutAndGoToSignInPage()



        //DO DOKONCZENIA!!!

    }
}
