package objectrepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.How;

public class HomePageObjects extends PageObjects {

    public HomePageObjects(AndroidDriver<MobileElement> androidDriver)
    {
        super(androidDriver);
    }


    @AndroidFindBy(accessibility = "You")
    public MobileElement myaccount;

    @AndroidFindBy(accessibility = "Discover")
    public MobileElement discover;

    @AndroidFindBy(accessibility = "Watch")
    public MobileElement watch;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Watch now']")
    public MobileElement watchnowText;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@index='5']/android.widget.TextView[@index='2']")
    public MobileElement votdscroll;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/scrollingItemHolder")
    public MobileElement videoofthedayscroll;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/mediaDurationView")
    public MobileElement videoduration;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/titleTextView")
    public MobileElement videotitle;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/smp_pause_button")
    public MobileElement smpPauseButtonl;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/smp_volume_button")
    public MobileElement smpVolumeButton;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/smp_fullscreen_button")
    public MobileElement smpFullScreenButton;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/smp_seek_bar")
    public  MobileElement smpSeekBar;

    public static String[] smpControls = {
                "uk.co.bbc.bbc_plus:id/smp_pause_button",
                "uk.co.bbc.bbc_plus:id/smp_volume_button",
                "uk.co.bbc.bbc_plus:id/smp_fullscreen_button",
                "uk.co.bbc.bbc_plus:id/smp_seek_bar"
    };

    @AndroidFindBy(accessibility = "Player")
    public MobileElement pipbutton;



}
