package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

@Log4j2
public class AccountPage extends BasePage {
    private static final String LOCATOR_FOR_INPUTS = "//label[contains(text(),'%s')]/..//div[@class='col-lg-9']//input";
    private static final String LOCATOR_FOR_SELECT = "//label[contains(text(),'%s')]/..//div[@class='col-lg-9']//select//option[@selected='selected']";

    public void accountPageIsOpen() {
        $(".form-group").isDisplayed();
    }


    @Step("Validation account")
    public void accountValidation(Account account) {

        log.info("Validation account: ");
        log.info("validate surname initial" + account.getFirstName());
        assertEquals($(By.xpath(String.format(LOCATOR_FOR_INPUTS, "First Name"))).getValue(), account.getFirstName());

        log.info("validate surname initial" + account.getSurNameInitial());
        assertEquals($(By.xpath(String.format(LOCATOR_FOR_INPUTS, "Surname"))).getValue(), account.getSurNameInitial());

        log.info("validate email" + account.getEmail());
        assertEquals($(By.xpath(String.format(LOCATOR_FOR_INPUTS, "Email"))).getValue(), account.getEmail());

        log.info("validate gender" + account.getGender());
        assertEquals($(By.xpath(String.format(LOCATOR_FOR_SELECT, "Gender")))

                .getValue(), account.getGender());
        log.info("validate year of birth" + account.getYearBirth());
        assertEquals($(By.xpath(String.format(LOCATOR_FOR_SELECT, "Year of Birth")))
                .getValue(), account.getYearBirth());
    }
}
