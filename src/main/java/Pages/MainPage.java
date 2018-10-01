package Pages;

import Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    private By productListLocator = By.xpath("//ul[@id='homefeatured']//a[@class='product_img_link']");
    private By quickViewLocator = By.className("quick-view");
    private By socialMediaListLocator = By.cssSelector("#social_block a");
    private String socialMediaLocator = "#social_block li.";


    public void clickOnSocialMedia(String parametr) {
        clickOnElement(By.cssSelector(socialMediaLocator + parametr));

    }

    public IFrameQuickViewPage firstProductQuickView() {
        List<WebElement> productList = findElements(productListLocator);
        WebElement firstProductOnPage = productList.get(0);
        actions.moveToElement(firstProductOnPage).build().perform();
        clickOnElement(quickViewLocator);
        return new IFrameQuickViewPage();
    }

    public String getParentWindowHandle() {
        return Driver.getDriver().getWindowHandle();
    }



    public List<WebElement> getSocialMediaList() {

        return findElements(socialMediaListLocator);
    }



    public void closeActiveWindow() {
        Driver.getDriver().close();
    }

}

