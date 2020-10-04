package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MyUpdatesPage extends BasePage {

    private static final String CREATED_MOOD = ".name.pull-left";
    private static final String DELETE_MOOD = ".glyphicon.glyphicon-trash.ButtonDelete";

    public MyUpdatesPage checkAmountMood(int amountCreatedMood) {
        refresh();
        $(CREATED_MOOD).waitUntil(Condition.appear, 2000);
        $$(CREATED_MOOD).shouldHaveSize(amountCreatedMood);
        return this;
    }

    public void deleteMoodAndValidation() {
        refresh();
        List allMood = $$(DELETE_MOOD);
        int size = allMood.size();
        $(DELETE_MOOD).waitUntil(Condition.appear, 2000).click();
        int expectedSize = size - 1;
        Assert.assertEquals(expectedSize,size-1);
    }

    public void deleteAllMood() {
        refresh();
        ElementsCollection allMood = $$(DELETE_MOOD);
        for (int i = 0; i < allMood.size(); i++) {
            allMood.get(i).waitUntil(Condition.appear, 200).click();
        }
        $(DELETE_MOOD).shouldBe(Condition.disappear);
        List moodAfterDelete = $$("#ContentPlaceHolderContent_RepeaterFeed_ButtonDelete_0");
        Assert.assertEquals(moodAfterDelete.size(), 1);
    }

}
