import frontend.rule.ScreenShotOnFailure;
import frontend.webdriver.factory.WebDriverFactory;
import frontend.webdriver.managers.WebDriverManager;
import frontend.WebDrivers;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class BasicTests {

    private WebDriverManager driverManager = WebDriverFactory.getManager(WebDrivers.CHROME);
    private WebDriver driver = driverManager.getDriver();

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);


    @Test
    public void checkTheTitleOfIndexDotHu() {
        driver.get("https://index.hu/");
        Assert.assertEquals("Index", driver.getTitle());
    }

    @Test
    public void screenshotTest() {
        driver.get("https://sg.hu/asdwqrrfgvcxy");
        Assert.assertEquals("Something totally invalid :)", driver.getTitle());
    }

}
