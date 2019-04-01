package driverscript;

import commonfunctions.CommonFunctions;
import constant.TestData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainDriver extends CommonFunctions {


    public static DesiredCapabilities desiredCapabilities  = new DesiredCapabilities();
    public static AndroidDriver<MobileElement> androidDriver;


    @BeforeTest
    public static void setUp()
    {

            setDevice();
    }


    public static void setDevice()
    {
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, TestData.deviceID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "miningbee");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "android");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, TestData.appPath);
        desiredCapabilities.setCapability("appPackage", "uk.co.bbc.bbc_plus");
        desiredCapabilities.setCapability("appAcivity", "uk.co.bbc.miningbee.MainActivity");
        try {
            androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterTest
    public static void tearDown()
    {
        try
        {
            if(androidDriver!=null) {
                androidDriver.removeApp("uk.co.bbc.bbc_plus");
                androidDriver.quit();
            }
        }catch (Exception e)
        {e.printStackTrace();}
    }
}
