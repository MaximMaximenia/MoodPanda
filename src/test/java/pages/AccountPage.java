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
    private static final String ACCOUNT_PAGE_IS_OPEN = ".form-group";

    public void accountPageIsOpen() {
        $(ACCOUNT_PAGE_IS_OPEN).isDisplayed();
    }


    @Step("Validation account")
    public void accountValidation(Account account) {

        log.info("Validation account: " + account.toString());

        assertEquals($(By.xpath(String.format(LOCATOR_FOR_INPUTS, "First Name", "FIRST NAME NOT MATCH"))).getValue(), account.getFirstName());

        assertEquals($(By.xpath(String.format(LOCATOR_FOR_INPUTS, "Surname", "SURNAME NOT MATCH"))).getValue(), account.getSurNameInitial());

        assertEquals($(By.xpath(String.format(LOCATOR_FOR_INPUTS, "Email", "EMAIL NOT MATCH"))).getValue(), account.getEmail());

        assertEquals($(By.xpath(String.format(LOCATOR_FOR_SELECT, "Gender", "GENDER NOT MATCH")))
                .getValue(), account.getGender());

        assertEquals($(By.xpath(String.format(LOCATOR_FOR_SELECT, "Year of Birth", "YEAR OF BIRTH NOT MATCH")))
                .getValue(), account.getYearBirth());
    }
}
