package objectrepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects extends PageObjects
{


    public LoginPageObjects(AndroidDriver<MobileElement> androidDriver)
    {
     super(androidDriver);

    }


    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/signin_button")
    public MobileElement siginButton;

    @AndroidFindBy(id="uk.co.bbc.bbc_plus:id/register_button")
    public MobileElement registerButton;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='BBC Account' and @index='0']")
    public MobileElement bbcAccount;

    @AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'user-identifier-input') and @index='0']")
    public MobileElement username;

    @AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'password-input') and @index='0']")
    public MobileElement password;

//    @AndroidFindAll(
//            {
//                    @AndroidBy(xpath = "//android.widget.Button[@text='Sign in' and @index='2]"),
//                  //  @AndroidBy(id="submit-button")
//            }
//    )
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'submit-button') and @index='2']")
    public MobileElement signsubmit;


    @AndroidFindBy(xpath = "//android.view.View[@text='Don’t have a BBC account?']")
    public MobileElement bbcaccounthaving;

    @AndroidFindBy(xpath = "//android.view.View[@text='Register now']")
    public MobileElement registernowButton;

}
