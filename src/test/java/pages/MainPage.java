package pages;

import com.codeborne.selenide.Condition;
import models.*;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    public static final String URL = "https://moodpanda.com/";
    public static final String START_BUTTON = "//header/div[1]/div[3]/a[1]";

    public MainPage openPage(){
        open(URL);

        return this;
    }

    public LoginModal pressStart(){
        $(By.xpath(START_BUTTON)).waitUntil(Condition.appear,200).click();
        return new LoginModal();
    }
}
