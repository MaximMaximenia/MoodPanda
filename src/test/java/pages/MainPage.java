package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.*;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
@Log4j2
public class MainPage {
    public static final String URL = "https://moodpanda.com/";
    public static final String START_BUTTON = "//header/div[1]/div[3]/a[1]";
    @Step("Open page ("+URL+")")
    public MainPage openPage(){
        open(URL);
log.info("open page by URL");
        return this;
    }
    @Step("Press \"Start\" button")
    public LoginModal pressStart(){
        $(By.xpath(START_BUTTON)).waitUntil(Condition.appear,200).click();
        return new LoginModal();
    }
}
