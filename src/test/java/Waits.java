import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

//uprościć kod

public class Waits {
    private WebDriver driver;

    private By searchInputLocator = By.id("search_query_top");
    private By searchButtonLocator = By.cssSelector("button[name='submit_search']");
    private By myDressLocator = By.cssSelector("div[class='right-block']>h5>a[href*='id_product=4&']");
    private By addToCartButtonLocator = By.cssSelector("#add_to_cart button");
    private By resultMessageLocator = By.cssSelector("div#layer_cart div[class*='layer_cart_product'] h2");

    public void searchItem(String inputText) {
        WebElement searchInput = driver.findElement(searchInputLocator);
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchInput.clear();
        searchInput.sendKeys(inputText);
        searchButton.click();
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");
    }

    @Test
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchItem("Printed dress");

        WebElement myDress = driver.findElement(myDressLocator);
        myDress.click();
        WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
        addToCartButton.click();
        String successMessage = "Product successfully added to your shopping cart";
        WebElement resultMessage = driver.findElement(resultMessageLocator);
        Assert.assertEquals("Wrong message", successMessage, resultMessage.getAttribute("innerText").trim());
    }

    @Test
    public void explicitWait() {
        searchItem("Printed dress");

        WebElement myDress = driver.findElement(myDressLocator);
        myDress.click();
        WebElement increaseQuantity = driver.findElement(By.cssSelector(".icon-plus"));
        increaseQuantity.click();
        WebElement sizeDropdown = driver.findElement(By.cssSelector("#group_1"));
        Select select = new Select(sizeDropdown);
        select.selectByVisibleText("M");
        WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
        addToCartButton.click();
        String successMessage = "Product successfully added to your shopping cart";

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultMessage = wait.until(ExpectedConditions.presenceOfElementLocated(resultMessageLocator));
        Assert.assertEquals("Wrong message", successMessage, resultMessage.getAttribute("innerText").trim());
    }

    @Test
    public void checkIfSpecialPriceIsCorrect() {
        SoftAssertions softAssertions = new SoftAssertions();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement categoryDresses = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a[@title='Dresses']"));
        categoryDresses.click();

        List<WebElement> discountedDresses = driver.findElements(By.xpath("//div[@class='product-container']//div[@class='right-block']//span[@class='price-percent-reduction']/.."));

        for (WebElement dress : discountedDresses) {
            System.out.println();
            String currentPrice = dress.findElement(By.cssSelector("span[class='price product-price']")).getText().replace("$", "");
            System.out.println("Current price: " + currentPrice);
            double oldPrice = Double.parseDouble(dress.findElement(By.cssSelector("span[class='old-price product-price']")).getText().replace("$", ""));
            System.out.println("Old price: " + oldPrice);
            String percentageDiscount = dress.findElement(By.cssSelector("span.price-percent-reduction")).getText();
            double discount = (Integer.parseInt(percentageDiscount.substring(1, (percentageDiscount.length() - 1)))) / 100.0;
            System.out.println("Discount: " + discount);

            double result = oldPrice * (1 - discount);
            String stringResult = String.format(Locale.ROOT, "%.2f", result);

            softAssertions.assertThat(stringResult).isEqualTo(currentPrice);
        }
        softAssertions.assertAll();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}