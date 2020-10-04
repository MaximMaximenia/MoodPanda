package steps;

import pages.FeedPage;

public class FeedSteps {
    FeedPage feedPage = new FeedPage();
    public void createMood(int youMood,String description,String date){
        feedPage .toMyUpdatesPage()
                .openMoodModal()
                .selectMood(youMood)
                .sendDescription(description)
                .selectDate(date)
                .pressUpdateMood();
    }
}
