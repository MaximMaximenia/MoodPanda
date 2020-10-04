package pages;

import com.codeborne.selenide.Condition;
import models.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private static final String ACCOUNT_DROPDOWN = "//li[@id='Settings']";
    private static final String ME_DROPDOWN = "//li[@id='LIMe']";
    private static final String COMMUNITY_DROPDOWN = "//li[@id='LIWorld']";

    private static final String OPTIONS_INTO_DROPDOWN = "//li//a[contains(text(),'%s')]";
    private static final String OPEN_MODAL = "#LinkUpdate";


    public MyUpdatesPage toMyUpdatesPage(){
        $(By.xpath(ME_DROPDOWN)).doubleClick();
        $(By.xpath(String.format(OPTIONS_INTO_DROPDOWN, "My updates"))).click();
        return new MyUpdatesPage();
    }
    public FeedPage toWorldFeedPage(){
        $(By.xpath(COMMUNITY_DROPDOWN)).doubleClick();
        $(By.xpath(String.format(OPTIONS_INTO_DROPDOWN, "World feed"))).waitUntil(Condition.appear,231).click();
        return new FeedPage();
    }
    public MoodModal openMoodModal() {
        $(OPEN_MODAL).shouldBe(Condition.visible).click();
        return new MoodModal();
    }



    public AccountPage toValidationAccount() {
        $(By.xpath(ACCOUNT_DROPDOWN)).doubleClick();
        $(By.xpath(String.format(OPTIONS_INTO_DROPDOWN, "Edit profile"))).waitUntil(Condition.visible,200000).click();
        return new AccountPage();
    }


}
