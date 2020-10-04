package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class FeedPage extends BasePage {

    private static final String SKIP_REGISTRATION_MESSAGE = "//button[@class='btn btn-sm btn-primary ButtonUpdateWelcome']";
    private static final String HUG_BUTTON = ".ButtonHug";
    private static final String HUG_AMOUNT = "//span[@class='ButtonHug']//span[2]";
    private static final String ALL_PERSON = "//div[contains(@class,\"rounded-top-corner\")]";
    //div[contains(@class,"rounded-top-corner")]//span[@class='ButtonHug']//span[2]
@Step("Check that Feed Page is Open")
    public FeedPage feedPageIsOpen() {
        Assert.assertEquals(getWebDriver().getCurrentUrl(),"https://moodpanda.com/Feed/");
        return this;
    }
    @Step("Skip registration message with select mood")
    public FeedPage skipRegistrationMessage() {
log.info("skip registration message 1");
        $(By.xpath(SKIP_REGISTRATION_MESSAGE)).click();
        sleep(1000);
        log.info("skip registration message 2");
        $(By.xpath(SKIP_REGISTRATION_MESSAGE)).click();
        sleep(1000);
        log.info("skip registration message 3");
        $(By.xpath(SKIP_REGISTRATION_MESSAGE)).click();

        return this;
    }

    @Step("Initialize all person in World Page")
    public ElementsCollection initializeAllPerson() {
        $(By.xpath(ALL_PERSON)).waitUntil(Condition.appear, 222);
        ElementsCollection allPerson = $$(By.xpath(ALL_PERSON));
        log.info("write all person in element collection");
        return allPerson;
    }

    @Step("Hug person by index and validate this")
    public void hugByIntAndValidation(int personIndex) {
        ElementsCollection allPerson = initializeAllPerson();
        WebElement person = allPerson.get(personIndex);

        String before = person.findElement(By.xpath(HUG_AMOUNT)).getText();

        allPerson.get(personIndex).$(HUG_BUTTON).click();
        sleep(2000);
        String after = person.findElement(By.xpath(HUG_AMOUNT)).getText();
        sleep(2000);
        Assert.assertNotSame(after, before);
    }

}
