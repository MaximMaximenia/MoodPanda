package tests;

import com.codeborne.selenide.ex.ElementNotFound;
import org.testng.annotations.Test;
import other.Account;

import java.util.Random;

public class CreateAccountTest extends BaseTest {
    Random random = new Random();

    Account account = Account.builder()
            .firstName("MaxOne")
            .surNameInitial("X")
            .email("1h" + random.nextInt(23132) + "owya@aail.ru")
            .password("22282817")
            .confirmPassword("22282817")
            .yearBirth("1999")
            .gender("Other")
            .build();

    @Test(priority = 1)
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
        account.setFirstName("");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(account);
    }

    @Test
    public void emptySurNameInitial() {
        account.setSurNameInitial("");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(account);

    }

    @Test
    public void emptyEmail() {
        account.setEmail("");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(account);
    }

    @Test
    public void emptyPassword() {
        account.setPassword("");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(account);
    }

    @Test(expectedExceptions = ElementNotFound.class)
    public void mismatchedPassword() {
        account.setPassword("222222");
        account.setConfirmPassword("111111");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(account);
    }

    @Test(expectedExceptions = ElementNotFound.class)
    public void createRegisteredAccount() {
        account.setPassword("222222");
        account.setConfirmPassword("111111");

        mainSteps
                .createAccountAndCheckThatErrorMessageAppeared(account);
    }


}