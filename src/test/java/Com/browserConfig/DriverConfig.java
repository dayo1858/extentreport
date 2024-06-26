package Com.browserConfig;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

public class DriverConfig {
    private static final Logger log = LoggerFactory.getLogger(DriverConfig.class);

    @Before()
    public void setUpHooks() throws MalformedURLException {
        HookSetting.setDriver(DriverProvider.newDriver(capabilities()));
    }
    @After
    public void tearDown() {
        WebDriver driver = HookSetting.driver();
        log.info("Calling duit on driver ()", driver);
        HookSetting.closeDriver();
    }

    private Capabilities capabilities () {
        return new ChromeOptions();
    }
}
