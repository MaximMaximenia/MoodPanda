package models;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginModal {
    public static final String EMAIL_INPUT = "//*[contains(text(),'email')]/..//div[@class = \"col-lg-12\"]//input";
    public static final String PASSWORD_INPUT = "//*[contains(text(),'Password')]/..//div[@class = \"col-lg-12\"]//input";
    public static final String LOGIN_BUTTON = "[value='Login']";
    public static final String ERROR_MESSAGE = "#ContentPlaceHolderContent_MessageError";

    public static final String TEXT_FOR_CREATE_ACCOUNT_BUTTON = "Create Account";

    public FeedPage login(String email, String password) {
        $(By.xpath(EMAIL_INPUT)).waitUntil(Condition.appear,2132).click();
        $(By.xpath(EMAIL_INPUT)).sendKeys(email);
        $(By.xpath(PASSWORD_INPUT)).click();
        $(By.xpath(PASSWORD_INPUT)).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return new FeedPage();
    }
    public LoginModal failedLogin(String email, String password) {
        Assert.assertTrue($$(ERROR_MESSAGE).isEmpty());
        $(By.xpath(EMAIL_INPUT)).sendKeys(email);
        $(By.xpath(PASSWORD_INPUT)).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return this;
    }
    public void errorMessageShouldBe(String errorMessage){

        Assert.assertEquals($(ERROR_MESSAGE).should(Condition.appear).getText(),errorMessage,"Неверное сообщение об ошибке.");
    }

    public CreateAccountModal pressCreateNewAccount() {
        $(byText(TEXT_FOR_CREATE_ACCOUNT_BUTTON)).click();
        return new CreateAccountModal();
    }

}
