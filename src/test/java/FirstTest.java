import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.beans.property.SetProperty;
import javafx.scene.layout.Priority;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");
    }

    @Test
    public void openPageTest() {
        Assert.assertEquals("My Store", driver.getTitle());
    }

    @Test
    public void searchDress() {
        WebElement searchInput = driver.findElement(By.id("search_query_top"));
        WebElement searchButton = driver.findElement(By.cssSelector("button[name='submit_search']"));
        searchInput.clear();
        searchInput.sendKeys("Printed dress");
        searchButton.click();
    }

    @Test
    public void addToCart() {
        searchDress();
        WebElement firstProductOnPage = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[1]/div[@class='product-container']"));
        Actions action = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProductOnPage);
        action.moveToElement(firstProductOnPage).perform();
        WebElement addToCartButton = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[1]//span[text()='Add to cart']"));
        addToCartButton.click();
        String successMessage = "Product successfully added to your shopping cart";
        WebElement resultMessage = driver.findElement(By.xpath("//div[@id='layer_cart']//div[@class='layer_cart_product col-xs-12 col-md-6']//h2"));
        Assert.assertEquals("Wrong message", successMessage, resultMessage.getAttribute("innerText").trim());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

