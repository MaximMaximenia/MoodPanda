package models;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.MyUpdatesPage;

import static com.codeborne.selenide.Selenide.*;

public class MoodModal {
    private static final String DATE = "//div[contains(text(),'%s')]";
    private static final String DESCRIPTION_INPUT = "[name=\"ctl00$TextBoxUpdateMoodTag\"]";
    private static final String CANCEL_BUTTON = "//button[contains(text(),\"Cancel\")]";
    private static final String UPDATE_BUTTON = "//button[contains(text(),'Update Mood')]";
    private static final String MODAL = ".modal-content";
    private static final String MOOD_SLIDER = ".ui-slider-handle.ui-state-default.ui-corner-all";



    public MoodModal selectMood(int youMood) {
        $(MOOD_SLIDER).click();
        int defaultMood = 5;
        int amountLeftOrRight;
        if (youMood > defaultMood) {
            amountLeftOrRight = youMood - defaultMood;
            for (int i = 0; i < amountLeftOrRight ; i++) {
                sleep(1000);
                $(MOOD_SLIDER).sendKeys(Keys.ARROW_RIGHT);
            }
        } else if (youMood < defaultMood) {
            amountLeftOrRight = defaultMood - youMood;
            for (int i = 0; i < amountLeftOrRight ; i++) {
                $(MOOD_SLIDER).sendKeys(Keys.ARROW_LEFT);
            }
        }
return this;
    }


    public MoodModal selectDate(String date) {
        $(By.xpath(String.format(DATE, date))).click();
        return this;
    }

    public MoodModal sendDescription(String description) {
        $(DESCRIPTION_INPUT).sendKeys(description);
        return this;
    }

    public MoodModal pressCancelButton() {
        $(By.xpath(CANCEL_BUTTON)).click();
        return this;
    }
    public void checkThatModalWasClosed(){
        $(MODAL).shouldBe(Condition.disappear);
    }

    public MyUpdatesPage pressUpdateMood() {
        $(By.xpath(UPDATE_BUTTON)).click();
        return new MyUpdatesPage();
    }

}
