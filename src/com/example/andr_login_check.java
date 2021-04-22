package com.example;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class andr_login_check {
    private static final String APP = "/Users/cicilia/Downloads/app.ui-fetchtvprod-debug.apk";
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion","11");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", APP);
        driver = new AndroidDriver(new URL(APPIUM), caps);
    }

    @After
    public void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // check if the sign in link is there - au.com.fetchtv:id/textView_signin
        WebElement signInLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")));
        // click on sign in link
        signInLink.click();

        // enter valid activation code
        // enter valid password
        // tap on OK

        // check if you are signed in - the sign in link is not there




        // print the page source here
        // System.out.println(driver.getPageSource());

        // IF during this test , check if the app crashed
        // the crashed modal - android:id/aerr_close
        // click on close app
    }
}
