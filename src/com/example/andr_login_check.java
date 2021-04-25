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

    // constant
    private static String activatioCode = "en735ppvgy";
    private static String pin = "0000";

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion","9");
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

        // check Sign In link exists
        // xpath '/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]'
        WebElement signInLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")));
        // click on sign in link
        signInLink.click();
        System.out.println("Sign In text: " + signInLink.getText());

        // check Sign In modal exists - au.com.fetchtv:id/textview_title
        WebElement signInModalLabel = wait.until(ExpectedConditions.presenceOfElementLocated(
                MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView")));
        System.out.println("Sign In text label: " + signInModalLabel.getText());

        // find activation code field and enter valid activation code - au.com.fetchtv:id/activationCodeEditTxt
        WebElement activationCodeField = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.EditText");
        System.out.println("Activation Field Text: " + activationCodeField.getText());
        activationCodeField.sendKeys(activatioCode);
        // find and click Next button - au.com.fetchtv:id/button_activate
        WebElement nextButton = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
        System.out.println("Button Text: " + nextButton.getText());
        nextButton.click();

        // find enter PIN modal - au.com.fetchtv:id/textview_title
        WebElement pinModalLabel = wait.until(ExpectedConditions.presenceOfElementLocated(
                MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")));
        System.out.println("PIN Modal Label Text: " + pinModalLabel.getText());
        // find and enter invalid PIN - au.com.fetchtv:id/master_edit_pin, au.com.fetchtv:id/pinInputEditText
        WebElement pinField = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText");
        pinField.sendKeys(pin);
        // at this point, the modal would go to the next step

        // check T&C modal exists - au.com.fetchtv:id/actionBarTitle
        WebElement termsModalLabel = wait.until(ExpectedConditions.presenceOfElementLocated(
                MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")));
        System.out.println("T&C Modal Label Text: " + termsModalLabel.getText());
        // find and click Accept button - au.com.fetchtv:id/button_accept_tandcs
        WebElement acceptButton = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button");
        System.out.println("Accept Button Text: " + acceptButton.getText());
        acceptButton.click();


        // check On boarding modal exists
        // xpath '/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout'
        WebElement onBoardingModal = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout")));
        WebElement onBoardingText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView");
        System.out.println("OnBoarding Remote Text: " + onBoardingText.getText());
        // find Next button and click - au.com.fetchtv:id/onBoardingButtonGrey
        WebElement onBoardingNextButton = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button");
        onBoardingNextButton.click();

        // check on the next On boarding and go next again
        wait.until(ExpectedConditions.visibilityOf(onBoardingModal));
        System.out.println("OnBoarding Multiroom Text: " + onBoardingText.getText());
        onBoardingNextButton.click();

        // check Sign In state - remote icon exists
        WebElement remoteIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
                MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.ImageView[2]")));
        System.out.println("You are Signed In!");
        // end test
        System.out.println("End Test");
    }
}
