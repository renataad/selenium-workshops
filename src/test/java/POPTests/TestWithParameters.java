package POPTests;

import edu.emory.mathcs.backport.java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestWithParameters extends BaseTest {

    @Parameter(0)
    public String targetPage;

    @Parameter(1)
    public String targetPageTitle;

    @Parameters(name = "{index}: Open social media link for {0} and expect title with {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"facebook", "facebook"},
                {"twitter", "twitter"},
                {"youtube", "youtube"},
                {"google-plus", "google+"}

        });
    }

    @Test
    public void checkSocialMediaPageTitle() {

        mainPage.clickOnSocialMedia(targetPage);
        mainPage.switchToNextWindow();


        String pageTitle = mainPage.getTitle().toLowerCase();
        boolean ifContainsName = pageTitle.contains(targetPageTitle);

            Assert.assertTrue("Page Title does not contain " + targetPageTitle, ifContainsName);

        }
    }
