package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class MyUpdatesPage extends BasePage {

    private static final String CREATED_MOOD = ".name.pull-left";
    private static final String DELETE_MOOD = ".ButtonDelete";
    private static final String FOR_ALL_GET_MOOD = "#ContentPlaceHolderContent_RepeaterFeed_ButtonDelete_0";

    @Step("Check amount mood")
    public MyUpdatesPage checkAmountMood(int amountCreatedMood) {
        refresh();
        $(CREATED_MOOD).waitUntil(Condition.appear, 2000);
        $$(CREATED_MOOD).shouldHaveSize(amountCreatedMood);
        return this;
    }

    @Step("Delete Mood and Validation this")
    public MyUpdatesPage deleteMoodAndValidation() {
        refresh();
        ElementsCollection allMood = $$(DELETE_MOOD);
        int size = allMood.size();
        $(DELETE_MOOD).waitUntil(Condition.appear, 2000).click();
        int expectedSize = size - 1;
        Assert.assertEquals(expectedSize, size - 1);
        return this;
    }

    @Step("Delete all mood")
    public void clear() {
        refresh();
        ElementsCollection allMood = $$(DELETE_MOOD);
        log.info("Delete all mood ( size before:" + allMood.size() + ")");
        for (SelenideElement selenideElement : allMood) {
            selenideElement.waitUntil(Condition.appear, 200).click();
        }
        $(DELETE_MOOD).shouldBe(Condition.disappear);
        ElementsCollection moodAfterDelete = $$(FOR_ALL_GET_MOOD);

        Assert.assertEquals(moodAfterDelete.size(), 1);
    }

}
