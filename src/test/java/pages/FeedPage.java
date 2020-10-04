package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class FeedPage extends BasePage {

    private static final String SKIP_REGISTRATION_MESSAGE = "//button[@class='btn btn-sm btn-primary ButtonUpdateWelcome']";
    private static final String HUG_BUTTON = ".ButtonHug";
    private static final String HUG_AMOUNT = "//span[@class='ButtonHug']//span[2]";
    private static final String ALL_PERSON = "//div[contains(@class,\"rounded-top-corner\")]";
    //div[contains(@class,"rounded-top-corner")]//span[@class='ButtonHug']//span[2]

    public FeedPage feedPageIsOpen() {
        $(By.xpath("//a[contains(text(),'Control my privacy')]")).waitUntil(Condition.appear,20).isDisplayed();
        return this;
    }

    public FeedPage skipRegistrationMessage() {

        $(By.xpath(SKIP_REGISTRATION_MESSAGE)).click();
        sleep(1000);
        $(By.xpath(SKIP_REGISTRATION_MESSAGE)).click();
        sleep(1000);
        $(By.xpath(SKIP_REGISTRATION_MESSAGE)).click();

        return this;
    }

    public ElementsCollection initializeAllPerson() {
        $(By.xpath(ALL_PERSON)).waitUntil(Condition.appear, 222);
        ElementsCollection allPerson = $$(By.xpath(ALL_PERSON));
        return allPerson;
    }


    public FeedPage hugByIntAndValidation(int personIndex) {
        ElementsCollection allPerson = initializeAllPerson();
        WebElement person = allPerson.get(personIndex);

        String before = person.findElement(By.xpath(HUG_AMOUNT)).getText();

        allPerson.get(personIndex).$(HUG_BUTTON).click();
        sleep(10000);
        String after = person.findElement(By.xpath(HUG_AMOUNT)).getText();
        sleep(10000);
        Assert.assertTrue(after != before);
        return this;
    }

}
