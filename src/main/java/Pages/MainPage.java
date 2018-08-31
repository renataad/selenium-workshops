package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainPage extends BasePage {

    private By productListLocator = By.xpath("//ul[@id='homefeatured']//a[@class='product_img_link']");
    private By quickViewLocator = By.className("quick-view");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public IFrameQuickViewPage firstProductQuickView() {
        List<WebElement> productList = findElements(productListLocator);
        WebElement firstProductOnPage = productList.get(0);
        Actions action = new Actions(driver);
        action.moveToElement(firstProductOnPage).build().perform();
        clickOnElement(quickViewLocator);
        return new IFrameQuickViewPage(driver);

    }

    public String getParentWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set <String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }

    public List <WebElement> getSocialMediaList() {
        By socialMediaListLocator = By.cssSelector("#social_block a");
        return findElements(socialMediaListLocator);
    }

    public void switchWindow(String handle) {
        driver.switchTo().window(handle);
    }

    public void closeActiveWindow(){
        driver.close();
    }


}

