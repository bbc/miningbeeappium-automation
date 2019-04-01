package objectrepository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PageObjects
{

    AppiumDriver<MobileElement> appiumDriver;
    public PageObjects(AppiumDriver<MobileElement> appiumDriver)
    {
        this.appiumDriver=appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}

