package models;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import other.*;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class CreateAccountModal {

    public static final String XPATH_FOR_INPUTS = "//*[contains(text(),'%s')]/..//div[@class = \"col-lg-12\"]//input";
    public static final String XPATH_FOR_SELECTS = "//*[contains(text(),'%s')]/..//div[@class = \"col-lg-12\"]//select";
    public static final String LOGIN_BUTTON = "[value=\"Login\"]";

    public static final String ERROR_MESSAGE = "#ContentPlaceHolderContent_MessageError";

    @Step("Filling registration field and click \"Login\" ")
    public CreateAccountModal createAccount(Account account) {
        //inputs
        $(By.xpath(String.format(XPATH_FOR_INPUTS, "First Name"))).sendKeys(account.getFirstName());
        $(By.xpath(String.format(XPATH_FOR_INPUTS, "Surname"))).sendKeys(account.getSurNameInitial());
        $(By.xpath(String.format(XPATH_FOR_INPUTS, "Email"))).sendKeys(account.getEmail());
        $(By.xpath(String.format(XPATH_FOR_INPUTS, "Password"))).sendKeys(account.getPassword());
        $(By.xpath(String.format(XPATH_FOR_INPUTS, "Confirm Password"))).sendKeys(account.getPassword());
        //select birthDay
        Select selectBirth = new Select($(By.xpath(String.format(XPATH_FOR_SELECTS, "Year of Birth"))));
        selectBirth.selectByVisibleText(account.getYearBirth());
        //select gender
        Select selectGender = new Select($(By.xpath(String.format(XPATH_FOR_SELECTS, "Gender"))));
        selectGender.selectByVisibleText(account.getGender());


        $(LOGIN_BUTTON).click();
        log.info("create account ");
        return this;

    }

@Step("Check error message")
    public void checkThatErrorMessageAppeared(){
        $(ERROR_MESSAGE).waitUntil(appear,1000).shouldBe(appear);
    }
}
