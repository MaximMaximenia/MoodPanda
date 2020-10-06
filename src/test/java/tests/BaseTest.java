package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import other.TestListener;
import pages.FeedPage;
import pages.MainPage;
import pages.MyUpdatesPage;
import steps.FeedSteps;
import steps.MainSteps;
import pages.modals.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    MainSteps mainSteps;
    FeedSteps feedSteps;

    FeedPage feedPage;
    MainPage mainPage;
    MoodModal moodModal;
    MyUpdatesPage myUpdatesPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        mainSteps = new MainSteps();
        feedSteps = new FeedSteps();

        feedPage = new FeedPage();
        mainPage = new MainPage();
        myUpdatesPage = new MyUpdatesPage();
        moodModal = new MoodModal();


    }

    @AfterMethod
    public void closeBrowser() {
        getWebDriver().quit();

    }
}

