package objectrepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DiscoveryPageObjects  extends  PageObjects{

    public  DiscoveryPageObjects(AndroidDriver<MobileElement> androidDriver)
    {
        super(androidDriver);

    }

    @AndroidFindBy(id = "android:id/search_src_text")
    public MobileElement searchField;


    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/titleView")
    public MobileElement titleText;

    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/title")
    public MobileElement topicsTitle;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0']/android.widget.ImageButton[@index='0']")
    public MobileElement backButton;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/collapsingToolbar")
    public MobileElement topicspageTitle;

    @AndroidFindBy(accessibility = "Clear query")
    public MobileElement clearSearch;

    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/videoTitle")
    public MobileElement videoTitle;

    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/primarySubject")
    public  MobileElement primarySubject;

    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/likeAnimatedButton")
    public  MobileElement likebutton;

    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/closeButton")
    public MobileElement closebutton;




}
