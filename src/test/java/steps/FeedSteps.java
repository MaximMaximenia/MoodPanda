package steps;

import io.qameta.allure.Step;
import pages.*;

public class FeedSteps {
    FeedPage feedPage = new FeedPage();

    @Step("Create Mood")
    public void createMood(int youMood,String description,String date){
        feedPage.toMyUpdatesPage()
                .openMoodModal()
                .selectMood(youMood)
                .sendDescription(description)
                .selectDate(date)
                .pressUpdateMood();
    }
}
