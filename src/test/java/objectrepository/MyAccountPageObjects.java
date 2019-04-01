package objectrepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyAccountPageObjects extends PageObjects {

    public MyAccountPageObjects(AndroidDriver<MobileElement> androidDriver)
    {
        super(androidDriver);
    }


    @AndroidFindBy(accessibility = "You")
    public MobileElement youButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Likes']")
    public MobileElement likes;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='History']")
    public MobileElement historyButton;

    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/settingsButton")
    public MobileElement settingsButton;

    @AndroidFindBy(accessibility = "Likes")
    public MobileElement likesPage;

    @AndroidFindBy(accessibility = "History")
    public MobileElement historypage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index='0']/android.widget.ImageButton[@index='0']")
    public MobileElement backbutton;

    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/videoImage")
    public MobileElement pictureinpicture;

    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/no_liked_heading")
    public MobileElement nolikeheading;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/no_liked_subheading")
    public MobileElement nolikesubheading;

    public static String nolikesubheadingText = "Your liked clips will appear here.";

    public static String nolikeheadingText="No Likes";

    @AndroidFindBy(id = "uk.co.bbc.bbc_plus:id/no_history_heading")
    public MobileElement nohistoryheading;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/no_history_subheading")
    public MobileElement nohistorysubheading;

    public static String nohistorysubheadingText = "Your recent viewing activity will appear here.";

    public static String nohistoryheadingText="No History";

    public static String signoutmessageText = "Are you sure you want to sign out?";

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign Out']")
    public MobileElement signouttext;

    @AndroidFindBy(accessibility = "Share statistics")
    public MobileElement sharestats;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/switchControl")
    public MobileElement sharestatsButton;

    @AndroidFindBy(id="android:id/message")
    public MobileElement signoutmessage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SIGN OUT']")
    public MobileElement signOutButton;







}
