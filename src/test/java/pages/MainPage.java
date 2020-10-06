package pages;

import pages.modals.*;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class MainPage {
    public static final String URL = "https://moodpanda.com/";
    public static final String START_BUTTON = "hidden-height-570.page-scroll";

    @Step("Open page (" + URL + ")")
    public MainPage openPage() {
        log.info("open page by URL: \"" + URL + "\"");
        open(URL);
        return this;
    }

    @Step("Press \"Start\" button")
    public LoginModal pressStart() {
        log.info("Press \"Start\" button");
        $(START_BUTTON).waitUntil(Condition.appear, 200).click();
        return new LoginModal();
    }
}
