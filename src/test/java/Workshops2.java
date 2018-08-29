import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Workshops2 {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com");
    }

    @Test
    //znajdujemy całą listę produktów, potem iterujemy po elementach i znajdujemy w nich nazwy produktów,
    // sprawdzamy czy znajduje się tam "dress"
    // sprawdzamy czy lista zawiera 7 elementów

    public void findDressInProductList() {
        int expectedAmount = 7;
        String searchedName ="dress";

        List<WebElement> productList = driver.findElements(By.xpath("//ul[@id='homefeatured']//div[@class='product-container']"));
        System.out.println(productList.size());

        boolean isDressOnList = false;
        for (WebElement product : productList) {
            String name = product.findElement(By.xpath(".//h5/a[@class='product-name']")).getText().toLowerCase();
            if (name.contains(searchedName)) {
                isDressOnList =true;
                break;
            }
        }
        Assert.assertTrue("Dress is not on the list", isDressOnList);
        Assert.assertEquals("Different size of list elements", expectedAmount, productList.size());
    }

    @Test
    //znajdujemy listę nazw produktów i sprawdzamy czy istnieje w niej "dress"
    public void findDressInNameList() {
        String searchedName ="dress";
        List<WebElement> nameList = driver.findElements(By.xpath("//h5/a[@class='product-name']"));

        boolean isDressOnList = false;
        for (WebElement element : nameList) {
            String name = element.getText().toLowerCase();
            if (name.contains(searchedName)) {
                isDressOnList =true;
                break;
            }
        }
        Assert.assertTrue("Dress is not on the list",isDressOnList);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
