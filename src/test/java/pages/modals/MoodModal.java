package pages.modals;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.MyUpdatesPage;

import static com.codeborne.selenide.Selenide.*;
@Log4j2
public class MoodModal {
    private static final String DATE = "//div[contains(text(),'%s')]";
    private static final String DESCRIPTION_INPUT = "[name=\"ctl00$TextBoxUpdateMoodTag\"]";
    private static final String CANCEL_BUTTON = "//button[contains(text(),\"Cancel\")]";
    private static final String UPDATE_BUTTON = "//button[contains(text(),'Update Mood')]";
    private static final String MODAL = ".modal-content";
    private static final String MOOD_SLIDER = ".ui-slider-handle.ui-state-default.ui-corner-all";


    @Step("Select mood 1-10 {youMood}")
    public MoodModal selectMood(int youMood) {
        log.info("Select mood :"+youMood);
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

    @Step("Select date in mood modal")
    public MoodModal selectDate(String date) {
        log.info("select date");
        $(By.xpath(String.format(DATE, date))).click();
        return this;
    }
    @Step("Send description in mood modal")
    public MoodModal sendDescription(String description) {
        log.info("send mood");
        $(DESCRIPTION_INPUT).sendKeys(description);
        return this;
    }
    @Step("Press 'Cancel' button")
    public MoodModal pressCancelButton() {
        log.info("close mood modal");
        $(By.xpath(CANCEL_BUTTON)).click();
        return this;
    }
    @Step("Check that modal was closed")
    public void checkThatModalWasClosed(){
        log.info("check that close modal closed");
        $(MODAL).shouldBe(Condition.disappear);
    }

    @Step("Press 'Update Mood' button")
    public MyUpdatesPage pressUpdateMood() {
        log.info("press update mood");
        $(By.xpath(UPDATE_BUTTON)).click();
        return new MyUpdatesPage();
    }

}
