package tests;

import org.testng.annotations.Test;
import pages.FeedPage;

public class MoodModalTest extends BaseTest {
    @Test
    public void closeMoodModalTest() {
        mainSteps
                .login("maxigh@mail.sd", "2222222");

        feedPage.toMyUpdatesPage()
                .openMoodModal()
                .pressCancelButton()
                .checkThatModalWasClosed();

    }

    @Test
    public void createMoodTest() {
        mainSteps
                .login("maxigh@mail.sd", "2222222");

        feedSteps
                .createMood(2, "ALL IT S HARD ", "Now");
        myUpdatesPage
                .checkAmountMood(1)
                .clear();
    }

    @Test
    public void deleteMoodTest() {
        mainSteps
                .login("maxigh@mail.sd", "2222222");

        feedSteps
                .createMood(2, "ALL IT S HARD ", "Now");
        myUpdatesPage
                .deleteMoodAndValidation()
                .clear();
    }


}
