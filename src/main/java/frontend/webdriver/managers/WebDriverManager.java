package frontend.webdriver.managers;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {

    protected WebDriver driver;

    protected abstract void createDriver();
    protected abstract void startService();
    protected abstract void stopService();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }

}
