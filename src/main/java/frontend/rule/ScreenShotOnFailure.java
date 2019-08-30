package frontend.rule;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShotOnFailure extends TestWatcher {

    private final WebDriver driver;

    public ScreenShotOnFailure(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void succeeded(Description description) {
        driver.quit();
    }

    @Override
    protected void failed(Throwable e, Description description) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dateTimeFormatter.format(now).replace(" ", "-").replaceAll("/", "-").replaceAll(":", "-");
        File screenshot = new File("./tmp/" + description.getClassName() + "-" + description.getMethodName() + "-" + date + ".png");

        try {
            FileUtils.moveFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), screenshot);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            driver.quit();
        }
    }

}
