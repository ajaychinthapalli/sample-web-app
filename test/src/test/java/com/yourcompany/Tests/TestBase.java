package com.yourcompany.Tests;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;



public class TestBase {

    public static String username = System.getenv("SAUCE_USERNAME");
    public static String accesskey = System.getenv("SAUCE_ACCESS_KEY");

    /**
     * JUnit Rule which will mark the Sauce Job as passed/failed when the test succeeds or fails.
     */
    public TestName name = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    protected String sessionId;
    protected WebDriver driver;


    @Before
    public void setUp() {
        //Getting the build name.
        //Using the Jenkins ENV var. You can use your own. If it is not set test will run without a build id.

        MutableCapabilities caps = new ChromeOptions();

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("browserName", "chrome");
        sauceOptions.setCapability("browserVersion", "latest");
        sauceOptions.setCapability("platformName", "windows 10");
        sauceOptions.setCapability("username", username);
        sauceOptions.setCapability("accessKey", accesskey);
        sauceOptions.setCapability("name", name.getMethodName());
        sauceOptions.setCapability("tunnelIdentifier", "github-action-tunnel");


        caps.setCapability("sauce:options", sauceOptions);

        URL remoteUrl = null;

        try {
            String site = "https://@ondemand.us-west-1.saucelabs.com/wd/hub";
            remoteUrl = new URL(site);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new RemoteWebDriver(remoteUrl, caps);

        this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
    }

    @After
    public void tearDown() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("sauce:job-result=true");
        driver.quit();
    }
}
