package driverscript;

import constant.TestData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import objectrepository.DiscoveryPageObjects;
import objectrepository.HomePageObjects;
import objectrepository.LoginPageObjects;
import objectrepository.MyAccountPageObjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MiningBeeTest extends MainDriver {



    LoginPageObjects loginPageObjects;
    HomePageObjects homePageObjects;
    DiscoveryPageObjects discoveryPageObjects;
    MyAccountPageObjects myAccountPageObjects;

    List<MobileElement> topicList;
    List<MobileElement> youOptions;
    List<MobileElement> videolikes;
    int topicsSize;

    ArrayList<String> searchResulttext = new ArrayList<String>();
    ArrayList<String> likesresult = new ArrayList<String>();
    ArrayList<String> historyresult = new ArrayList<String>();


    public  void intialiseObjects()
    {
        try {
            loginPageObjects = new LoginPageObjects(androidDriver);
            homePageObjects = new HomePageObjects(androidDriver);
            discoveryPageObjects = new DiscoveryPageObjects(androidDriver);
            myAccountPageObjects = new MyAccountPageObjects(androidDriver);
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    @Test(priority = 0)
    public void testSignInMiningBee()
    {
        intialiseObjects();
        clickButton(loginPageObjects.siginButton);
    }

    @Test(priority = 1, description = "sign in to the mining bee apps by entering valid credentials")
    public void testEnterSignInCredentials()
    {
        enterText(loginPageObjects.username, TestData.userName);
        enterText(loginPageObjects.password,TestData.passWord);
        clickButton(loginPageObjects.signsubmit);

    }

    @Test(priority = 2, description = "check whether discover, you and watch sub menus are displayed")
    public void testCheckMenuItems() throws InterruptedException {
        elementDisplayed(homePageObjects.discover);
        elementDisplayed(homePageObjects.myaccount);
        elementDisplayed(homePageObjects.watch);
        Thread.sleep(2000);
        Assert.assertEquals("Watch now",homePageObjects.watchnowText.getText(), "Text Matched");
        List<MobileElement> votd = androidDriver.findElements(By.xpath("//android.widget.HorizontalScrollView[@index='1']/android.widget.LinearLayout[@index='0']/android.view.ViewGroup"));
        System.out.println("the number of VOTD :- " + votd.size());
        verifyElement(androidDriver,homePageObjects.votdscroll,homePageObjects.videoofthedayscroll);


    }

    @Test(priority = 3, description = "checks how many topics are displayed on the discover page")
    public void testCheckDiscover() throws InterruptedException
    {
        clickButton(homePageObjects.discover);
        elementDisplayed(discoveryPageObjects.searchField);
        Assert.assertEquals(TestData.titleText, discoveryPageObjects.titleText.getText(), "Text Matched");
        /*
           gets the count of topics displayed on the discover page
         */
        topicList = androidDriver.findElements(By.xpath("//android.view.ViewGroup[@index='1']/android.widget.FrameLayout"));
                //androidDriver.findElements(By.id("uk.co.bbc.bbc_plus:id/title"));
        topicsSize = topicList.size();
        Assert.assertEquals(8,topicsSize,"Matched");
        Thread.sleep(1000);

    }

    @Test(priority = 4, description = "selects each topics from the discover page")
    public void testSelectTopicsFromDiscoverPage()
    {

        for(int i=0;i<topicsSize && i<TestData.topicsText.length;i++)
        {
            clickButton(androidDriver.findElement(By.xpath("//android.view.ViewGroup[@index='1']/android.widget.FrameLayout[@index='"+i+"']")));
            Assert.assertEquals(TestData.topicsText[i],discoveryPageObjects.topicspageTitle.getAttribute("content-desc"));
            pressBack(androidDriver);
        }

    }

    @Test(priority = 5, description = "check whether You title is displayed and also checks whether Like , History options and setting are displayed")
    public void testCheckMyAccount()
    {
        clickButton(myAccountPageObjects.youButton);
        androidDriver.findElementByAccessibilityId("You").isDisplayed();
        /*
            gets the count of options displayed, i.e likes and history
         */
        youOptions = androidDriver.findElements(By.id("uk.co.bbc.bbc_plus:id/label"));
        int optionSize = youOptions.size();
        System.out.println("The number of options :- " + optionSize);
        Assert.assertEquals("Likes",youOptions.get(0).getText());
        Assert.assertEquals("History",youOptions.get(1).getText());
        elementDisplayed(myAccountPageObjects.settingsButton);

    }

    @Test(priority = 6, description = "checks the likes page")
    public void testCheckLikesPage() {
        clickButton(myAccountPageObjects.likes);
        Assert.assertEquals("Likes", myAccountPageObjects.likesPage.getAttribute("content-desc"), "Text Matched");
        Assert.assertEquals(myAccountPageObjects.nolikeheading.getText(), MyAccountPageObjects.nolikeheadingText, "Text Matched");
        Assert.assertEquals(myAccountPageObjects.nolikesubheading.getText(), MyAccountPageObjects.nolikesubheadingText, "Text Matched");
        pressBack(androidDriver);
    }


    @Test(priority = 8, description = "Test to search for a Topics 'news' and navigating to top 3 search result and clicking on like button and clearing search result")
    public void testperformSearchOnDiscoveryPage()
    {
        clickButton(homePageObjects.discover);
        clickButton(discoveryPageObjects.searchField);
        enterText(discoveryPageObjects.searchField, "news");
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        /*
            gets the count of search result visible on the screen
         */
        List<MobileElement> searchresults = androidDriver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='0']/android.view.ViewGroup"));
        System.out.println("the number of search results visible are :- " + searchresults.size());

        for(int i=0;i<3;i++)
        {
            /*
               gets the title and subject of the search items
             */
            MobileElement title = androidDriver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='"+i+"']/android.widget.TextView[@index='1']"));
            searchResulttext.add(title.getText());
            MobileElement subject = androidDriver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='"+i+"']/android.widget.TextView[@index='2']"));
            searchResulttext.add(subject.getText());


            /*
              clicks on top 3 search results
             */
            clickButton(androidDriver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='"+i+"']")));
            elementDisplayed(discoveryPageObjects.closebutton);

            Assert.assertEquals(title.getText(),discoveryPageObjects.videoTitle.getText(),"Text Matched");
            Assert.assertEquals(subject.getText(),discoveryPageObjects.primarySubject.getText(),"Text Matched");

            for(int j=0;j<HomePageObjects.smpControls.length;j++)
            {
                Assert.assertTrue(isElementPresent(androidDriver,By.id(HomePageObjects.smpControls[j])));
            }
           /*
               clicks on Like button and closes the screen
            */
            clickButton(discoveryPageObjects.likebutton);
            clickButton(discoveryPageObjects.closebutton);

        }

        androidDriver.hideKeyboard();
        /*
        un-comment if you want to have scenario running app in background
         */
      //  androidDriver.runAppInBackground(Duration.ofSeconds(20));
        androidDriver.currentActivity();
    }



    @Test(priority = 9, description = "checks the number of items displayed on likes page")
    public void testCheckLikesVideo()
    {
        clickButton(homePageObjects.myaccount);
        clickButton(myAccountPageObjects.likes);
        pressBack(androidDriver);
        clickButton(homePageObjects.myaccount);
        clickButton(myAccountPageObjects.likes);
        videolikes = androidDriver.findElements(By.xpath("//android.view.ViewGroup"));
        System.out.println("the number of likes are :- " + videolikes.size());
        for(int i=0;i<3;i++)
        {
            MobileElement title = androidDriver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='"+i+"']/android.widget.TextView[@index='1']"));
            likesresult.add(title.getText());
            MobileElement subject = androidDriver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='"+i+"']/android.widget.TextView[@index='2']"));
            likesresult.add(subject.getText());
        }
            for(int i=0;i<likesresult.size();i++)
            {
                System.out.println("The Like values are :- " + likesresult.get(i));

            }

            for(int j=0;j<searchResulttext.size();j++)
            {
                System.out.println("The search values are :- " + searchResulttext.get(j));
            }

    }

    @Test(priority = 10, description = "Un likes two videos displayed under likes page")
    public void testUnLikeVideos()
    {
        videolikes = androidDriver.findElements(By.xpath("//android.view.ViewGroup"));
        for(int i=0;i<2;i++)
        {
            clickButton(androidDriver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='"+i+"']")));
            clickButton(discoveryPageObjects.likebutton);
            clickButton(discoveryPageObjects.closebutton);
        }

    }

    @Test(priority = 11, description = "playing a video from likes page and navigate back to see whether Picture in Picture displayed and unlike the video")
    public void testPictureInPicture()
    {
        clickButton(androidDriver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@index='0']/android.view.ViewGroup[@index='0']")));
        pressBack(androidDriver);
        Assert.assertTrue(elementDisplayed(homePageObjects.pipbutton));
        clickButton(homePageObjects.discover);
        Assert.assertTrue(elementDisplayed(homePageObjects.pipbutton));
        clickButton(homePageObjects.pipbutton);
        clickButton(discoveryPageObjects.likebutton);
        clickButton(discoveryPageObjects.closebutton);

    }

    @Test(priority = 12, description = "click on settings and turning off the share stats ")
    public void testTurningOFFShareStats()
    {
        clickButton(homePageObjects.myaccount);
        clickButton(myAccountPageObjects.settingsButton);
        Assert.assertTrue(elementDisplayed(myAccountPageObjects.signouttext));
        Assert.assertTrue(elementDisplayed(myAccountPageObjects.sharestats));
        clickButton(myAccountPageObjects.sharestats);
        Assert.assertEquals("OFF", myAccountPageObjects.sharestats.getText());
        pressBack(androidDriver);

    }


    @Test(priority = 13, description = "click on settings and turning on the share stats ")
    public void testTurningONShareStats()
    {
        clickButton(homePageObjects.myaccount);
        clickButton(myAccountPageObjects.settingsButton);
        clickButton(myAccountPageObjects.sharestats);
        Assert.assertEquals("ON", myAccountPageObjects.sharestats.getText());
      //  Assert.assertEquals(true, myAccountPageObjects.sharestats.getAttribute("checked"));
        System.out.println("the value :- is " + myAccountPageObjects.sharestats.getAttribute("checked"));
        pressBack(androidDriver);

    }

    @Test(priority = 14, description = "checks the History page")
    public void testHistoryPage()
    {
        clickButton(myAccountPageObjects.historyButton);
        Assert.assertFalse(elementDisplayed(myAccountPageObjects.nohistoryheading));
        Assert.assertFalse(elementDisplayed(myAccountPageObjects.nohistorysubheading));
        pressBack(androidDriver);
    }

    @Test(priority = 15, description = "click on settings and sign out from app ")
    public void testSignOutFromApp()
    {
        clickButton(myAccountPageObjects.settingsButton);
        clickButton(myAccountPageObjects.signouttext);
        Assert.assertEquals(MyAccountPageObjects.signoutmessageText,myAccountPageObjects.signoutmessage.getText());
        clickButton(myAccountPageObjects.signOutButton);

    }
}
