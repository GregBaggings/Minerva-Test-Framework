package frontend.webdriver.factory;


import frontend.webdriver.managers.ChromeDriverManager;
import frontend.webdriver.managers.WebDriverManager;
import frontend.WebDrivers;

public class WebDriverFactory {

    public static WebDriverManager getManager(WebDrivers chosenBrowser) {

        WebDriverManager driverManager;

        switch (chosenBrowser) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            // TODO: Add further browser implementations
            default:
                driverManager = new ChromeDriverManager();
                break;
        }

        return driverManager;
    }

}
