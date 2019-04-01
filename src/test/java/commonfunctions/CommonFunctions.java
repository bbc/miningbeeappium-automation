package commonfunctions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonFunctions {


    public  void clickButton(MobileElement element)
    {

        element.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void enterText(MobileElement element, String text)
    {

        element.sendKeys(text);
    }


    public boolean elementDisplayed(MobileElement element)
    {
        try
        {
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException e)
        {
            return false;
        }

    }

    public void pressBack(AndroidDriver<MobileElement> androidDriver)
    {
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));

    }


//    public void horizontalSwipe(AndroidDriver<MobileElement> androidDriver)
//    {
//        Dimension dimension = androidDriver.manage().window().getSize();
//
//        int height = dimension.getHeight();
//        int width = dimension.getWidth();
//        int y = (int)(height*0.55);
//        System.out.println("the Y values :-" + y);
//        int startX = (int)(width*0.75);
//        System.out.println("the Startx values :-" + startX);
//        int endX = (int)(width*0.30);
//        System.out.println("the endX values :-" + endX);
//
//        TouchAction action = new TouchAction(androidDriver);
//        action.press(PointOption.point(startX,y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(endX,y));
//
//
//
//    }

    public void HorizontalSwipe(AndroidDriver<MobileElement> androidDriver, MobileElement swipeElement)
    {
      //  MobileElement swipeElement = androidDriver.findElement(By.id("uk.co.bbc.bbc_plus:id/scrollingItemHolder"));

        int StartX = swipeElement.getLocation().getX();
        int startingX = (int)(StartX*0.75);
        System.out.println("Startx :" + startingX);

        int EndX = swipeElement.getSize().getWidth();
        int endingX = (int)(EndX*0.55);
        System.out.println("endX :" + endingX);

        int yAxis = swipeElement.getLocation().getY();
        System.out.println("yAxis :" + yAxis);


        TouchAction action = new TouchAction(androidDriver);
        action.press(PointOption.point(endingX, yAxis))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(startingX, yAxis)).release().perform();


    }


    public void getTitelAndDuration(AndroidDriver<MobileElement> androidDriver , int position)
    {
        MobileElement title = androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='"+position+"']/android.widget.TextView[@index='2'])"));
        System.out.println("the title is:-"+title.getText());
        MobileElement duration = androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='"+position+"']/android.widget.TextView[@index='1'])"));
        System.out.println("the duration is:-"+duration.getText());
    }


    public void verifyElement(AndroidDriver<MobileElement> androidDriver, MobileElement element, MobileElement swipeElement)
    {

        boolean found = false;
        for(int i=0;i<=10;i++) {
            try {
                element.isDisplayed();
                found=true;
                break;
            } catch (Exception e) {
                HorizontalSwipe(androidDriver,swipeElement);
            }
        }
        if(found)
        {
            System.out.println("element present");
        } else
        {
            System.out.println("element not found");
        }
    }


    /**
     * Function to check whether an Element is present or not
     */

    public static boolean isElementPresent(AppiumDriver<MobileElement> appiumDriver, By locatorKey) {
        try {
            appiumDriver.findElement(locatorKey);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
