package Com.browserConfig;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class DriverProvider {

    private static final String BROWSERSTACK_URL = "BROWSERSTACK_URL";
    private static final Logger log = LoggerFactory.getLogger(DriverProvider.class);

    @Value("webedriver.remote.url")
    private String webDriverRemoreUrl;

    public static WebDriver newDriver(Capabilities capabilities) throws MalformedURLException {
        if (isBrowserStack()) {
            return newBrowserStackDriver(capabilities);
        }
        return newLocalDriver(capabilities);
    }

    private static boolean isBrowserStack() {
        if (browserstackUrl() != null) {
            return true;
        }
        return false;
    }

    /**
      *
      * Key Type / Folder	Value
      * Access Key	zjQ1q3LxBixDMfpYLpd1
      * Local Folder URL	http://boladuro2.browserstack.com
      * Automate
      * View your private and unique BrowserStack Automate information and keys.

      * Username
      * boladuro2

      * Access Key
      * zjQ1q3LxBixDMfpYLpd
      *
      * BROWSERSTACK_URL = "https://+USERNAME+:+ACCESSKEY+@hub-cloud.browserstack.com/vd/hub"
      * BROWSERSTACK_URL = "https://boladuro2:zjQ1q3LxBixDMfpYLpd@hub-cloud.browserstack.com/vd/hub"
      * BROWSERSTACK_URL = "https://+USERNAME+:+ACCESSKEY+@hub-cloud.browserstack.com/vd/hub"
      *
      */

    private static String browserstackUrl() {
        return System.getenv(BROWSERSTACK_URL);
    }

    private static WebDriver newBrowserStackDriver(Capabilities capabilities) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(capabilities);
        desiredCapabilities.setCapability("build", "Abdul_Project_BrowserStack" + LocalDate.now());
        desiredCapabilities.setCapability("project", "Abdul_Project");
        desiredCapabilities.setCapability("", "" + capabilities.getBrowserName() + "_" + capabilities.getVersion());
        desiredCapabilities.setCapability("browserstack.local", "true");
        desiredCapabilities.setCapability("browserstack.debug", "true");
        desiredCapabilities.setCapability("browserstack.consloe", "info");
        desiredCapabilities.setCapability("browserstack.networkLogs", "true");

        System.getProperties().put("https.proxyHost", "35.56.104.42");
        System.getProperties().put("https.proxyHost", "8080");
        System.getProperties().put("http.proxyHost", "35.56.104.42");
        System.getProperties().put("http.proxyHost", "8080");

        return new RemoteWebDriver(new URL(browserstackUrl()), desiredCapabilities);
    }

    private static WebDriver newLocalDriver(Capabilities capabilities) {
        WebDriver driver ;
        if (capabilities.getBrowserName().equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(new FirefoxOptions(capabilities));
            log.info("Firefox browser has been initialised.");
        } else if (capabilities.getBrowserName().equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(new ChromeOptions().merge(capabilities));
            log.info("Chrome browser has been initialised.");
        } else {
            String errorMessage = "Unrecognised browser: {}" + capabilities.getBrowserName();
            log.error(errorMessage);
            throw new IllegalStateException(errorMessage);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
