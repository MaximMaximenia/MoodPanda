package tests;

import com.codeborne.selenide.ex.ElementNotFound;
import org.testng.annotations.Test;
import models.Account;

import java.util.Random;

public class CreateAccountTest extends BaseTest {
    Random random = new Random();
    String typicalError = "Error: Please complete all fields correctly";

    Account account = Account.builder()
            .firstName("MaxOne")
            .surNameInitial("X")
            .email("dsdsaa@aail.ru")
            .password("22282817")
            .confirmPassword("22282817")
            .yearBirth("1999")
            .gender("Other")
            .build();

    Account accountForCheckErrors = Account.builder()
            .firstName("MaxOne")
            .surNameInitial("X")
            .email("1sass@aail.ru")
            .password("22282817")
            .confirmPassword("22282817")
            .yearBirth("1999")
            .gender("Other")
            .build();

    @Test
    public void createAccountTest() {
        mainSteps
                .createAccount(account);
        feedPage
                .skipRegistrationMessage()
                .toValidationAccount()
                .accountValidation(account);
    }

    @Test
    public void emptyFirstName() {
        accountForCheckErrors.setFirstName("");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(accountForCheckErrors,typicalError);
    }

    @Test
    public void emptySurNameInitial() {
        accountForCheckErrors.setSurNameInitial("");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(accountForCheckErrors,typicalError);

    }

    @Test
    public void emptyEmail() {
        accountForCheckErrors.setEmail("");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(accountForCheckErrors,typicalError);
    }

    @Test
    public void emptyPassword() {
        accountForCheckErrors.setPassword("");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(accountForCheckErrors,typicalError);
    }

    @Test(expectedExceptions = ElementNotFound.class,priority = 1)
    public void mismatchedPassword() {
        accountForCheckErrors.setPassword("222222");
        accountForCheckErrors.setConfirmPassword("111111");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(accountForCheckErrors,typicalError);
    }

    @Test(priority = 2)
    public void createRegisteredAccount() {


        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(account,typicalError);
    }


}