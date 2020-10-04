package models;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Log4j2
public class LoginModal {
    public static final String EMAIL_INPUT = "//*[contains(text(),'email')]/..//div[@class = \"col-lg-12\"]//input";
    public static final String PASSWORD_INPUT = "//*[contains(text(),'Password')]/..//div[@class = \"col-lg-12\"]//input";
    public static final String LOGIN_BUTTON = "[value='Login']";
    public static final String ERROR_MESSAGE = "#ContentPlaceHolderContent_MessageError";

    public static final String TEXT_FOR_CREATE_ACCOUNT_BUTTON = "Create Account";
@Step("Login")
    public FeedPage login(String email, String password) {
        $(By.xpath(EMAIL_INPUT)).waitUntil(Condition.appear,2132).click();
        $(By.xpath(EMAIL_INPUT)).sendKeys(email);
        $(By.xpath(PASSWORD_INPUT)).click();
        $(By.xpath(PASSWORD_INPUT)).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return new FeedPage();
    }
    @Step("Failed Login")
    public LoginModal failedLogin(String email, String password) {
        Assert.assertTrue($$(ERROR_MESSAGE).isEmpty());
        $(By.xpath(EMAIL_INPUT)).sendKeys(email);
        $(By.xpath(PASSWORD_INPUT)).sendKeys(password);
        $(LOGIN_BUTTON).click();
        return this;
    }
    @Step("Check error message")
    public void errorMessageShouldBe(String errorMessage){
    log.info("check that error message coincide");
    Assert.assertEquals($(ERROR_MESSAGE).should(Condition.appear).getText(),errorMessage,"Неверное сообщение об ошибке.");

    }
    @Step("Press \"Create Account \" button")
    public CreateAccountModal pressCreateNewAccount() {

        $(byText(TEXT_FOR_CREATE_ACCOUNT_BUTTON)).click();
        log.info("click create account button");
        return new CreateAccountModal();
    }

}
