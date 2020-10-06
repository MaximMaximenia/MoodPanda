package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.modals.*;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class BasePage {

    private static final String ACCOUNT_DROPDOWN = "//li[@id='Settings']";
    private static final String ME_DROPDOWN = "//li[@id='LIMe']";
    private static final String COMMUNITY_DROPDOWN = "//li[@id='LIWorld']";

    private static final String OPTIONS_INTO_DROPDOWN = "//li//a[contains(text(),'%s')]";
    private static final String OPEN_MODAL = "#LinkUpdate";

    @Step("Go to My Updates page")
    public MyUpdatesPage toMyUpdatesPage(){
        log.info("To my updates page");
        $(By.xpath(ME_DROPDOWN)).doubleClick();
        $(By.xpath(String.format(OPTIONS_INTO_DROPDOWN, "My updates"))).click();
        return new MyUpdatesPage();
    }
    @Step("Go to World Feed page")
    public FeedPage toWorldFeedPage(){
        log.info("Go to World Feed page");
        $(By.xpath(COMMUNITY_DROPDOWN)).doubleClick();
        $(By.xpath(String.format(OPTIONS_INTO_DROPDOWN, "World feed"))).waitUntil(Condition.appear,2000).click();
        return new FeedPage();
    }
    @Step("Open Mood Modal")
    public MoodModal openMoodModal() {
        log.info("Open Mood Modal");
        $(OPEN_MODAL).shouldBe(Condition.visible).click();
        return new MoodModal();

    }

    @Step("Go to Edit Profile Page")
    public AccountPage toValidationAccount() {
        log.info("Go to Validation Account ( Edit profile page )");
        $(By.xpath(ACCOUNT_DROPDOWN)).doubleClick();
        $(By.xpath(String.format(OPTIONS_INTO_DROPDOWN, "Edit profile"))).waitUntil(Condition.visible,2000).click();
        return new AccountPage();
    }


}
