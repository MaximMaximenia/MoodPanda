package pages;
import org.openqa.selenium.By;
import org.testng.Assert;
import other.*;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage{
    private static final String LOCATOR_FOR_INPUTS = "//label[contains(text(),'%s')]/..//div[@class='col-lg-9']//input";
    private static final String LOCATOR_FOR_SELECT = "//label[contains(text(),'%s')]/..//div[@class='col-lg-9']//select//option[@selected='selected']";

    public void accountPageIsOpen() {
        $(".form-group").isDisplayed();
    }

    public void accountValidation(Account account) {

        Assert.assertEquals($(By.xpath(String.format(LOCATOR_FOR_INPUTS, "First Name"))).getValue(), account.getFirstName());
        Assert.assertEquals($(By.xpath(String.format(LOCATOR_FOR_INPUTS, "Surname"))).getValue(), account.getSurNameInitial());
        Assert.assertEquals($(By.xpath(String.format(LOCATOR_FOR_INPUTS, "Email"))).getValue(), account.getEmail());

        Assert.assertEquals($(By.xpath(String.format(LOCATOR_FOR_SELECT, "Gender")))
                .getValue(), account.getGender());
        Assert.assertEquals($(By.xpath(String.format(LOCATOR_FOR_SELECT, "Year of Birth")))
                .getValue(), account.getYearBirth());


    }
}
