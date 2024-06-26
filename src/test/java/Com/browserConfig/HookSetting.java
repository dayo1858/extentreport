package Com.browserConfig;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class HookSetting {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private static String URL = "https://www.google.com";

    public static WebDriver driver() {
        return drivers.get();
    }

    public static void setDriver(WebDriver driver) {
        if (driver() != null){
            throw new IllegalStateException("Driver already set. Check your run config for extraneous glue");
        }
        drivers.set(driver);
    }

    public static void closeDriver() {
        driver().quit();
        drivers.set(null);
    }
}
